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
 * Provides a wrapper for {@link SalesforceEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceEventLocalService
 * @generated
 */
@ProviderType
public class SalesforceEventLocalServiceWrapper
	implements SalesforceEventLocalService,
		ServiceWrapper<SalesforceEventLocalService> {
	public SalesforceEventLocalServiceWrapper(
		SalesforceEventLocalService salesforceEventLocalService) {
		_salesforceEventLocalService = salesforceEventLocalService;
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getEventsByAccountId(
		long companyId, java.lang.String accountId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceEventLocalService.getEventsByAccountId(companyId,
			accountId, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getEventsByUser(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceEventLocalService.getEventsByUser(companyId, userId,
			fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getEventsByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceEventLocalService.getEventsByUserName(companyId,
			userName, fieldNames, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salesforceEventLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesforceEventLocalService getWrappedService() {
		return _salesforceEventLocalService;
	}

	@Override
	public void setWrappedService(
		SalesforceEventLocalService salesforceEventLocalService) {
		_salesforceEventLocalService = salesforceEventLocalService;
	}

	private SalesforceEventLocalService _salesforceEventLocalService;
}