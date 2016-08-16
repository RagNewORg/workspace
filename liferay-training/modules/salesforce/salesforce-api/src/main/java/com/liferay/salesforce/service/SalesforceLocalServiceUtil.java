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
 * Provides the local service utility for Salesforce. This utility wraps
 * {@link com.liferay.salesforce.service.impl.SalesforceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLocalService
 * @see com.liferay.salesforce.service.base.SalesforceLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.impl.SalesforceLocalServiceImpl
 * @generated
 */
@ProviderType
public class SalesforceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.salesforce.service.impl.SalesforceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean executeDelete(long companyId,
		java.lang.String objectId, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().executeDelete(companyId, objectId, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.Message executeQuery(
		long companyId, java.lang.String objectId, java.lang.String objectType,
		java.util.List<java.lang.String> fieldNames, long ownerId)
		throws com.liferay.portal.kernel.dao.orm.ObjectNotFoundException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .executeQuery(companyId, objectId, objectType, fieldNames,
			ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch describeSObject(
		long companyId, java.lang.String objectType, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().describeSObject(companyId, objectType, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch executeQuery(
		long companyId, java.lang.String queryString, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().executeQuery(companyId, queryString, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch executeQueryMore(
		long companyId, java.lang.String queryLocator, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().executeQueryMore(companyId, queryLocator, ownerId);
	}

	public static com.liferay.portal.kernel.messaging.MessageBatch executeSearch(
		long companyId, java.lang.String searchString, long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().executeSearch(companyId, searchString, ownerId);
	}

	public static java.lang.String executeAdd(long companyId,
		com.liferay.portal.kernel.messaging.Message message, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().executeAdd(companyId, message, ownerId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void executeAdd(long companyId,
		java.util.List<com.liferay.portal.kernel.messaging.Message> messages,
		long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeAdd(companyId, messages, ownerId);
	}

	public static void executeAddOrUpdate(long companyId,
		java.lang.String externalId,
		com.liferay.portal.kernel.messaging.Message message, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeAddOrUpdate(companyId, externalId, message, ownerId);
	}

	public static void executeAddOrUpdate(long companyId,
		java.lang.String externalId,
		java.util.List<com.liferay.portal.kernel.messaging.Message> messages,
		long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeAddOrUpdate(companyId, externalId, messages, ownerId);
	}

	public static void executeDelete(long companyId,
		java.util.List<java.lang.String> objectIds, long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeDelete(companyId, objectIds, ownerId);
	}

	public static void executeUpdate(long companyId,
		com.liferay.portal.kernel.messaging.Message message, long ownerId)
		throws SalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeUpdate(companyId, message, ownerId);
	}

	public static void executeUpdate(long companyId,
		java.util.List<com.liferay.portal.kernel.messaging.Message> messages,
		long ownerId)
		throws MultipleSalesforceException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeUpdate(companyId, messages, ownerId);
	}

	public static SalesforceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalesforceLocalService, SalesforceLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SalesforceLocalService.class);
}