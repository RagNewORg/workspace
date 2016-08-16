/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazon.search;

import com.amazon.search.tool.ItemSearch;
import com.amazon.search.tool.Product;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/*
 * AmazonResult consumes Accesskey, SecretKey and keyword from AmazonSearch
 * and calls amazon webservice
 */


@Component(
	immediate = true,
	property = {
		"javax.portlet.display-name=Amazon Result",
        "com.liferay.portlet.display-category=Amazon",
		"javax.portlet.init-param.view-template=/html/amazonresult/view.jsp",
		"javax.portlet.init-param.edit-template=/html/amazonresult/edit.jsp",
        "javax.portlet.portlet-mode=text/html;edit,view",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.security-role-ref=power-user,user,administrator",
        "javax.portlet.supported-processing-event=ipc.search;http://liferay.com/events"
		
    },
    service = Portlet.class
)
public class AmazonResult extends GenericPortlet {
	

    protected String editTemplate;
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(AmazonResult.class);
    private List<Product> tableValue;

    public void init() {
        editTemplate = getInitParameter("edit-template");
        viewTemplate = getInitParameter("view-template");
    }

    public void doEdit(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(editTemplate, renderRequest, renderResponse);
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

    	renderRequest.setAttribute("tableData", tableValue);
    	
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
    
    //AmazonResult is consumer of the event and is receiving the access/secret key
    @ProcessEvent(qname="{http://liferay.com/events}ipc.search")
    public void doSearch(EventRequest request, EventResponse response) 
     {
    	Event event = request.getEvent();
    	String paramToSend = (String)event.getValue();
    	
    	String paramRecieved [] = paramToSend.split(",");
    	
    	String accesKey = paramRecieved [0];
    	String secretKey= paramRecieved [1];
        String keyword = paramRecieved [2];
        
    	ItemSearch itemSearch = new ItemSearch();
   
    	/* 
    	 * Access Key - AKIAJXAXNH55EIDFZEHA
    	 * Secret Key - 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
    	 */
    	
    	//List<Product> tableResult = itemSearch.itemSearch("AKIAJXAXNH55EIDFZEHA", "4GfIoxBbr4pEq4wp7o45ZfkY2u46bpl+ZXkEqY9a", keyword);
    	List<Product> tableResult = itemSearch.itemSearch(accesKey, secretKey, keyword);
		 System.out.println(tableResult.get(0).getItemName());
		 tableValue = tableResult;
		 request.setAttribute("tableData", tableResult);
		 
		//response.setRenderParameter("tableToshow", tableResult);
		 
    }

}
