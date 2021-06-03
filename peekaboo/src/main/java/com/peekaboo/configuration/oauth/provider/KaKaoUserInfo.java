package com.peekaboo.configuration.oauth.provider;

import java.util.Map;

public class KaKaoUserInfo implements OAuth2UserInfo{
	
	private Map<String, Object> attributes; //oauth2User.getAttributes();
	private Map<String, Object> kakaoAccount;
	private Map<String, Object> profile; 
	
	@SuppressWarnings("unchecked")
	public KaKaoUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
		this.kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
		this.profile = (Map<String, Object>) kakaoAccount.get("profile");
	}

	@Override
	public String getProviderId() {
		return Integer.toString((int) attributes.get("id"));
	}

	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getEmail() {
		return (String) kakaoAccount.get("email");
	}

	@Override
	public String getName() {
		return (String) profile.get("nickname");
	}
	
	@Override
	public String getPicture() {
		return (String) profile.get("profile_image");
	}
	
}
