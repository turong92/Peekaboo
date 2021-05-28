package com.peekaboo.configuration.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	//구글에서 받은 userRequest 데이터 후처리 함수
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration:" + userRequest.getClientRegistration());
		System.out.println("getAccessToken:" + userRequest.getAccessToken());
		System.out.println("getAttributes:" + super.loadUser(userRequest).getAttributes());
		return super.loadUser(userRequest);
	}
}
