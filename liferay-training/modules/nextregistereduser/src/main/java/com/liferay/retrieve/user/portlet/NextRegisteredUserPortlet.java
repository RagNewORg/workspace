package com.liferay.retrieve.user.portlet;

import com.liferay.asset.kernel.model.AssetCategoryProperty;
import com.liferay.asset.kernel.service.AssetCategoryPropertyLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GetNextRegisteredUser",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NextRegisteredUserPortlet extends MVCPortlet {
	
	private AssetCategoryPropertyLocalService _categoryPropertyLocalService = null;
	private long categoryPropertyId = 0;
	private static final String propertyKey = "lastregistereduser";
	
	@Reference(unbind = "-")
	protected void setAssetCategoryPropertyLocalService(AssetCategoryPropertyLocalService assetCategoryPropertyLocalService) {
		_categoryPropertyLocalService = assetCategoryPropertyLocalService;
	}
	
	@Override
	public void init() throws PortletException {
		
		System.out.println("init() method");
		
		List<AssetCategoryProperty> assetCategoryPropertiesList = new ArrayList<AssetCategoryProperty>();
		assetCategoryPropertiesList = _categoryPropertyLocalService.getCategoryProperties();
		
		for(AssetCategoryProperty propertyElement : assetCategoryPropertiesList) {
			
			 if(propertyElement.getKey() != null && propertyElement.getKey().equals("lastregistereduser")) {
			    	categoryPropertyId = propertyElement.getCategoryPropertyId();
			    	System.out.println(categoryPropertyId);
			 }
			 
		}
		super.init();
			 
	}
	
	
	@Override
	public void doView(
		RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String nextUser = new String();
		
		try {
		
			AssetCategoryProperty property = _categoryPropertyLocalService.getAssetCategoryProperty(categoryPropertyId);
			nextUser = property.getValue();
			System.out.println(nextUser);
			renderRequest.setAttribute("nextUser", nextUser);
			
		}
		catch(Exception e){};

		super.doView(renderRequest, renderResponse);
	}
	
}