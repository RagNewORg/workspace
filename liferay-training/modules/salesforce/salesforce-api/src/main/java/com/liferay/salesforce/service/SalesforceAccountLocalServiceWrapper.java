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
 * Provides a wrapper for {@link SalesforceAccountLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceAccountLocalService
 * @generated
 */
@ProviderType
public class SalesforceAccountLocalServiceWrapper
	implements SalesforceAccountLocalService,
		ServiceWrapper<SalesforceAccountLocalService> {
	public SalesforceAccountLocalServiceWrapper(
		SalesforceAccountLocalService salesforceAccountLocalService) {
		_salesforceAccountLocalService = salesforceAccountLocalService;
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getAccountsByName(
		long companyId, java.lang.String name,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getAccountsByName(companyId,
			name, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getAccountsByOwnerId(
		long companyId, java.lang.String ownerId,
		java.util.List<java.lang.String> fieldNames, long ownerID)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getAccountsByOwnerId(companyId,
			ownerId, fieldNames, ownerID);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getAccountsByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getAccountsByUserName(companyId,
			userName, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getFields(
		long companyId, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceAccountLocalService.getFields(companyId, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salesforceAccountLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesforceAccountLocalService getWrappedService() {
		return _salesforceAccountLocalService;
	}

	@Override
	public void setWrappedService(
		SalesforceAccountLocalService salesforceAccountLocalService) {
		_salesforceAccountLocalService = salesforceAccountLocalService;
	}

	private SalesforceAccountLocalService _salesforceAccountLocalService;
}