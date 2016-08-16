<%@ include file="../init.jsp"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	String title = (String) request.getAttribute("title");

	renderResponse.setTitle(title);

	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
%>

<portlet:renderURL var="addSubmissionURL">
	<portlet:param name="mvcRenderCommandName"
		value="/gradebook/submission/edit" />
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:renderURL>

<div class="container-fluid-1280">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">${assignment.getTitle(locale)}</h3>
		</div>
		<div class="panel-body">
			<div class="col-md-6">
				<liferay-frontend:horizontal-card
					text="${assignment.getDescription(locale)}">
					<liferay-frontend:horizontal-card-col>
						<liferay-frontend:horizontal-card-icon icon="align-left" />
					</liferay-frontend:horizontal-card-col>
				</liferay-frontend:horizontal-card>
			</div>
			<div class="col-md-6">
				<liferay-frontend:horizontal-card text="${dueDate}">
					<liferay-frontend:horizontal-card-col>
						<liferay-frontend:horizontal-card-icon icon="time" />
					</liferay-frontend:horizontal-card-col>
				</liferay-frontend:horizontal-card>
			</div>
		</div>
	</div>

	<liferay-ui:search-container
		emptyResultsMessage="No one has submitted this assignment yet.">
		<liferay-ui:search-container-results results="${Submissions}" />
		<liferay-ui:search-container-row
			className="com.liferay.training.space.gradebook.model.Submission"
			modelVar="submission">

			<liferay-ui:search-container-column-date property="submitDate"
				name="Submitted" />

			<liferay-ui:search-container-column-text property="grade"
				name="Result" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>
</div>