package com.peekaboo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peekaboo.domain.Content;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.User;
import com.peekaboo.service.ContentService;
import com.peekaboo.service.LikeService;
import com.peekaboo.service.PeekabooService;
import com.peekaboo.service.UserService;

@Controller
public class PeekabooController {
	
	@Autowired
	private PeekabooService peekabooService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private UserService userService;
	@Autowired
	private LikeService likeService;
	
	@GetMapping(value = "test")
	public @ResponseBody String test1() {
		return "hello! server time is " + new Date() + "\n";
	}
	
	@GetMapping(value = "view-test")
	public String viewTest(RedirectAttributes model) {
		model.addFlashAttribute("test", "test");
		return "redirect:http://localhost:3000/#/";
	}
	
	@PostMapping(value = "sign-up-confirm")
	public String signUpConfirmForJson(@RequestBody Map<String, String> allParams) {
		String result = "test";
		for(String key : allParams.keySet()) {
			result += key + " : " + allParams.get(key) + " ";
		}
		return result;
	}
	
	@PostMapping(value = "sign-up-confirm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String signUpConfirmForForm(Map<String, String> allParams) {
		String result = "test";
		for(String key : allParams.keySet()) {
			result += key + " : " + allParams.get(key) + " ";
		}
		return result;
	}
	
	@GetMapping(value = "write")
	public void openContentWrite(Model model) {
		
		String title = "test title";
		String content = "test content";
		String writer = "test turong";
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("writer", writer);
	}
	
	@PostMapping(value = "read-home-contents")
	public List<PeekabooDTO> readHomeContents(){
		String result = "";
		//List<PeekabooDTO> list = peekabooService.getPeekabooList();
//		for(PeekabooDTO dto : list) {
//			try {
//				String json = new ObjectMapper().writeValueAsString(dto);
//				result += json;
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return null;
	}
	@PostMapping(value = "main-contents")
	@ResponseBody public List<Content> getMainContents(@RequestBody Map<String, String> allParams){
		//로그인된 유저의 아이디를 가지고온다.
		System.out.println(allParams.get("loginId"));
		String loginId = allParams.get("loginId");
		//로그인된 유저의 글과 팔로워들의 글을 가지고온다.
		List<Content> list;
		list = contentService.getMainContentByUserId(loginId);
		return list;
	}
	//profile
	@PostMapping(value = "profile-contents")
	@ResponseBody public List<Content> getProfileContents(@RequestBody Map<String, String> allParams){
		System.out.println(allParams.get("userId"));
		System.out.println(allParams.get("loginId"));
		//proflieContent
		//1. 현재 로그인 되어있는 아이디랑 가져온 아이디랑 비교를한다.
		//2. 가져온 아이디로 연관된 글 목록을 가져온다
		List<Content> list;
		String userId = allParams.get("userId");
		String loginId = allParams.get("loginId");
		//equal > myprofile > user's contents and followers contents 
		if(userId.equals(loginId)) {
			list = contentService.getMyContentByUserId(userId);
		}
		//not equal > other profile > only user's contents
		else {
			list = contentService.getContentByUserId(userId);
		}
		return list;
	}
	@PostMapping(value = "profile-user")
	@ResponseBody public User getUserProfile(@RequestBody Map<String, String> allParams) {
		//userProfile
		//1. 요청한 아이디를 가져온다.
		//2. 아이디로 유저정보를 가져온다.
		User userInfo;
		String userId = allParams.get("userId");
		//equal > myprofile > user's contents and followers contents 
		userInfo = userService.findByUserId(userId);
		return userInfo;
		
	}
	//content
	@PostMapping(value = "write-content")
	@ResponseBody public boolean writeContent(@RequestBody Map<String,String> allParams) {
		//1. need inform : loginId, contentText, contentpicture, allowrange ...
		String loginId = allParams.get("loginId");
		String contentText = allParams.get("contentText");
		String contentPicture = allParams.get("contentPicture");
		int allowRange = Integer.parseInt(allParams.get("allowrange"));
		//2. get username
		User loginUser = userService.findByUserId(loginId);
		String userName = loginUser.getUserName();
		//3. set content
		Content newContent = new Content(null, loginId, userName, allowRange, null, contentText, contentPicture, 0, 0, null, null, null, null, null);
		//4. insert content
		boolean result = contentService.insertContent(newContent);
		//5. return result
		return result;
	}
	
	@PostMapping(value = "content-info")
	@ResponseBody public Content getContentInfo(@RequestBody Map<String, String> allParams) {
		Content contentInfo;
		Long contentId = Long.parseLong(allParams.get("contentId"));
		contentInfo = contentService.getContentByContentId(contentId);
		return contentInfo;
	}
	@PostMapping(value = "content-reply")
	@ResponseBody public List<Content> getContentReply(@RequestBody Map<String, String> allParams) {
		List<Content> contentReply;
		Long contentId = Long.parseLong(allParams.get("contentId"));
		contentReply = contentService.getReplyByContentId(contentId);
		return contentReply;
	}
	//like
	@PostMapping(value = "like-content")
	@ResponseBody public int likeContent(@RequestBody Map<String, String> allParams) {
		//loginId
		String loginId = allParams.get("loginId");
		//likeContent
		Long contentId = Long.parseLong(allParams.get("contentId"));
		//
		boolean like = allParams.get("like").equals("like");
		//if like = "like" add like table
		if(like) {
			likeService.insertLike(contentId, loginId);
		}else {
			likeService.deleteLike(contentId, loginId);
		}
		//get likeCnt
		int likeCnt = likeService.getLikeCnt(contentId);
		return likeCnt;
	}
	
//	@GetMapping(value = "write")
//	public Map<String, String> openContentWrite() {
//		Map<String, String> map = new HashMap<>();
//		map.put("title", "test title");
//		map.put("content", "test content");
//		map.put("writer", "test writer");
//		
//		return map;
//	}
}

/*
기존의 URI 매핑) @RequestMapping(value = "...", method = RequestMethod.XXX)

Spring 4.3 이후 새로운 URI 매핑) @xxxMapping(value = "...")
GetMapping, PostMapping
*/
