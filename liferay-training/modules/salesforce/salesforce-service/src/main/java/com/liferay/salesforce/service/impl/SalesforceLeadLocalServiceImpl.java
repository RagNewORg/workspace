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

package com.liferay.salesforce.service.impl;

import com.liferay.portal.kernel.dao.orm.ObjectNotFoundException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.salesforce.query.Condition;
import com.liferay.salesforce.query.ConditionImpl;
import com.liferay.salesforce.query.builder.SelectQuery;
import com.liferay.salesforce.service.base.SalesforceLeadLocalServiceBaseImpl;
import com.liferay.salesforce.util.SalesforceObjectNames;

import java.util.Arrays;
import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the salesforce lead local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.salesforce.service.SalesforceLeadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceLeadLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.SalesforceLeadLocalServiceUtil
 */
@ProviderType
public class SalesforceLeadLocalServiceImpl
extends SalesforceLeadLocalServiceBaseImpl {

public MessageBatch getLeadsByCountry(
		long companyId, String country, List<String> fieldNames, long ownerId)
	throws SystemException {

	Condition condition = ConditionImpl.EQUALS("Country", country);

	return executeQuery(companyId, fieldNames, condition, ownerId);
}

public MessageBatch getLeadsBySource(
		long companyId, String source, List<String> fieldNames, long ownerId)
	throws SystemException {

	Condition condition = ConditionImpl.EQUALS("LeadSource", source);

	return executeQuery(companyId, fieldNames, condition, ownerId);
}

public MessageBatch getLeadsByStatus(
		long companyId, String status, List<String> fieldNames, long ownerId)
	throws SystemException {

	Condition condition = ConditionImpl.EQUALS("Status", status);

	return executeQuery(companyId, fieldNames, condition, ownerId);
}

public MessageBatch getLeadsByUserId(
		long companyId, String userId, List<String> fieldNames, long ownerId)
	throws ObjectNotFoundException, SystemException {

	Condition condition = ConditionImpl.EQUALS("OwnerId", userId);

	return executeQuery(companyId, fieldNames, condition, ownerId);
}

public MessageBatch getLeadsByUserName(
		long companyId, String userName, List<String> fieldNames, long ownerId)
	throws ObjectNotFoundException, SystemException {

	Condition condition = ConditionImpl.EQUALS("Owner.Username", userName);

	return executeQuery(companyId, fieldNames, condition, ownerId);
}

protected MessageBatch executeQuery(
		long companyId, List<String> fieldNames, Condition condition, long ownerId)
	throws SystemException {

	String query = SelectQuery.build(
		SalesforceObjectNames.LEAD, fieldNames, condition,
		_orderByFieldNames);

	return salesforceLocalService.executeQuery(companyId, query, ownerId);
}

private static List<String> _orderByFieldNames = Arrays.asList(
	"LastActivityDate");

}