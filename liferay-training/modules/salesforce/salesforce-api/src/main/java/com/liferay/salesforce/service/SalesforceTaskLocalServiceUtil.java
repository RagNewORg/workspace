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
 * Provides the local service utility for SalesforceTask. This utility wraps
 * {@link com.liferay.salesforce.service.impl.SalesforceTaskLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceTaskLocalService
 * @see com.liferay.salesforce.service.base.SalesforceTaskLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceTaskLocalServiceImpl
 * @generated
 */
@ProviderType
public class SalesforceTaskLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceTaskLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.messaging.MessageBatch getTasksByAccountId(
		long companyId, java.lang.String accountId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTasksByAccountId(companyId, accountId, fieldNames,
			ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getTasksByUserId(
		long companyId, java.lang.String userId,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTasksByUserId(companyId, userId, fieldNames, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch getTasksByUserName(
		long companyId, java.lang.String userName,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTasksByUserName(companyId, userName, fieldNames, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SalesforceTaskLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalesforceTaskLocalService, SalesforceTaskLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SalesforceTaskLocalService.class);
}