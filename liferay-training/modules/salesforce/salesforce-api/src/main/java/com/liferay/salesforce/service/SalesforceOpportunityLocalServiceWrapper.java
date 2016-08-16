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
 * Provides a wrapper for {@link SalesforceOpportunityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceOpportunityLocalService
 * @generated
 */
@ProviderType
public class SalesforceOpportunityLocalServiceWrapper
	implements SalesforceOpportunityLocalService,
		ServiceWrapper<SalesforceOpportunityLocalService> {
	public SalesforceOpportunityLocalServiceWrapper(
		SalesforceOpportunityLocalService salesforceOpportunityLocalService) {
		_salesforceOpportunityLocalService = salesforceOpportunityLocalService;
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getOpportunitiesByAccountId(
		long companyId, java.lang.String accountId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceOpportunityLocalService.getOpportunitiesByAccountId(companyId,
			accountId, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getOpportunitiesByUserId(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceOpportunityLocalService.getOpportunitiesByUserId(companyId,
			userId, fieldNames, ownerId);
	}

	@Override
	public com.liferay.portal.kernel.messaging.MessageBatch getOpportunitiesByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return _salesforceOpportunityLocalService.getOpportunitiesByUserName(companyId,
			userName, fieldNames, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salesforceOpportunityLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public SalesforceOpportunityLocalService getWrappedService() {
		return _salesforceOpportunityLocalService;
	}

	@Override
	public void setWrappedService(
		SalesforceOpportunityLocalService salesforceOpportunityLocalService) {
		_salesforceOpportunityLocalService = salesforceOpportunityLocalService;
	}

	private SalesforceOpportunityLocalService _salesforceOpportunityLocalService;
}