package com.peekaboo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peekaboo.configuration.auth.PrincipalDetails;
import com.peekaboo.domain.User;

@Controller
public class OAuth2Controller {
	
	@GetMapping(value = "test/login")
	public @ResponseBody String loginTest(Authentication authentication) {
		System.out.println("/test/login ==================");
		System.out.println("Authentication :" + authentication.getPrincipal());
		return "세션 정보 확인";
	}
	
	@GetMapping(value = "test/oauth/login")
	public @ResponseBody String checkOAuth(Authentication authentication) { //DI (의존성 주입)
		System.out.println("/test/oauth/login===============");
		OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
		System.out.println("authentication : " + oauth2User.getAttributes());
		//PrincipalOauth2UserService 에서 받는 Attributes랑 똑같음
		return "OAuth 세션 정보 확인";
	}
	
	@PostMapping(value = "session-test")
	public @ResponseBody String testSession(Authentication authentication) {
		
		return authentication.getPrincipal().toString();
	}
	
	@RequestMapping(value = {"", "/"})
	public String index(RedirectAttributes redirectAttr) {
		//여러개 넣고 싶으면
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("param1", "나의파람1");
		map.put("param2", "나의파람2");
		redirectAttr.addFlashAttribute("param1", map);

		//redirectAttr.addFlashAttribute("id", "imid");
		//redirectAttr.addFlashAttribute("test", "tttttttttttt");
		return "redirect:http://localhost:3000/#/login/sign-in";
	}
	
	@PostMapping(value = "login-process")
	public @ResponseBody Map<String, String> loginProcess(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("principalDetails userId : " + principalDetails.getUserId());
		System.out.println("principalDetails userName : " + principalDetails.getUserName());
		Map<String, String> map = new HashMap<>();
		map.put("userId", principalDetails.getUserId());
		map.put("userName", principalDetails.getUserName());
		return map;
	}
	
	@PostMapping(value = "principalDetails")
	public @ResponseBody Map<String, String> testPrincipalDetails(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("principalDetails userId : " + principalDetails.getUserId());
		System.out.println("principalDetails userName : " + principalDetails.getUserName());
		Map<String, String> map = new HashMap<>();
		map.put("userId", principalDetails.getUserId());
		map.put("userName", principalDetails.getUserName());
		return map;
	}

}
