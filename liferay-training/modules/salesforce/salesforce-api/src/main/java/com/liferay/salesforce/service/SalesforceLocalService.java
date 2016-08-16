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

import com.liferay.portal.kernel.dao.orm.ObjectNotFoundException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the local service interface for Salesforce. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLocalServiceUtil
 * @see com.liferay.salesforce.service.base.SalesforceLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SalesforceLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesforceLocalServiceUtil} to access the salesforce local service. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean executeDelete(long companyId, java.lang.String objectId,
		long ownerId) throws SystemException, SalesforceException;

	public Message executeQuery(long companyId, java.lang.String objectId,
		java.lang.String objectType, List<java.lang.String> fieldNames,
		long ownerId) throws ObjectNotFoundException, SystemException;

	public MessageBatch describeSObject(long companyId,
		java.lang.String objectType, long ownerId) throws SystemException;

	public MessageBatch executeQuery(long companyId,
		java.lang.String queryString, long ownerId) throws SystemException;

	public MessageBatch executeQueryMore(long companyId,
		java.lang.String queryLocator, long ownerId) throws SystemException;

	public MessageBatch executeSearch(long companyId,
		java.lang.String searchString, long ownerId) throws SystemException;

	public java.lang.String executeAdd(long companyId, Message message,
		long ownerId) throws SystemException, SalesforceException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public void executeAdd(long companyId, List<Message> messages, long ownerId)
		throws SystemException, MultipleSalesforceException;

	public void executeAddOrUpdate(long companyId, java.lang.String externalId,
		Message message, long ownerId)
		throws SystemException, SalesforceException;

	public void executeAddOrUpdate(long companyId, java.lang.String externalId,
		List<Message> messages, long ownerId)
		throws SystemException, MultipleSalesforceException;

	public void executeDelete(long companyId, List<java.lang.String> objectIds,
		long ownerId) throws SystemException, MultipleSalesforceException;

	public void executeUpdate(long companyId, Message message, long ownerId)
		throws SystemException, SalesforceException;

	public void executeUpdate(long companyId, List<Message> messages,
		long ownerId) throws SystemException, MultipleSalesforceException;
}