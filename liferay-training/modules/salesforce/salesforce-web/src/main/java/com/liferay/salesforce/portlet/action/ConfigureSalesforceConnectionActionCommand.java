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
package com.liferay.salesforce.portlet.action;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.salesforce.connection.SalesforceConnectionManager;
import com.liferay.salesforce.portlet.SalesforcePortletKeys;
import com.liferay.salesforce.service.ClpSerializer;
import com.liferay.salesforce.util.PortletPropsKeys;
import com.liferay.salesforce.util.PrefsPortletPropsUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;


@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SalesforcePortletKeys.ACCOUNT_PORTLET_NAME,
        "mvc.command.name=salesforceweb"
    },
    service = MVCActionCommand.class
)
public class ConfigureSalesforceConnectionActionCommand extends BaseMVCActionCommand {
	


	private static final Log _log = LogFactoryUtil.getLog(
			ConfigureSalesforceConnectionActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String salesforceServerURL = ParamUtil.getString(
				actionRequest, "salesforceServerURL");
			String salesforceUserName = ParamUtil.getString(
				actionRequest, "salesforceUserName");
			String salesforcePassword = ParamUtil.getString(
				actionRequest, "salesforcePassword");
			String salesforceClientKey = ParamUtil.getString(
					actionRequest, "salesforceClientKey");
			String salesforceClientSecret = ParamUtil.getString(
					actionRequest, "salesforceClientSecret");

			if (Validator.isNull(salesforceUserName)) {
				SessionErrors.add(actionRequest, "userNameRequired");
			}
			else if (Validator.isNull(salesforcePassword)) {
				SessionErrors.add(actionRequest, "passwordRequired");
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			PortletPreferences preferences =
				PrefsPortletPropsUtil.getPortletPreferences(
					themeDisplay.getCompanyId(), themeDisplay.getUserId());

			preferences.setValue(
				PortletPropsKeys.SALESFORCE_PASSWORD, salesforcePassword);
			preferences.setValue(
				PortletPropsKeys.SALESFORCE_SERVER_URL, salesforceServerURL);
			preferences.setValue(
				PortletPropsKeys.SALESFORCE_USER_NAME, salesforceUserName);
			preferences.setValue(
					PortletPropsKeys.SALESFORCE_CLIENT_KEY, salesforceClientKey);
			preferences.setValue(
					PortletPropsKeys.SALESFORCE_CLIENT_SECRET, salesforceClientSecret);
			SalesforceConnectionManager salesforceConnectionManager =
					(SalesforceConnectionManager)PortletBeanLocatorUtil.locate(
						ClpSerializer.getServletContextName(),
						SalesforceConnectionManager.class.getName());

			salesforceConnectionManager.resetSalesforceConnection(themeDisplay.getCompanyId(), themeDisplay.getUserId());
			try {
				preferences.store();
			}
			catch (Exception e) {
				_log.error(e);
			}

			if (!testSalesforceConnection(themeDisplay.getCompanyId(), themeDisplay.getUserId())) {
				SessionErrors.add(actionRequest, "connectionFailed");
			}

			_log.info("Saved Preferences");
		
	}
	
	protected boolean testSalesforceConnection(long companyId, long ownerId) {
		try {
			SalesforceConnectionManager salesforceConnectionManager =
				(SalesforceConnectionManager)PortletBeanLocatorUtil.locate(
					ClpSerializer.getServletContextName(),
					SalesforceConnectionManager.class.getName());

			salesforceConnectionManager.getSalesforceConnection(companyId, ownerId);

			return true;
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return false;
	}
}