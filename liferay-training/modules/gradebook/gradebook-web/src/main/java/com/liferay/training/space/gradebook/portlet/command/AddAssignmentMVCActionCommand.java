
package com.liferay.training.space.gradebook.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.training.space.gradebook.model.Assignment;
import com.liferay.training.space.gradebook.portlet.GradebookPortletKeys;
import com.liferay.training.space.gradebook.portlet.GradebookPortletUtil;
import com.liferay.training.space.gradebook.service.AssignmentLocalService;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.PORTLET_NAME,
		"mvc.command.name=/gradebook/assignment/add"
},
	service = MVCActionCommand.class)
public class AddAssignmentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		Assignment assignment = _assignmentLocalService.createAssignment(0);

		GradebookPortletUtil.assembleAssignment(actionRequest, assignment);

		_assignmentLocalService.addAssignment(assignment);

		sendRedirect(actionRequest, actionResponse);
	}

	@Reference
	protected void setAssignmentLocalService(
		AssignmentLocalService assignmentService) {

		_assignmentLocalService = assignmentService;
	}

	protected AssignmentLocalService _assignmentLocalService;

}
