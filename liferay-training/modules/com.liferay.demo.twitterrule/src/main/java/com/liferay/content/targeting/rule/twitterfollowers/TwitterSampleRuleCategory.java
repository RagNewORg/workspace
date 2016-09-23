package com.liferay.content.targeting.rule.twitterfollowers;

import com.liferay.content.targeting.api.model.BaseRuleCategory;
import com.liferay.content.targeting.api.model.RuleCategory;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = RuleCategory.class)
public class TwitterSampleRuleCategory extends BaseRuleCategory {

	public static final String KEY = "sample";

	@Override
	public String getCategoryKey() {
		return KEY;
	}

	@Override
	public String getIcon() {
		return "icon-twitter";
	}

	
}
