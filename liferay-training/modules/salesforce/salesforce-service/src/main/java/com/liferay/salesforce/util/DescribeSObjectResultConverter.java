/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.salesforce.util;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBatch;

import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Keval Mehta
 */
public class DescribeSObjectResultConverter {

	public static MessageBatch convert(
		DescribeSObjectResult describeSObjectResult) {

		if (describeSObjectResult == null) {
			return new MessageBatch(0);
		}

		MessageBatch mb = new MessageBatch(1);

		Message message = new Message();

		Map<String, ExternalField> map = new HashMap<String, ExternalField>();

		for (int i = 0; i < describeSObjectResult.getFields().length; i++) {
			Field field = describeSObjectResult.getFields()[i];

			map.put(field.getName(), convert(field));
		}

		message.setPayload(map);

		mb.addMessage(message);

		return mb;
	}

	private static ExternalField convert(Field field) {
		ExternalField efield = new ExternalField();

		efield.setName(field.getName());
		efield.setValue(field.getLabel());

		return efield;
	}

}