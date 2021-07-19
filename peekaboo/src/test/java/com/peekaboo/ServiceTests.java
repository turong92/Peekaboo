package com.peekaboo;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peekaboo.domain.Content;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.Tester;
import com.peekaboo.domain.User;
import com.peekaboo.mapper.MuteContentMapper;
import com.peekaboo.service.ContentService;
import com.peekaboo.service.FollowService;
import com.peekaboo.service.LikeService;
import com.peekaboo.service.MuteContentService;
import com.peekaboo.service.PeekabooService;
import com.peekaboo.service.TestService;
import com.peekaboo.service.UserService;

@SpringBootTest
public class ServiceTests {
	
	@Autowired
	private PeekabooService peekabooService;
	@Autowired
	private FollowService followService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private MuteContentService muteContentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContentService contentService;
	@Autowired
	private TestService testService;
	
	@Test
	public void testOfFindByUserId() {
		User result = userService.findByUserId("google_115854284849039362768");
		
		try {
			String json = new ObjectMapper().writeValueAsString(result);
			System.out.println("=======================");
			System.out.println(json);
			System.out.println("=======================");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("====================== result : " + result + "===================");
		System.out.println(sdf.format(result.getUserJoinDate()));
	}
	
	@Test
	public void testOfSignUp() {
//		(String user_name, String user_picture, String user_number, String user_email,
//				int user_follower_cnt, int user_following_cnt, Timestamp user_join_date, Timestamp user_birth,
//				String user_intro, String provider, String role) {
		User user = new User("id", "user_id", "name", "picture", "number", "email", 0, 0, null, null, null, null, null);
		
		boolean result = userService.signUp(user);
		System.out.println("================ result : " + result + " =================");
	}
	/*
	@Test
	public void testOfRegister() {
		PeekabooDTO params = new PeekabooDTO();
		params.setTitle("service test update");
		params.setContent("service test update");
		params.setId("service id");
		params.setIdx((long) 2);
		
		boolean result = peekabooService.registerPeekaboo(params);
		System.out.println("================ result : " + result + " =================");
	}
	
	
	@Test
	public void testOfGetDetail() {
		PeekabooDTO result = peekabooService.getPeekabooDetail((long) 2);
		
		try {
			String json = new ObjectMapper().writeValueAsString(result);
			System.out.println("================================");
			System.out.println(json);
			System.out.println("================================");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOfGetList() {
		List<PeekabooDTO> list = peekabooService.getPeekabooList();
		
		for(PeekabooDTO dto : list) {
			try {
				String json = new ObjectMapper().writeValueAsString(dto);
				System.out.println("================================");
				System.out.println(json);
				System.out.println("================================");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	*/
	//follow
	@Test
	public void testFollow() {
		String follower_id = "123easfd325";
		String following_id = "123423q5rzsdf";
		
		boolean result = followService.insertFollow(follower_id, following_id);
		System.out.println("================ result : " + result + " =================");
	}
	@Test
	public void testFollowDelete() {
		String follower_id = "123easfd325";
		String following_id = "123423q5rzsdf";
		
		boolean result = followService.deleteFollow(follower_id, following_id);
		System.out.println("================ result : " + result + " =================");
	}
	@Test
	public void testFollower() {
		String follower_id = "123easfd325";
		String following_id = "123423q5rzsdf";
		
		List<String> result = followService.getFollowingList(follower_id);
		System.out.println("================ result : " + result.toString() + " =================");
		for(int i=0;i<result.size();i++) {
			System.out.println("================ result : " + result.get(i) + " =================");
		}
		
	}
	@Test
	public void testIsFollow() {
		String follower_id = "123easfd325";
		String following_id = "123423q5rzsdff";
		
		boolean result = followService.isFollow(follower_id, following_id);
		System.out.println("================ result : " + result + " =================");
	}
	//like
	@Test
	public void testLike() {
		String user_id = "123easfd325";
		Long content_id = (long) 1234563;
		
		boolean result = likeService.insertLike(content_id, user_id);
		System.out.println("================ result : " + result + " =================");
	}
	
	@Test
	public void testLikeDelete() {
		String user_id = "123easfd325";
		Long content_id = (long) 1234563;
		
		boolean result = likeService.deleteLike(content_id, user_id);
		System.out.println("================ result : " + result + " =================");
	}
	
	@Test
	public void testIsLike() {
		String user_id = "123easfd325";
		Long content_id = (long) 1234563;
		
		boolean result = likeService.isLike(content_id, user_id);
		System.out.println("================ result : " + result + " =================");
	}
	//Mute
	
	@Test
	public void testMute() {
		String user_id = "123easfd325";
		Long content_id = (long) 1234563;
		
		boolean result = muteContentService.insertMute(user_id, content_id);
		System.out.println("================ result : " + result + " =================");
	}
	//Content
	@Test
	public void testContent() {
		
		
		Content content = new Content(null, "asdfasf", "asdfsafd", 0, null, "sex", null, 0, 0, 0, 0, null, null, null);
		
		
		
		boolean result = contentService.insertContent(content);
		
		System.out.println("================ result : " + result + " =================");
		
		
	}
	@Test
	public void testTest() {
		
		
		Tester content = new Tester(null, "asdfasf", "asdfsafd", 0, null, "sex", null, 0, 0, 0, 0, null, null, null);
		
		
		
		boolean result = testService.insertTest(content);
		
		System.out.println("================ result : " + result + " =================");
		
		
	}
	
	
}
