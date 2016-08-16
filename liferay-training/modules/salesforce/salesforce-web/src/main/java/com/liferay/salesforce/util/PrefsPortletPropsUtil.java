package com.liferay.salesforce.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.util.portlet.PortletProps;

import javax.portlet.PortletPreferences;

/**
 * @author Amos Fong
 */
public class PrefsPortletPropsUtil {

	public static PortletPreferences getPortletPreferences(long companyId, long ownerId)
		throws SystemException {

		return PortletPreferencesLocalServiceUtil.getPreferences(
			companyId, ownerId, PortletKeys.PREFS_OWNER_TYPE_USER,
			PortletKeys.PREFS_PLID_SHARED, "1_WAR_salesforceportlet");
	}

	public static String getString(long companyId, String name, long ownerId)
		throws SystemException {

		PortletPreferences portletPreferences = getPortletPreferences(
			companyId, ownerId);

		return _getString(portletPreferences, companyId, name);
	}

	private static String _getString(
		PortletPreferences portletPreferences, long companyId, String name) {

		String value = PortletProps.get(name);

		return portletPreferences.getValue(name, value);
	}

}
