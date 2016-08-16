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

package com.liferay.training.space.gradebook.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.training.space.gradebook.model.Assignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Assignment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Assignment
 * @generated
 */
@ProviderType
public class AssignmentCacheModel implements CacheModel<Assignment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssignmentCacheModel)) {
			return false;
		}

		AssignmentCacheModel assignmentCacheModel = (AssignmentCacheModel)obj;

		if (assignmentId == assignmentCacheModel.assignmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, assignmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", assignmentId=");
		sb.append(assignmentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Assignment toEntityModel() {
		AssignmentImpl assignmentImpl = new AssignmentImpl();

		if (uuid == null) {
			assignmentImpl.setUuid(StringPool.BLANK);
		}
		else {
			assignmentImpl.setUuid(uuid);
		}

		assignmentImpl.setAssignmentId(assignmentId);
		assignmentImpl.setGroupId(groupId);
		assignmentImpl.setCompanyId(companyId);
		assignmentImpl.setUserId(userId);

		if (userName == null) {
			assignmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			assignmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			assignmentImpl.setCreateDate(null);
		}
		else {
			assignmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			assignmentImpl.setModifiedDate(null);
		}
		else {
			assignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			assignmentImpl.setDueDate(null);
		}
		else {
			assignmentImpl.setDueDate(new Date(dueDate));
		}

		if (title == null) {
			assignmentImpl.setTitle(StringPool.BLANK);
		}
		else {
			assignmentImpl.setTitle(title);
		}

		if (description == null) {
			assignmentImpl.setDescription(StringPool.BLANK);
		}
		else {
			assignmentImpl.setDescription(description);
		}

		assignmentImpl.resetOriginalValues();

		return assignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		assignmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dueDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(assignmentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dueDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long assignmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dueDate;
	public String title;
	public String description;
}