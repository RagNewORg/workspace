
package com.liferay.training.space.gradebook.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.space.gradebook.service.AssignmentLocalService;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.space",
		"javax.portlet.display-name=Class Assignments",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language"
},
	service = Portlet.class)
public class GradebookPortlet extends MVCPortlet {

	@Override
	public void doView(
		RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute(
			"Assignments", assignmentLocalService.getAssignmentsByGroupId(
				themeDisplay.getScopeGroupId()));
		renderRequest.setAttribute(
			"AssignmentsCount",
			assignmentLocalService.getAssignmentsCountByGroupId(
				themeDisplay.getScopeGroupId()));

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	protected void setAssignmentService(
		AssignmentLocalService assignmentService) {

		assignmentLocalService = assignmentService;
	}

	AssignmentLocalService assignmentLocalService;
}
