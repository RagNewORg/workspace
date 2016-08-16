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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SalesforceOpportunity. This utility wraps
 * {@link com.liferay.salesforce.service.impl.SalesforceOpportunityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceOpportunityLocalService
 * @see com.liferay.salesforce.service.base.SalesforceOpportunityLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceOpportunityLocalServiceImpl
 * @generated
 */
@ProviderType
public class SalesforceOpportunityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceOpportunityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.messaging.MessageBatch getOpportunitiesByAccountId(
		long companyId, java.lang.String accountId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOpportunitiesByAccountId(companyId, accountId,
			fieldNames, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getOpportunitiesByUserId(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOpportunitiesByUserId(companyId, userId, fieldNames,
			ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getOpportunitiesByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOpportunitiesByUserName(companyId, userName, fieldNames,
			ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SalesforceOpportunityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalesforceOpportunityLocalService, SalesforceOpportunityLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SalesforceOpportunityLocalService.class);
}