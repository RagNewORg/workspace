<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.amazon.search.tool.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%


List<Product> tableData = (List<Product>) renderRequest.getAttribute("tableData");
if (tableData == null)
{
	tableData = new ArrayList<Product>();
}
%>

<liferay-ui:search-container delta="5" emptyResultsMessage="Enter a search keyword in the search portlet">
   <liferay-ui:search-container-results results="<%= ListUtil.subList(tableData, searchContainer.getStart(), searchContainer.getEnd())%>"/>
        <liferay-ui:search-container-row className="com.amazon.search.tool.Product" modelVar="data">
            <liferay-ui:search-container-column-text name="Product" value="<%=data.getItemName() %>" />
            <liferay-ui:search-container-column-text name="Manufacturer" value="<%=data.getItemManufacturer() %>" />
            <liferay-ui:search-container-column-text name="Details" value="Details"   href="<%=data.getItemDetails() %>"/>
        </liferay-ui:search-container-row>
   <liferay-ui:search-iterator /> 
</liferay-ui:search-container>
