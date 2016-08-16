<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%-- Package names has changed from com.liferay.portal.* to 
<%-- com.liferay.portal.kernel.*                           --%>

<%@ page import="com.liferay.portal.kernel.model.Group"%>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%---------------------------------------------------------%>

<%@ page import="com.amazon.search.tool.ItemSearch"%>
<%@ page import="com.amazon.search.tool.Product"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

