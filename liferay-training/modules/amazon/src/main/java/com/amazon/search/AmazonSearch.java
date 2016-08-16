package com.amazon.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
			"javax.portlet.display-name=Amazon Search",
	        "com.liferay.portlet.display-category=Amazon",
			"javax.portlet.init-param.view-template=/html/amazonsearch/view.jsp",
			"javax.portlet.init-param.edit-template=/html/amazonsearch/edit.jsp",
	        "javax.portlet.portlet-mode=text/html;edit,view",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.security-role-ref=power-user,user,administrator",
	        "javax.portlet.supported-publishing-event=ipc.search;http://liferay.com/events"
	},
	
	service = Portlet.class
)
public class AmazonSearch extends GenericPortlet {

    public void init() {
        editTemplate = getInitParameter("edit-template");
        viewTemplate = getInitParameter("view-template");
    }

    //Read access key and secret key. Set on UI.
    public void doEdit(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	
    	PortletPreferences prefs = renderRequest.getPreferences();
        String accesKey = "";
        String secretKey = " ";
        accesKey = (String) prefs.getValue("accesKey", accesKey);
        secretKey = (String) prefs.getValue("secretKey", secretKey);
        
        renderRequest.setAttribute("accesKey", accesKey);
        renderRequest.setAttribute("secretKey", secretKey);
        
        include(editTemplate, renderRequest, renderResponse);
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    /*
     * When user initiates a keyword search, the accesskey/secret key set in preferences
     * will be sent via IPC to AmazonResult
     */
    @ProcessAction(name = "sendSearch")
    public void sendSearch(ActionRequest request, ActionResponse response) 
    {
    	PortletPreferences prefs = request.getPreferences();
    	String accessKey = "";
        String secretKey = " ";
        accessKey = (String) prefs.getValue("accesKey", accessKey);
        secretKey = (String) prefs.getValue("secretKey", secretKey);
        
    	QName qName = new QName("http://liferay.com/events", "ipc.search");
		
		if (ParamUtil.getString(request, "keyword") != null && !ParamUtil.getString(request, "keyword").equals("")
			&& accessKey != null && !accessKey.equals("")	
			&& secretKey != null && !secretKey.equals("") )
		{
		  String paramToSend = accessKey + "," + secretKey + "," + ParamUtil.getString(request, "keyword");
		 response.setEvent(qName, paramToSend);
		}
		
	}
    
    
    @ProcessAction(name = "editPref")
    public void editPref(ActionRequest request, ActionResponse response) 
    {
    	String accesKey = ParamUtil.getString(request, "accesKey");
    	String secretKey = ParamUtil.getString(request, "secretKey");

        try {
        	PortletPreferences prefs = request.getPreferences();
			prefs.setValue("secretKey", secretKey);
			prefs.setValue("accesKey", accesKey);
			prefs.store();
			response.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
        
        
    }
    
    protected String editTemplate;
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(AmazonSearch.class);

}
