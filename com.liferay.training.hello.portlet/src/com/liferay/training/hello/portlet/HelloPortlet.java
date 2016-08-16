package com.liferay.training.hello.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.training.service.hello.*;

@Component(immediate=true, 
        service = Portlet.class,
        property = {
		"javax.portlet.display-name=Hello Portlet",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.show-portlet-access-denied=false",
		"javax.portlet.init-param.template-path=/resources/html",
		"javax.portlet.init-param.view-template=/resources/html/view.jsp",
		}
        )
public class HelloPortlet extends GenericPortlet {
	

   
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		PortletRequestDispatcher requestDispatcher =
			getPortletContext().getRequestDispatcher("/html/view.jsp");

		requestDispatcher.include(request, response);
	}
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response)
		throws PortletException, IOException {

		String result = "Try again!";
		String input = request.getParameter("content");

		if (input.isEmpty()) {
			result = _helloService.say();
		}
		else {
			result = _helloService.say(input);
		}

		response.setRenderParameter("actionResult", result);
	}
	
	@Reference
	protected void setHelloService(HelloService helloService) {

		_helloService = helloService;
	}
	private HelloService _helloService;


}