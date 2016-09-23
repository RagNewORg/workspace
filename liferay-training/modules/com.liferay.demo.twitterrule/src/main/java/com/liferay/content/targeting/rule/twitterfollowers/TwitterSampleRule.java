package com.liferay.content.targeting.rule.twitterfollowers;

//import static com.liferay.content.targeting.api.model.BaseJSPRule._log;

//import static com.liferay.content.targeting.api.model.BaseJSPRule._log;

//import static com.liferay.content.targeting.api.model.BaseJSPRule._log;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component(immediate = true, service = Rule.class)
public class TwitterSampleRule extends BaseJSPRule {

	private static final String _CONSUMER_KEY = "xZ9djavDKJIVBmFky0HGdFATz9UgcOEBM4yrPDK9VxwH0Z02uQ";
	private static final String _CONSUMER_SECRET = "aX252D9tu2rcUTcYhVoW8fqpE";
	private static final String _ACCESS_KEY = "aAO1VAd8AjM5zVwwmrqw7YFBXMIrBrYFyXH8eFbaAi33j";
	private static final String _ACCESS_SECRET = "754525242756825088-jKt2u0a9qkgV5xQkZRcCX9GCChQ2vZB";

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest httpServletRequest, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		User user = anonymousUser.getUser();

		if (user == null) {
			return false;
		}

		Contact contact = user.getContact();

		String twitterScreenName = contact.getTwitterSn();

		if (Validator.isNull(twitterScreenName)) {
			return false;
		}

//		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
//			ruleInstance.getTypeSettings());
//
//		int followersThreshold = jsonObj.getInt("followersThreshold");
//
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//
//		cb.setDebugEnabled(true);
//		cb.setOAuthConsumerKey(_CONSUMER_KEY);
//		cb.setOAuthConsumerSecret(_CONSUMER_SECRET);
//		cb.setOAuthAccessToken(_ACCESS_KEY);
//		cb.setOAuthAccessTokenSecret(_ACCESS_SECRET);
//
//		try {
//			TwitterFactory twitterFactory = new TwitterFactory(cb.build());
//
//			Twitter twitter = twitterFactory.getInstance();
//
//			IDs followerIDs = twitter.getFollowersIDs(
//				twitterScreenName, -1, followersThreshold);
//
//			long[] ids = followerIDs.getIDs();
//
//			if (followersThreshold == ids.length) {
//				return true;
//			}
//		}
//		catch (TwitterException te) {
//			System.out.printf("Cannot retrieve data from Twitter", te);
//		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-twitter";
	}

	@Override
	public String getRuleCategoryKey() {

		// Available category classes: BehaviourRuleCategory,
		// SessionAttributesRuleCategory, SocialRuleCategory and
		// UserAttributesRoleCategory

		return (TwitterSampleRuleCategory.KEY);
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		boolean matches = _getMatches(typeSettings);

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		if (matches) {
			return LanguageUtil.get(
				resourceBundle, "the-user-always-matches-this-rule");
		}
		else {
			return LanguageUtil.get(
				resourceBundle, "the-user-never-matches-this-rule");
		}
	}

	//This method is called after clicking Save after selecting this rule from the Rules form.
	@Override
	public String processRule(
		PortletRequest portletRequest, PortletResponse portletResponse,
		String id, Map<String, String> values) {
		
		int followersThreshold = GetterUtil.getInteger(
				values.get("followersThreshold"));

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("followersThreshold", followersThreshold);

		return jsonObject.toString();
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.demo.twitterrule)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	
	//This method takes the value the user selected and injects it into the context map parameter
	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {
		
		int followersThreshold = 0;

		if (!values.isEmpty()) {

			followersThreshold = GetterUtil.getInteger(
					values.get("followersThreshold"));
		}
		else if (ruleInstance != null) {

			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				followersThreshold = GetterUtil.getInteger(
					jsonObj.getInt("followersThreshold"));
			}
			catch (JSONException jse) {
			}
		}

		context.put("followersThreshold", followersThreshold);
	}

	private boolean _getMatches(String typeSettings) {
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				typeSettings);

			return jsonObject.getBoolean("matches");
		}
		catch (JSONException jsone) {
		}

		return false;
	}

}