package com.peekaboo.configuration.oauth;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.peekaboo.configuration.auth.PrincipalDetails;
import com.peekaboo.configuration.oauth.provider.GoogleUserInfo;
import com.peekaboo.configuration.oauth.provider.KaKaoUserInfo;
import com.peekaboo.configuration.oauth.provider.NaverUserInfo;
import com.peekaboo.configuration.oauth.provider.OAuth2UserInfo;
import com.peekaboo.domain.User;
import com.peekaboo.service.UserService;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	@Autowired
	private UserService userService;
	
	private HttpSession httpSession;
	
	//구글에서 받은 userRequest 데이터 후처리 함수
	@SuppressWarnings("unused")
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration:" + userRequest.getClientRegistration()); // registrationId로 어떤 OAuth로 들어왔는지 확인 가능
		//System.out.println("getAccessToken:" + userRequest.getAccessToken().getTokenValue());
		//구글 로그인 클릭 -> 로그인창 -> 완료 -> code return(OAuth-Client) -> AccessToken 요청
		//userRequest -> loadUser 호출 -> 회원 프로필 가져옴
		System.out.println("getAttributes:" + super.loadUser(userRequest).getAttributes());
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		OAuth2UserInfo oAuth2UserInfo = null;
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		if(registrationId.equals("google")) {
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		}else if(registrationId.equals("naver")) {
			oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
		}else if(registrationId.equals("kakao")) {
			oAuth2UserInfo = new KaKaoUserInfo(oAuth2User.getAttributes());
		}
		
		String provider = oAuth2UserInfo.getProvider();
		String providerId = oAuth2UserInfo.getProviderId();
		String userId = provider + "_" + providerId; // google_1234123412341234
		String name = oAuth2UserInfo.getName();
		String picture = oAuth2UserInfo.getPicture();
		String email = oAuth2UserInfo.getEmail();
		String role = "ROLE_USER";
		
		
		User user = userService.findByUserId(userId);
//		System.out.println(user.getId());
//		System.out.println(user.getUserId());
		if(user == null) {
			//String user_name, String user_picture, String user_number, String user_email,
//			int user_follower_cnt, int user_following_cnt, Timestamp user_join_date, Timestamp user_birth,
//			String user_intro, String provider, String providerId, String role) {
			user = User.builder()
					.id(providerId)
					.userId(userId)
					.userName(name)
					.userPicture(picture)
					.userNumber(null)
					.userEmail(email)
					.userFollowerCnt(0)
					.userFollowingCnt(0)
					.userJoinDate(null)
					.userBirth(null)
					.userIntro(null)
					.provider(provider)
					.role(role)
					.build();
			userService.signUp(user);
		}
		
		return new PrincipalDetails(user, oAuth2User.getAttributes());
	}
}
