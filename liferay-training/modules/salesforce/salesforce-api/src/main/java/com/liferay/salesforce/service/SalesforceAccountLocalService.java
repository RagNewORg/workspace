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
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the local service interface for SalesforceAccount. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceAccountLocalServiceUtil
 * @see com.liferay.salesforce.service.base.SalesforceAccountLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceAccountLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SalesforceAccountLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesforceAccountLocalServiceUtil} to access the salesforce account local service. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceAccountLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getAccountsByName(long companyId,
		java.lang.String name, List<java.lang.String> fieldNames, long ownerId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getAccountsByOwnerId(long companyId,
		java.lang.String ownerId, List<java.lang.String> fieldNames,
		long ownerID) throws ObjectNotFoundException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getAccountsByUserName(long companyId,
		java.lang.String userName, List<java.lang.String> fieldNames,
		long ownerId) throws ObjectNotFoundException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getFields(long companyId, long ownerId)
		throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();
}