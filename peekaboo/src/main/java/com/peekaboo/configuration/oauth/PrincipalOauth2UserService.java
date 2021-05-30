package com.peekaboo.configuration.oauth;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.peekaboo.domain.User;
import com.peekaboo.service.UserService;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	@Autowired
	private UserService userService;
	
	//구글에서 받은 userRequest 데이터 후처리 함수
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration:" + userRequest.getClientRegistration()); // registrationId로 어떤 OAuth로 들어왔는지 확인 가능
		System.out.println("getAccessToken:" + userRequest.getAccessToken().getTokenValue());
		//구글 로그인 클릭 -> 로그인창 -> 완료 -> code return(OAuth-Client) -> AccessToken 요청
		//userRequest -> loadUser 호출 -> 회원 프로필 가져옴
		System.out.println("getAttributes:" + super.loadUser(userRequest).getAttributes());
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		String provider = userRequest.getClientRegistration().getRegistrationId(); // google
		String providerId = oauth2User.getAttribute("sub");
		String userId = provider + "_" + providerId; // google_1234123412341234
		String email = oauth2User.getAttribute("email");
		String name = oauth2User.getAttribute("name");
		String picture = oauth2User.getAttribute("picture");
		String role = "ROLE_USER";
		
		User user = userService.findByUserId(userId);
		if(user == null) {
			//String user_name, String user_picture, String user_number, String user_email,
//			int user_follower_cnt, int user_following_cnt, Timestamp user_join_date, Timestamp user_birth,
//			String user_intro, String provider, String providerId, String role) {
			user = User.builder()
					.id(providerId)
					.user_id(userId)
					.user_name(name)
					.user_picture(picture)
					.user_email(email)
					.user_follower_cnt(0)
					.user_following_cnt(0)
					.provider(provider)
					.role(role)
					.build();
			userService.signUp(user);
		}
		
		return super.loadUser(userRequest);
	}
}
