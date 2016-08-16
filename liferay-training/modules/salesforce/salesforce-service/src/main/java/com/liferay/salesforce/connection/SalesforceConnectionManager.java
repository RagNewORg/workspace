package com.liferay.salesforce.connection;

/**
 * @author Michael C. Han
 */
public interface SalesforceConnectionManager {

	public SalesforceConnection getSalesforceConnection(long companyId, long ownerId);

	public void resetSalesforceConnection(long companyId, long ownerId);

}
