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
 * Provides the local service utility for SalesforceLead. This utility wraps
 * {@link com.liferay.salesforce.service.impl.SalesforceLeadLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLeadLocalService
 * @see com.liferay.salesforce.service.base.SalesforceLeadLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceLeadLocalServiceImpl
 * @generated
 */
@ProviderType
public class SalesforceLeadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceLeadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.messaging.MessageBatch getLeadsByCountry(
		long companyId, java.lang.String country,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeadsByCountry(companyId, country, fieldNames, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getLeadsBySource(
		long companyId, java.lang.String source,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeadsBySource(companyId, source, fieldNames, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getLeadsByStatus(
		long companyId, java.lang.String status,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeadsByStatus(companyId, status, fieldNames, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getLeadsByUserId(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeadsByUserId(companyId, userId, fieldNames, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getLeadsByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeadsByUserName(companyId, userName, fieldNames, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SalesforceLeadLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalesforceLeadLocalService, SalesforceLeadLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SalesforceLeadLocalService.class);
}