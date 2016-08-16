/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.salesforce.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.salesforce.service.SalesforceContactLocalServiceUtil;
import com.liferay.salesforce.util.MessageBatchConverter;
import com.liferay.salesforce.util.PortletPropsKeys;
import com.liferay.salesforce.util.PrefsPortletPropsUtil;

import java.io.IOException;
import java.util.Arrays;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
				/* This property is one of two that must be included in each MVC command component;
				 * it links a particular portlet URL/command combination to the correct portlet.
				 */
				"javax.portlet.name=" + SalesforcePortletKeys.CONTACTS_PORTLET_NAME,
				
				"javax.portlet.display-name=Salesforce Contacts",
				"com.liferay.portlet.display-category=Salesforce",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.portlet-mode=text/html;view",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/html/contacts/view.jsp",
				//Remove edit-template if not used
				"javax.portlet.init-param.edit-template=/admin/view.jsp",
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=administrator,power-user,user"
		},
		service = Portlet.class
	)
/**
 * @author Keval Mehta
 */
public class SalesforceContactsPortlet extends MVCPortlet {

	public static String[] DETAIL_FIELD_NAMES = { "name", "department",
			"email", "mobilePhone", "title", "accountId" };

	public static String[] FIELD_NAMES = { "name", "department", "email",
			"mobilePhone", "title","accountId" };

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		HttpServletResponse httpServletResponse = PortalUtil
				.getHttpServletResponse(resourceResponse);
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		httpServletResponse.setContentType(ContentTypes.TEXT);

		String requestMethod = ParamUtil.getString(resourceRequest, "type");

		resourceResponse.setContentType(ContentTypes.TEXT_JAVASCRIPT);
		String username = getUsername(resourceRequest);
		try {
			if (themeDisplay.isSignedIn() && (requestMethod != null) &&
				requestMethod.equals(_CONTACTS) && username!=null) {
				MessageBatch messageBatch = SalesforceContactLocalServiceUtil
						.getContactsByUserName(
								PortalUtil.getDefaultCompanyId(), username,
								Arrays.asList(FIELD_NAMES),
								PortalUtil.getUserId(resourceRequest));

				httpServletResponse.getWriter().print(
						MessageBatchConverter.getJSONString(messageBatch));

				httpServletResponse.flushBuffer();
			} else if (themeDisplay.isSignedIn() && (requestMethod != null) &&
					 requestMethod.equals(_CONTACTS_FOR_ACCOUNT) && username!=null) {

				String accountId = resourceRequest.getParameter("accId");
				MessageBatch messageBatch = SalesforceContactLocalServiceUtil
						.getContactsByAccountId(
								PortalUtil.getDefaultCompanyId(), accountId,
								Arrays.asList(FIELD_NAMES),
								PortalUtil.getUserId(resourceRequest));

				httpServletResponse.getWriter().print(
						MessageBatchConverter.getJSONString(messageBatch));

				httpServletResponse.flushBuffer();
			} else {
				httpServletResponse.getWriter().print("");
				httpServletResponse.flushBuffer();
			}
		} catch (SystemException e) {
			throw new PortletException("Unable to process request", e);
		}
	}

	private String getUsername(ResourceRequest resourceRequest)
			throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			PortletPreferences preferences = PrefsPortletPropsUtil
					.getPortletPreferences(themeDisplay.getCompanyId(),
							themeDisplay.getUserId());

//			return preferences.getValue(PortletPropsKeys.SALESFORCE_USER_NAME,
//					null);
			
			//Hardcode username for now. Then build control panel access later to set username/password config
			return("sales-engineering-na@liferay.com");
			
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	private static final String _CONTACTS = "contacts";

	private static final String _CONTACTS_FOR_ACCOUNT = "contactsForAccount";

}