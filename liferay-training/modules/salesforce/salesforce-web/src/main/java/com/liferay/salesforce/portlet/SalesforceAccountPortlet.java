package com.liferay.salesforce.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.MessageBatch;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.salesforce.service.SalesforceAccountLocalServiceUtil;
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

//Refer to https://docs.liferay.com/portal/7.0/definitions/liferay-portlet-app_7_0_0.dtd.html
@Component(
	immediate = true,
	property = {
			/* This property is one of two that must be included in each MVC command component;
			 * it links a particular portlet URL/command combination to the correct portlet.
			 */
			"javax.portlet.name=" + SalesforcePortletKeys.ACCOUNT_PORTLET_NAME,
			
			"javax.portlet.display-name=Salesforce Account",
			"com.liferay.portlet.display-category=Salesforce",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.portlet-mode=text/html;view",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/accounts/view.jsp",
			//Remove edit if not used
			"javax.portlet.init-param.edit-template=/admin/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=administrator,power-user,user"
	},
	service = Portlet.class
)
/**
* @author Keval Mehta
*/
public class SalesforceAccountPortlet extends MVCPortlet {

	public static String[] DETAIL_FIELD_NAMES = { "accountNumber",
			"annualRevenue", "billingCity", "billingCountry",
			"billingPostalCode", "billingState", "billingStreet",
			"description", "fax", "industry", "lastActivityDate", "name",
			"numberOfEmployees", "numberofLocations__c", "phone", "rating",
			"SLA__c", "shippingCity", "shippingCountry", "shippingPostalCode",
			"shippingState", "shippingStreet", "site", "tickerSymbol", "type",
			"upsellOpportunity__c", "website" };

	public static String[] FIELD_NAMES = { "Name", "numberOfEmployees", "Id",
			"Industry", "billingState", "billingCity", "rating", "description" };

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
					&& requestMethod.equals("accounts") && username != null) {
				MessageBatch messageBatch = SalesforceAccountLocalServiceUtil
						.getAccountsByUserName(
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