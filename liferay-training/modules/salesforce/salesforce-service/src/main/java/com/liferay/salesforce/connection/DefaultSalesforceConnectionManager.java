package com.liferay.salesforce.connection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class DefaultSalesforceConnectionManager
	implements SalesforceConnectionManager {

	public static SalesforceConnectionManager getInstance() {
		return _instance;
	}

	public SalesforceConnection getSalesforceConnection(long companyId, long ownerId) {
		try {
			return _getSalesforceConnection(companyId, ownerId);
		}
		catch (Exception e) {
			throw new IllegalStateException(
				"Unable to connect to Salesforce.com", e);
		}
	}

	@Override
	public void resetSalesforceConnection(long companyId, long ownerId) {
		_salesforceConnections.remove(companyId + "_" + ownerId);
	}

	private SalesforceConnection _getSalesforceConnection(long companyId, long ownerId)
		throws Exception {

		SalesforceConnection salesforceConnection = _salesforceConnections.get(
			companyId + "_" + ownerId);

		if (salesforceConnection == null) {
			salesforceConnection = new SalesforceConnection();

//			salesforceConnection.setPassword(
//				PrefsPortletPropsUtil.getString(
//					companyId, PortletPropsKeys.SALESFORCE_PASSWORD, ownerId));
//			salesforceConnection.setServerUrl(
//				PrefsPortletPropsUtil.getString(
//					companyId, PortletPropsKeys.SALESFORCE_SERVER_URL, ownerId));
//			
//			salesforceConnection.setUserName(
//				PrefsPortletPropsUtil.getString(
//					companyId, PortletPropsKeys.SALESFORCE_USER_NAME, ownerId));

			//Hardcode values for now.
			//Need to figure out a way to retrieve portletpreference from the service module
			//These are control panel configs for SFDC portlet
			
			salesforceConnection.setServerUrl("http://developer.salesforce.com");
			salesforceConnection.setPassword("liferay116cVJdJkaP8ftYa2Zep99XsqFj");
			salesforceConnection.setUserName("sales-engineering-na@liferay.com");
			
			
			salesforceConnection.login();

			_salesforceConnections.put(companyId + "_" + ownerId, salesforceConnection);
		}

		salesforceConnection.login();

		salesforceConnection.setUseDefaultAssignmentRule(true);

		return salesforceConnection;
	}

	private static SalesforceConnectionManager _instance =
		new DefaultSalesforceConnectionManager();

	private Map<String, SalesforceConnection> _salesforceConnections =
		new HashMap<String, SalesforceConnection>();

}