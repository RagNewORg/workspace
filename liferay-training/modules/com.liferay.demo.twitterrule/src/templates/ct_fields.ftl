<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">


<@liferay_ui["message"] arguments=selectorField key="users-that-have-more-than" />

<@aui["input"] inlineField=true label="" name="followersThreshold" style="margin-bottom: 0; width: auto;" suffix="followers" title="number-of-followers" type="text" value=followersThreshold>
	<@aui["validator"] name="number" />
</@>