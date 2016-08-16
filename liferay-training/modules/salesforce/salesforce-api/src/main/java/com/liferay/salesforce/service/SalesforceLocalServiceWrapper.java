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

package com.liferay.salesforce.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SalesforceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLocalService
 * @generated
 */
@ProviderType
public class SalesforceLocalServiceWrapper implements SalesforceLocalService,
	ServiceWrapper<SalesforceLocalService> {
	public SalesforceLocalServiceWrapper(
		SalesforceLocalService salesforceLocalService) {
		_salesforceLocalService = salesforceLocalService;
	}

	@Override
	public boolean executeDelete(long companyId, java.lang.String objectId,
		long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.executeDelete(companyId, objectId,
			ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message executeQuery(
		long companyId, java.lang.String objectId, java.lang.String objectType,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.executeQuery(companyId, objectId,
			objectType, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch describeSObject(
		long companyId, java.lang.String objectType, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.describeSObject(companyId, objectType,
			ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch executeQuery(
		long companyId, java.lang.String queryString, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.executeQuery(companyId, queryString,
			ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch executeQueryMore(
		long companyId, java.lang.String queryLocator, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.executeQueryMore(companyId,
			queryLocator, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch executeSearch(
		long companyId, java.lang.String searchString, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.executeSearch(companyId, searchString,
			ownerId);
	}

	@Override
	public java.lang.String executeAdd(long companyId,
		com.liferay.portal.kernel.messaging.Message message, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLocalService.executeAdd(companyId, message, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salesforceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void executeAdd(long companyId,
		java.util.List<com.liferay.portal.kernel.messaging.Message> messages,
		long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		_salesforceLocalService.executeAdd(companyId, messages, ownerId);
	}

	@Override
	public void executeAddOrUpdate(long companyId, java.lang.String externalId,
		com.liferay.portal.kernel.messaging.Message message, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		_salesforceLocalService.executeAddOrUpdate(companyId, externalId,
			message, ownerId);
	}

	@Override
	public void executeAddOrUpdate(long companyId, java.lang.String externalId,
		java.util.List<com.liferay.portal.kernel.messaging.Message> messages,
		long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		_salesforceLocalService.executeAddOrUpdate(companyId, externalId,
			messages, ownerId);
	}

	@Override
	public void executeDelete(long companyId,
		java.util.List<java.lang.String> objectIds, long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		_salesforceLocalService.executeDelete(companyId, objectIds, ownerId);
	}

	@Override
	public void executeUpdate(long companyId,
		com.liferay.portal.kernel.messaging.Message message, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		_salesforceLocalService.executeUpdate(companyId, message, ownerId);
	}

	@Override
	public void executeUpdate(long companyId,
		java.util.List<com.liferay.portal.kernel.messaging.Message> messages,
		long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		_salesforceLocalService.executeUpdate(companyId, messages, ownerId);
	}

	@Override
	public SalesforceLocalService getWrappedService() {
		return _salesforceLocalService;
	}

	@Override
	public void setWrappedService(SalesforceLocalService salesforceLocalService) {
		_salesforceLocalService = salesforceLocalService;
	}

	private SalesforceLocalService _salesforceLocalService;
}