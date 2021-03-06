/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.salesforce.service.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.ObjectNotFoundException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.salesforce.connection.SalesforceConnection;
import com.liferay.salesforce.connection.SalesforceConnectionManager;
import com.liferay.salesforce.service.MultipleSalesforceException;
import com.liferay.salesforce.service.SalesforceException;
import com.liferay.salesforce.service.base.SalesforceLocalServiceBaseImpl;
import com.liferay.salesforce.util.DescribeSObjectResultConverter;
import com.liferay.salesforce.util.SObjectConverter;
import com.sforce.soap.partner.DeleteResult;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SearchResult;
import com.sforce.soap.partner.UpsertResult;
import com.sforce.soap.partner.sobject.SObject;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the salesforce local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.salesforce.service.SalesforceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.SalesforceLocalServiceUtil
 */
@ProviderType
public class SalesforceLocalServiceImpl extends SalesforceLocalServiceBaseImpl {

	public MessageBatch describeSObject(long companyId, String objectType, long ownerId)
		throws SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
				companyId, ownerId);

		DescribeSObjectResult sObject = salesforceConnection.describeSObject(
			objectType);

		MessageBatch mb = DescribeSObjectResultConverter.convert(sObject);

		return mb;
	}

	public void executeAdd(long companyId, List<Message> messages, long ownerId)
		throws MultipleSalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		List<SObject> sObjects = SObjectConverter.convert(messages);

		SaveResult[] saveResults = salesforceConnection.create(
			sObjects.toArray(new SObject[sObjects.size()]));

		MultipleSalesforceException multipleSalesforceException =
			new MultipleSalesforceException();

		for (int i = 0; i < saveResults.length; i++) {
			SaveResult saveResult = saveResults[i];

			if (saveResult.isSuccess()) {
				continue;
			}

			SaveResult firstSaveResult = saveResults[0];

			com.sforce.soap.partner.Error error = firstSaveResult.getErrors(0);

			multipleSalesforceException.addSalesforceError(error);
		}

		if (multipleSalesforceException.hasSalesforceError()) {
			throw multipleSalesforceException;
		}
	}

	public String executeAdd(long companyId, Message message, long ownerId)
		throws SalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		SObject sObject = SObjectConverter.convert(message);

		SaveResult[] saveResults = salesforceConnection.create(
			new SObject[] {sObject});

		SaveResult saveResult = saveResults[0];

		if (saveResult.isSuccess()) {
			return saveResult.getId();
		}

		com.sforce.soap.partner.Error error = saveResult.getErrors(0);

		throw new SalesforceException(error);
	}

	public void executeAddOrUpdate(
			long companyId, String externalId, List<Message> messages, long ownerId)
		throws MultipleSalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		List<SObject> sObjects = SObjectConverter.convert(messages);

		UpsertResult[] upsertResults = salesforceConnection.upsert(
			externalId, sObjects.toArray(new SObject[sObjects.size()]));

		MultipleSalesforceException multipleSalesforceException =
			new MultipleSalesforceException();

		for (int i = 0; i < upsertResults.length; i++) {
			UpsertResult upsertResult = upsertResults[i];

			if (upsertResult.isSuccess()) {
				continue;
			}

			UpsertResult firstUpsertResult = upsertResults[0];

			com.sforce.soap.partner.Error error = firstUpsertResult.getErrors(
				0);

			multipleSalesforceException.addSalesforceError(error);
		}

		if (multipleSalesforceException.hasSalesforceError()) {
			throw multipleSalesforceException;
		}
	}

	public void executeAddOrUpdate(
			long companyId, String externalId, Message message, long ownerId)
		throws SalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		SObject sObject = SObjectConverter.convert(message);

		UpsertResult[] upsertResults = salesforceConnection.upsert(
			externalId, new SObject[] {sObject});

		UpsertResult upsertResult = upsertResults[0];

		if (upsertResult.isSuccess()) {
			return;
		}

		com.sforce.soap.partner.Error error = upsertResult.getErrors(0);

		throw new SalesforceException(error);
	}

	public void executeDelete(long companyId, List<String> objectIds, long ownerId)
		throws MultipleSalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		DeleteResult[] deleteResults = salesforceConnection.delete(
			objectIds.toArray(new String[objectIds.size()]));

		MultipleSalesforceException multipleSalesforceException =
			new MultipleSalesforceException();

		for (int i = 0; i < deleteResults.length; i++) {
			DeleteResult deleteResult = deleteResults[i];

			if (deleteResult.isSuccess()) {
				continue;
			}

			DeleteResult firstDeleteResult = deleteResults[0];

			com.sforce.soap.partner.Error error = firstDeleteResult.getErrors(
				0);

			multipleSalesforceException.addSalesforceError(error);
		}

		if (multipleSalesforceException.hasSalesforceError()) {
			throw multipleSalesforceException;
		}
	}

	public boolean executeDelete(long companyId, String objectId, long ownerId)
		throws SalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		DeleteResult[] deleteResults = salesforceConnection.delete(
			new String[] {objectId});

		DeleteResult deleteResult = deleteResults[0];

		if (deleteResult.isSuccess()) {
			return true;
		}

		com.sforce.soap.partner.Error error = deleteResult.getErrors(0);

		throw new SalesforceException(error);
	}

	public MessageBatch executeQuery(long companyId, String queryString, long ownerId)
		throws SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		QueryResult queryResult = salesforceConnection.query(queryString);

		return SObjectConverter.convert(queryResult);
	}

	public Message executeQuery(
			long companyId, String objectId, String objectType,
			List<String> fieldNames, long ownerId)
		throws ObjectNotFoundException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		SObject[] sObjects = salesforceConnection.retrieve(
			StringUtil.merge(fieldNames), objectType, new String[] {objectId});

		if ((sObjects == null) || (sObjects.length == 0)) {
			throw new ObjectNotFoundException(objectId);
		}

		return SObjectConverter.convert(sObjects[0]);
	}

	public MessageBatch executeQueryMore(long companyId, String queryLocator, long ownerId)
		throws SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		QueryResult queryResults = salesforceConnection.queryMore(queryLocator);

		return SObjectConverter.convert(queryResults);
	}

	public MessageBatch executeSearch(long companyId, String searchString, long ownerId)
		throws SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		SearchResult searchResult = salesforceConnection.search(searchString);

		return SObjectConverter.convert(searchResult);
	}

	public void executeUpdate(long companyId, List<Message> messages, long ownerId)
		throws MultipleSalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		List<SObject> sObjects = SObjectConverter.convert(messages);

		SaveResult[] saveResults = salesforceConnection.update(
			sObjects.toArray(new SObject[sObjects.size()]));

		MultipleSalesforceException multipleSalesforceException =
			new MultipleSalesforceException();

		for (int i = 0; i < saveResults.length; i++) {
			SaveResult saveResult = saveResults[i];

			if (saveResult.isSuccess()) {
				continue;
			}

			SaveResult firstSaveResult = saveResults[0];

			com.sforce.soap.partner.Error error = firstSaveResult.getErrors(0);

			multipleSalesforceException.addSalesforceError(error);
		}

		if (multipleSalesforceException.hasSalesforceError()) {
			throw multipleSalesforceException;
		}
	}

	public void executeUpdate(long companyId, Message message, long ownerId)
		throws SalesforceException, SystemException {

		SalesforceConnection salesforceConnection = getSalesforceConnection(
			companyId, ownerId);

		SObject sObject = SObjectConverter.convert(message);

		SaveResult[] saveResults = salesforceConnection.update(
			new SObject[] {sObject});

		SaveResult saveResult = saveResults[0];

		if (saveResult.isSuccess()) {
			return;
		}

		com.sforce.soap.partner.Error error = saveResult.getErrors(0);

		throw new SalesforceException(error);
	}

	protected SalesforceConnection getSalesforceConnection(long companyId, long ownerId) {
		return _salesforceConnectionManager.getSalesforceConnection(companyId, ownerId);
	}

	protected void setSalesforceConnectionManager(
		SalesforceConnectionManager salesforceConnectionManager) {

		_salesforceConnectionManager = salesforceConnectionManager;
	}

	@BeanReference(type = SalesforceConnectionManager.class)
	private SalesforceConnectionManager _salesforceConnectionManager;

}