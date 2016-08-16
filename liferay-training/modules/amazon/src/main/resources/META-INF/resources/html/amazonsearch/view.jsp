<%@include file="/html/init.jsp" %>

<portlet:actionURL name="sendSearch" var="search" windowState="normal"> 

 <portlet:param name="javax.portlet.action" value="sendSearch" />

</portlet:actionURL>


<aui:form action="<%=search%>" method="POST" name="fm">

<table style="width:300px">
<tr>
  <td>
    <aui:input name="keyword" label="Search in Amazon:"/>
  <td >
    <aui:button type="submit" value="Search"  style="position:relative; bottom:6px;"/>
  </td>
</tr>
</table>

</aui:form>

	