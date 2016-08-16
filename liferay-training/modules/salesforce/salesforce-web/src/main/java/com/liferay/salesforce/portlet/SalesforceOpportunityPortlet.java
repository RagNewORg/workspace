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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.salesforce.service.SalesforceAccountLocalServiceUtil;
import com.liferay.salesforce.service.SalesforceOpportunityLocalServiceUtil;
import com.liferay.salesforce.util.MessageBatchConverter;
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
				"javax.portlet.name=" + SalesforcePortletKeys.OPPORTUNITY_PORTLET_NAME,
				
				"javax.portlet.display-name=Salesforce Opportunity",
				"com.liferay.portlet.display-category=Salesforce",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.portlet-mode=text/html;view",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/html/opportunity/view.jsp",
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
public class SalesforceOpportunityPortlet extends MVCPortlet {

	public static String[] DETAIL_FIELD_NAMES = { "Id", "Amount", "CloseDate",
		"Description", "ExpectedRevenue", "Fiscal",
		"FiscalQuarter", "FiscalYear", "ForecastCategory",
		"ForecastCategoryName", "HasOpportunityLineItem", "IsClosed",
		"IsWon", "LastActivityDate", "LeadSource", "Name", "NextStep",
		"OwnerId", "Pricebook2Id", "Probability", "StageName",
		"TotalOpportunityQuantity", "Type" };

	public static String[] FIELD_NAMES = { "Id", "Amount", "CloseDate",
			"Description", "ExpectedRevenue", "Fiscal",
			"FiscalQuarter", "FiscalYear", "ForecastCategory",
			"ForecastCategoryName", "HasOpportunityLineItem", "IsClosed",
			"IsWon", "LastActivityDate", "LeadSource", "Name", "NextStep",
			"OwnerId", "Pricebook2Id", "Probability", "StageName",
			"TotalOpportunityQuantity", "Type" };

	@Override
	public void init() throws PortletException {
		super.init();
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(resourceResponse);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		response.setContentType("text");
		String requestMethod = ParamUtil.getString(resourceRequest, "type");

		resourceResponse.setContentType("text/javascript");
		String username = getUsername(resourceRequest);
		try {
			if (themeDisplay.isSignedIn() && (requestMethod != null)
					&& requestMethod.equals("opps") && username != null) {
				MessageBatch messageBatch = SalesforceOpportunityLocalServiceUtil
						.getOpportunitiesByUserName(
								PortalUtil.getDefaultCompanyId(), username,
								Arrays.asList(FIELD_NAMES),
								PortalUtil.getUserId(resourceRequest));
				response.getWriter().print(
						MessageBatchConverter.getJSONString(messageBatch));

				response.flushBuffer();
			} else if (themeDisplay.isSignedIn() && (requestMethod != null)
					&& requestMethod.equals("accountDetails")
					&& username != null) {

				String accountName = resourceRequest.getParameter("accountNm");

				MessageBatch messageBatch = SalesforceAccountLocalServiceUtil
						.getAccountsByName(PortalUtil.getDefaultCompanyId(),
								accountName, Arrays.asList(DETAIL_FIELD_NAMES),
								PortalUtil.getUserId(resourceRequest));
				response.getWriter().print(
						MessageBatchConverter
								.getPivotedJSONString(messageBatch));
				response.flushBuffer();
			} else {
				response.getWriter().print("");
				response.flushBuffer();
			}
		} catch (SystemException e) {
			e.printStackTrace();
			throw new PortletException("Unable to process request", e);
		}
	}

	private String getUsername(ResourceRequest resourceRequest)
			throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
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

}