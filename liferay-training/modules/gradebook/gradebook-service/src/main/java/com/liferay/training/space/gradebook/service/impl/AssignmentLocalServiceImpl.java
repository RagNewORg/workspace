/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.space.gradebook.service.impl;

import com.liferay.training.space.gradebook.model.Assignment;
import com.liferay.training.space.gradebook.service.base.AssignmentLocalServiceBaseImpl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the assignment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.space.gradebook.service.AssignmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentLocalServiceBaseImpl
 * @see com.liferay.training.space.gradebook.service.AssignmentLocalServiceUtil
 */
@ProviderType
public class AssignmentLocalServiceImpl extends AssignmentLocalServiceBaseImpl {
	
	@Override
	public Assignment addAssignment(Assignment assignment) {

		long assignmentId =
			counterLocalService.increment(Assignment.class.getName());

		assignment.setAssignmentId(assignmentId);

		return super.addAssignment(assignment);
	}

	public List<Assignment> getAssignmentsByGroupId(long groupId) {

		return assignmentPersistence.findByGroupId(groupId);
	}

	public List<Assignment> getAssignmentsByGroupId(
		long groupId, int start, int end) {

		return assignmentPersistence.findByGroupId(groupId, start, end);
	}

	public int getAssignmentsCountByGroupId(long groupId) {

		return assignmentPersistence.countByGroupId(groupId);
	}
}