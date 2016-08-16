<%@ include file="init.jsp" %>

<liferay-portlet:actionURL name="configureSalesforceConnection" var="actionURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%= actionURL %>" method="post" name="fm">
	<liferay-ui:error key="connectionFailed" message="unable-to-connect-to-salesforce" />
	<liferay-ui:error key="passwordRequired" message="please-enter-a-valid-password" />
	<liferay-ui:error key="userNameRequired" message="please-enter-a-valid-user-name" />

	<aui:fieldset>
		<aui:input cssClass="lfr-input-text-container" helpMessage="salesforce-server-url-help" label="salesforce-server-url" name="salesforceServerURL" type="text" value='<%= ParamUtil.getString(request, "salesforceServerURL", PrefsPortletPropsUtil.getString(company.getCompanyId(), PortletPropsKeys.SALESFORCE_SERVER_URL, PortalUtil.getUserId(request))) %>' />

		<aui:input cssClass="lfr-input-text-container" helpMessage="salesforce-user-name-help" label="salesforce-user-name" name="salesforceUserName" type="text" value='<%= ParamUtil.getString(request, "salesforceUserName", PrefsPortletPropsUtil.getString(company.getCompanyId(), PortletPropsKeys.SALESFORCE_USER_NAME, PortalUtil.getUserId(request))) %>' />

		<aui:input cssClass="lfr-input-text-container" helpMessage="salesforce-password-help" label="salesforce-password" name="salesforcePassword" type="password" value='<%= ParamUtil.getString(request, "salesforcePassword", PrefsPortletPropsUtil.getString(company.getCompanyId(), PortletPropsKeys.SALESFORCE_PASSWORD, PortalUtil.getUserId(request))) %>' />

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>