package com.peekaboo;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.User;
import com.peekaboo.service.PeekabooService;
import com.peekaboo.service.UserService;

@SpringBootTest
public class ServiceTests {
	
	@Autowired
	private PeekabooService peekabooService;
	
	@Autowired
	private UserService userService;
	
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

}
