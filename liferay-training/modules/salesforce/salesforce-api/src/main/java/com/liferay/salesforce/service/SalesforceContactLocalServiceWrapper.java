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
 * Provides a wrapper for {@link SalesforceContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceContactLocalService
 * @generated
 */
@ProviderType
public class SalesforceContactLocalServiceWrapper
	implements SalesforceContactLocalService,
		ServiceWrapper<SalesforceContactLocalService> {
	public SalesforceContactLocalServiceWrapper(
		SalesforceContactLocalService salesforceContactLocalService) {
		_salesforceContactLocalService = salesforceContactLocalService;
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getContactsByAccountId(
		long companyId, java.lang.String accountId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceContactLocalService.getContactsByAccountId(companyId,
			accountId, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getContactsByOwnerId(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceContactLocalService.getContactsByOwnerId(companyId,
			userId, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getContactsByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceContactLocalService.getContactsByUserName(companyId,
			userName, fieldNames, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salesforceContactLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesforceContactLocalService getWrappedService() {
		return _salesforceContactLocalService;
	}

	@Override
	public void setWrappedService(
		SalesforceContactLocalService salesforceContactLocalService) {
		_salesforceContactLocalService = salesforceContactLocalService;
	}

	private SalesforceContactLocalService _salesforceContactLocalService;
}