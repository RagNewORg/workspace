<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(
		WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Assignment assignment = (Assignment) row.getObject();
	String assignmentId =
		StringUtil.valueOf(assignment.getAssignmentId());
%>

<liferay-ui:icon-menu markupView="lexicon">
	<portlet:renderURL var="editAssignmentURL">
		<portlet:param name="mvcRenderCommandName"
			value="/gradebook/assignment/edit" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="assignmentId" value="<%=assignmentId%>" />
	</portlet:renderURL>

	<liferay-ui:icon message="Edit" url="${editAssignmentURL}" />

	<portlet:actionURL name="/gradebook/assignment/delete"
		var="deleteAssignmentURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="assignmentId" value="<%=assignmentId%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteAssignmentURL}" />  
</liferay-ui:icon-menu> 