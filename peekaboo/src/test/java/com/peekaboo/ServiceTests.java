package com.peekaboo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.service.PeekabooService;

@SpringBootTest
public class ServiceTests {
	
	@Autowired
	private PeekabooService peekabooService;
	
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
