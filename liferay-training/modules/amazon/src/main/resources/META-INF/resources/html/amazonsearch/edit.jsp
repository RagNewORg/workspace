<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/init.jsp" %>
<portlet:actionURL name="editPref" var="editPref" windowState="normal" />
<%  
    String prev_accesKey = "";
    String accesKey = (String)request.getAttribute("accesKey");
    
    if (accesKey != null)
    	prev_accesKey = accesKey;
    
    String prev_secretKey = "";
    String secretKey = (String)request.getAttribute("secretKey");
    
    if (secretKey != null)
    	prev_secretKey = secretKey;
    
    %>
    
<aui:form action="<%= editPref %>" method="POST" name="fm">


    <aui:input name="accesKey" label="Access Key:" value="<%=accesKey%>"/>
    <aui:input name="secretKey" label="Secret Key:" value="<%=secretKey%>"/>

    <aui:button type="submit" value="Submit" />


</aui:form>
