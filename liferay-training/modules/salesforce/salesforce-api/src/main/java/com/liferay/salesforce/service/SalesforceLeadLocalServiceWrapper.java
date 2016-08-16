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
 * Provides a wrapper for {@link SalesforceLeadLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLeadLocalService
 * @generated
 */
@ProviderType
public class SalesforceLeadLocalServiceWrapper
	implements SalesforceLeadLocalService,
		ServiceWrapper<SalesforceLeadLocalService> {
	public SalesforceLeadLocalServiceWrapper(
		SalesforceLeadLocalService salesforceLeadLocalService) {
		_salesforceLeadLocalService = salesforceLeadLocalService;
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getLeadsByCountry(
		long companyId, java.lang.String country,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLeadLocalService.getLeadsByCountry(companyId,
			country, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getLeadsBySource(
		long companyId, java.lang.String source,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLeadLocalService.getLeadsBySource(companyId, source,
			fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getLeadsByStatus(
		long companyId, java.lang.String status,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLeadLocalService.getLeadsByStatus(companyId, status,
			fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getLeadsByUserId(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLeadLocalService.getLeadsByUserId(companyId, userId,
			fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getLeadsByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceLeadLocalService.getLeadsByUserName(companyId,
			userName, fieldNames, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salesforceLeadLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesforceLeadLocalService getWrappedService() {
		return _salesforceLeadLocalService;
	}

	@Override
	public void setWrappedService(
		SalesforceLeadLocalService salesforceLeadLocalService) {
		_salesforceLeadLocalService = salesforceLeadLocalService;
	}

	private SalesforceLeadLocalService _salesforceLeadLocalService;
}