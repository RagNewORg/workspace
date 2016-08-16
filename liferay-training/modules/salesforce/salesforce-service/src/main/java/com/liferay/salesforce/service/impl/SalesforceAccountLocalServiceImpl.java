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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.salesforce.query.Condition;
import com.liferay.salesforce.query.ConditionImpl;
import com.liferay.salesforce.query.builder.SelectQuery;
import com.liferay.salesforce.service.base.SalesforceAccountLocalServiceBaseImpl;
import com.liferay.salesforce.util.SalesforceObjectNames;

import java.util.Arrays;
import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the salesforce account local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.salesforce.service.SalesforceAccountLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesforceAccountLocalServiceBaseImpl
 * @see com.liferay.salesforce.service.SalesforceAccountLocalServiceUtil
 */
@ProviderType
public class SalesforceAccountLocalServiceImpl
extends SalesforceAccountLocalServiceBaseImpl {

public MessageBatch getAccountsByName(
	long companyId, String name, List<String> fieldNames, long ownerId)
throws SystemException {

Condition condition = ConditionImpl.LIKE(
	"Name", StringUtil.quote(name, StringPool.PERCENT));

return executeQuery(companyId, fieldNames, condition, ownerId);
}

public MessageBatch getAccountsByOwnerId(
	long companyId, String ownerId, List<String> fieldNames, long ownerID)
throws ObjectNotFoundException, SystemException {

Condition condition = ConditionImpl.EQUALS("OwnerId", ownerId);

return executeQuery(companyId, fieldNames, condition, ownerID);
}

public MessageBatch getAccountsByUserName(
	long companyId, String userName, List<String> fieldNames, long ownerId)
throws ObjectNotFoundException, SystemException {

Condition condition = ConditionImpl.EQUALS("Owner.Username", userName);

return executeQuery(companyId, fieldNames, condition, ownerId);
}

public MessageBatch getFields(long companyId, long ownerId) throws SystemException {
return salesforceLocalService.describeSObject(companyId, "account", ownerId);
}

protected MessageBatch executeQuery(
	long companyId, List<String> fieldNames, Condition condition, long ownerId)
throws SystemException {

String query = SelectQuery.build(
	SalesforceObjectNames.ACCOUNT, fieldNames, condition,
	_ORDER_BY_FIELD_NAMES);

return salesforceLocalService.executeQuery(companyId, query, ownerId);
}

private static final List<String> _ORDER_BY_FIELD_NAMES = Arrays.asList(
"Name");

}