package com.liferay.salesforce.util;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.portal.kernel.util.StringPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;


/**
 * @author Keval Mehta
 */
public class MessageBatchConverter {

	public static String getJSONString(MessageBatch messageBatch) {

		if ((messageBatch == null) || messageBatch.getMessages().isEmpty()) {
			return StringPool.BLANK;
		}

		List<Message> messages = messageBatch.getMessages();

		JSONArray array = new JSONArray();

		for (Message message : messages) {
			Map payload = (Map)message.getPayload();

			payload.putAll(message.getValues());

			array.put(message.getPayload());
		}

		return array.toString();
	}

	public static String getPivotedJSONString(MessageBatch messageBatch) {
		if ((messageBatch == null) || messageBatch.getMessages().isEmpty()) {
			return StringPool.BLANK;
		}

		List<Message> messages = messageBatch.getMessages();

		JSONArray array = new JSONArray();

		for (Message message : messages) {
			Map<String, String> payload = (Map)message.getPayload();

			for (Map.Entry<String, String> entry :payload.entrySet()) {
				Map<String, String> map = new HashMap<String, String>();

				map.put("fieldName", entry.getKey());

				map.put("fieldValue", entry.getValue());

				array.put(map);
			}
		}

		return array.toString();
	}

}
