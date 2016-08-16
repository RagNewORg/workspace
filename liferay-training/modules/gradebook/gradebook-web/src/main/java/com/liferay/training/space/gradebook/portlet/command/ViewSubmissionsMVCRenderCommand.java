
package com.liferay.training.space.gradebook.portlet.command;

import java.text.DateFormat;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.training.space.gradebook.model.Assignment;
import com.liferay.training.space.gradebook.model.Submission;
import com.liferay.training.space.gradebook.portlet.GradebookPortletKeys;
import com.liferay.training.space.gradebook.service.AssignmentLocalService;
import com.liferay.training.space.gradebook.service.SubmissionLocalService;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.PORTLET_NAME,
		"mvc.command.name=/gradebook/submissions/view"
},
	service = MVCRenderCommand.class)
public class ViewSubmissionsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException {

		long assignmentId = ParamUtil.getLong(renderRequest, "assignmentId", 0);

		Assignment assignment = null;
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"EEEEE, MMMMM dd, yyyy", renderRequest.getLocale());
		List<Submission> submissions = null;
		StringBundler stringBundler = new StringBundler();

		stringBundler.append("Student Submissions");

		try {
			assignment = _assignmentLocalService.getAssignment(assignmentId);
			submissions = _submissionLocalService.getSubmissionsByAssignment(
				PortalUtil.getScopeGroupId(renderRequest), assignmentId);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		renderRequest.setAttribute("assignment", assignment);
		renderRequest.setAttribute("Submissions", submissions);

		renderRequest.setAttribute(
			"dueDate", dateFormat.format(assignment.getDueDate()));

		renderRequest.setAttribute("title", stringBundler.toString());

		return "/submission/view_submissions.jsp";
	}

	@Reference
	protected void setAssignmentLocalService(
		AssignmentLocalService assignmentLocalService) {

		_assignmentLocalService = assignmentLocalService;
	}

	@Reference
	protected void setSubmissionLocalService(
		SubmissionLocalService submissionLocalService) {

		_submissionLocalService = submissionLocalService;
	}

	private AssignmentLocalService _assignmentLocalService;
	private SubmissionLocalService _submissionLocalService;

}
