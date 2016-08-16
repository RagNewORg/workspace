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
 * Provides the local service interface for SalesforceLead. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLeadLocalServiceUtil
 * @see com.liferay.salesforce.service.base.SalesforceLeadLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceLeadLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SalesforceLeadLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesforceLeadLocalServiceUtil} to access the salesforce lead local service. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceLeadLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getLeadsByCountry(long companyId,
		java.lang.String country, List<java.lang.String> fieldNames,
		long ownerId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getLeadsBySource(long companyId,
		java.lang.String source, List<java.lang.String> fieldNames, long ownerId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getLeadsByStatus(long companyId,
		java.lang.String status, List<java.lang.String> fieldNames, long ownerId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getLeadsByUserId(long companyId,
		java.lang.String userId, List<java.lang.String> fieldNames, long ownerId)
		throws ObjectNotFoundException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MessageBatch getLeadsByUserName(long companyId,
		java.lang.String userName, List<java.lang.String> fieldNames,
		long ownerId) throws ObjectNotFoundException, SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();
}