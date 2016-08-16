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

package com.liferay.training.space.gradebook.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Assignment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Assignment
 * @generated
 */
@ProviderType
public class AssignmentWrapper implements Assignment, ModelWrapper<Assignment> {
	public AssignmentWrapper(Assignment assignment) {
		_assignment = assignment;
	}

	@Override
	public Class<?> getModelClass() {
		return Assignment.class;
	}

	@Override
	public String getModelClassName() {
		return Assignment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("assignmentId", getAssignmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long assignmentId = (Long)attributes.get("assignmentId");

		if (assignmentId != null) {
			setAssignmentId(assignmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Assignment toEscapedModel() {
		return new AssignmentWrapper(_assignment.toEscapedModel());
	}

	@Override
	public Assignment toUnescapedModel() {
		return new AssignmentWrapper(_assignment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _assignment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _assignment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _assignment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _assignment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Assignment> toCacheModel() {
		return _assignment.toCacheModel();
	}

	@Override
	public int compareTo(Assignment assignment) {
		return _assignment.compareTo(assignment);
	}

	@Override
	public int hashCode() {
		return _assignment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assignment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AssignmentWrapper((Assignment)_assignment.clone());
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _assignment.getDefaultLanguageId();
	}

	/**
	* Returns the description of this assignment.
	*
	* @return the description of this assignment
	*/
	@Override
	public java.lang.String getDescription() {
		return _assignment.getDescription();
	}

	/**
	* Returns the localized description of this assignment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this assignment
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _assignment.getDescription(languageId);
	}

	/**
	* Returns the localized description of this assignment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this assignment
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _assignment.getDescription(languageId, useDefault);
	}

	/**
	* Returns the localized description of this assignment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this assignment
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _assignment.getDescription(locale);
	}

	/**
	* Returns the localized description of this assignment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this assignment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _assignment.getDescription(locale, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _assignment.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _assignment.getDescriptionCurrentValue();
	}

	/**
	* Returns the title of this assignment.
	*
	* @return the title of this assignment
	*/
	@Override
	public java.lang.String getTitle() {
		return _assignment.getTitle();
	}

	/**
	* Returns the localized title of this assignment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this assignment
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _assignment.getTitle(languageId);
	}

	/**
	* Returns the localized title of this assignment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this assignment
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _assignment.getTitle(languageId, useDefault);
	}

	/**
	* Returns the localized title of this assignment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this assignment
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _assignment.getTitle(locale);
	}

	/**
	* Returns the localized title of this assignment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this assignment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _assignment.getTitle(locale, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _assignment.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _assignment.getTitleCurrentValue();
	}

	/**
	* Returns the user name of this assignment.
	*
	* @return the user name of this assignment
	*/
	@Override
	public java.lang.String getUserName() {
		return _assignment.getUserName();
	}

	/**
	* Returns the user uuid of this assignment.
	*
	* @return the user uuid of this assignment
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _assignment.getUserUuid();
	}

	/**
	* Returns the uuid of this assignment.
	*
	* @return the uuid of this assignment
	*/
	@Override
	public java.lang.String getUuid() {
		return _assignment.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _assignment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _assignment.toXmlString();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _assignment.getAvailableLanguageIds();
	}

	/**
	* Returns the create date of this assignment.
	*
	* @return the create date of this assignment
	*/
	@Override
	public Date getCreateDate() {
		return _assignment.getCreateDate();
	}

	/**
	* Returns the due date of this assignment.
	*
	* @return the due date of this assignment
	*/
	@Override
	public Date getDueDate() {
		return _assignment.getDueDate();
	}

	/**
	* Returns the modified date of this assignment.
	*
	* @return the modified date of this assignment
	*/
	@Override
	public Date getModifiedDate() {
		return _assignment.getModifiedDate();
	}

	/**
	* Returns a map of the locales and localized descriptions of this assignment.
	*
	* @return the locales and localized descriptions of this assignment
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _assignment.getDescriptionMap();
	}

	/**
	* Returns a map of the locales and localized titles of this assignment.
	*
	* @return the locales and localized titles of this assignment
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _assignment.getTitleMap();
	}

	/**
	* Returns the assignment ID of this assignment.
	*
	* @return the assignment ID of this assignment
	*/
	@Override
	public long getAssignmentId() {
		return _assignment.getAssignmentId();
	}

	/**
	* Returns the company ID of this assignment.
	*
	* @return the company ID of this assignment
	*/
	@Override
	public long getCompanyId() {
		return _assignment.getCompanyId();
	}

	/**
	* Returns the group ID of this assignment.
	*
	* @return the group ID of this assignment
	*/
	@Override
	public long getGroupId() {
		return _assignment.getGroupId();
	}

	/**
	* Returns the primary key of this assignment.
	*
	* @return the primary key of this assignment
	*/
	@Override
	public long getPrimaryKey() {
		return _assignment.getPrimaryKey();
	}

	/**
	* Returns the user ID of this assignment.
	*
	* @return the user ID of this assignment
	*/
	@Override
	public long getUserId() {
		return _assignment.getUserId();
	}

	@Override
	public void persist() {
		_assignment.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_assignment.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_assignment.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the assignment ID of this assignment.
	*
	* @param assignmentId the assignment ID of this assignment
	*/
	@Override
	public void setAssignmentId(long assignmentId) {
		_assignment.setAssignmentId(assignmentId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_assignment.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this assignment.
	*
	* @param companyId the company ID of this assignment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_assignment.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this assignment.
	*
	* @param createDate the create date of this assignment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_assignment.setCreateDate(createDate);
	}

	/**
	* Sets the description of this assignment.
	*
	* @param description the description of this assignment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_assignment.setDescription(description);
	}

	/**
	* Sets the localized description of this assignment in the language.
	*
	* @param description the localized description of this assignment
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_assignment.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this assignment in the language, and sets the default locale.
	*
	* @param description the localized description of this assignment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_assignment.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_assignment.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this assignment from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this assignment
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_assignment.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this assignment from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this assignment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_assignment.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Sets the due date of this assignment.
	*
	* @param dueDate the due date of this assignment
	*/
	@Override
	public void setDueDate(Date dueDate) {
		_assignment.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_assignment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_assignment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_assignment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this assignment.
	*
	* @param groupId the group ID of this assignment
	*/
	@Override
	public void setGroupId(long groupId) {
		_assignment.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this assignment.
	*
	* @param modifiedDate the modified date of this assignment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_assignment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_assignment.setNew(n);
	}

	/**
	* Sets the primary key of this assignment.
	*
	* @param primaryKey the primary key of this assignment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_assignment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_assignment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the title of this assignment.
	*
	* @param title the title of this assignment
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_assignment.setTitle(title);
	}

	/**
	* Sets the localized title of this assignment in the language.
	*
	* @param title the localized title of this assignment
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_assignment.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this assignment in the language, and sets the default locale.
	*
	* @param title the localized title of this assignment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_assignment.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_assignment.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this assignment from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this assignment
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap) {
		_assignment.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this assignment from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this assignment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_assignment.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Sets the user ID of this assignment.
	*
	* @param userId the user ID of this assignment
	*/
	@Override
	public void setUserId(long userId) {
		_assignment.setUserId(userId);
	}

	/**
	* Sets the user name of this assignment.
	*
	* @param userName the user name of this assignment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_assignment.setUserName(userName);
	}

	/**
	* Sets the user uuid of this assignment.
	*
	* @param userUuid the user uuid of this assignment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_assignment.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this assignment.
	*
	* @param uuid the uuid of this assignment
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_assignment.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssignmentWrapper)) {
			return false;
		}

		AssignmentWrapper assignmentWrapper = (AssignmentWrapper)obj;

		if (Objects.equals(_assignment, assignmentWrapper._assignment)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _assignment.getStagedModelType();
	}

	@Override
	public Assignment getWrappedModel() {
		return _assignment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _assignment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _assignment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_assignment.resetOriginalValues();
	}

	private final Assignment _assignment;
}