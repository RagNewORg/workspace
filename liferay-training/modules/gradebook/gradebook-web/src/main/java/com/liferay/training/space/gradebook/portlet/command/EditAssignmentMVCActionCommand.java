
package com.liferay.training.space.gradebook.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.space.gradebook.model.Assignment;
import com.liferay.training.space.gradebook.portlet.GradebookPortletKeys;
import com.liferay.training.space.gradebook.portlet.GradebookPortletUtil;
import com.liferay.training.space.gradebook.service.AssignmentLocalService;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.PORTLET_NAME,
		"mvc.command.name=/gradebook/assignment/edit"
},
	service = MVCActionCommand.class)
public class EditAssignmentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		long assignmentId = ParamUtil.getLong(actionRequest, "assignmentId");

		Assignment assignment =
			_assignmentLocalService.getAssignment(assignmentId);

		GradebookPortletUtil.assembleAssignment(actionRequest, assignment);

		_assignmentLocalService.updateAssignment(assignment);

		sendRedirect(actionRequest, actionResponse);

	}

	@Reference
	protected void setAssignmentLocalService(
		AssignmentLocalService assignmentService) {

		_assignmentLocalService = assignmentService;
	}

	protected AssignmentLocalService _assignmentLocalService;
}
