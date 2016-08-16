<%@ include file="/init.jsp"%>

<portlet:renderURL var="addAssignmentURL">
	<portlet:param name="mvcRenderCommandName"
		value="/gradebook/assignment/edit" />
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:renderURL>



<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item title="Assignment"
		url="${addAssignmentURL}" />
</liferay-frontend:add-menu>

<div class="container-fluid-1280">
	<div class="flex-container">

		<liferay-ui:search-container emptyResultsMessage="There are no assignments for this class.">
			<liferay-ui:search-container-results results="${Assignments}" />
			<liferay-ui:search-container-row
				className="com.liferay.training.space.gradebook.model.Assignment"
				modelVar="assignment">

				<portlet:renderURL var="viewSubmissionsURL">
					<portlet:param name="mvcRenderCommandName"
						value="/gradebook/submissions/view" />
					<portlet:param name="redirect" value="${currentURL}" />
					<portlet:param name="assignmentId"
						value="${assignment.getAssignmentId()}" />
				</portlet:renderURL>

				<liferay-frontend:icon-vertical-card icon="cards2"
					title="${assignment.getTitle(locale)}"
					actionJsp="/assignment/card_actions.jsp"
					cssClass="col-md-3 flex-item-break-xs card-row-padded"
					actionJspServletContext="<%= application %>" resultRow="<%=row %>"
					url="${viewSubmissionsURL}">

					<liferay-frontend:vertical-card-footer>
						<p class="truncate-text flex-item-center">${assignment.getDescription()}</p>
					</liferay-frontend:vertical-card-footer>
				</liferay-frontend:icon-vertical-card>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>
