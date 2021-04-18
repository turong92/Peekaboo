package com.peekaboo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.mapper.PeekabooMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	private PeekabooMapper peekabooMapper;
	
	@Test
	public void testOfInsert() {
		PeekabooDTO params = new PeekabooDTO();
		params.setTitle("test title");
		params.setContent("test content");
		params.setId("test id");
		
		int result = peekabooMapper.insertContent(params);
		System.out.println("================ result : " + result + " =================");
	}
	
	@Test
	public void testOfSelectDetail() {
		PeekabooDTO peekaboo = peekabooMapper.selectDetail((long) 1);
		try {
			String json = new ObjectMapper().writeValueAsString(peekaboo);
			
			System.out.println("================================");
			System.out.println(json);
			System.out.println("================================");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOfUpdate() {
		PeekabooDTO params = new PeekabooDTO();
		params.setTitle("update test title");
		params.setContent("update test content");
		params.setId("update test id");
		params.setIdx((long) 1);
		
		int result = peekabooMapper.updateContent(params);
		if(result == 1) {
			PeekabooDTO peekaboo = peekabooMapper.selectDetail((long) 1);
			try {
				String json = new ObjectMapper().writeValueAsString(peekaboo);
				
				System.out.println("================================");
				System.out.println(json);
				System.out.println("================================");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testOfDelete() {
		int result = peekabooMapper.deleteContent((long) 1);
		if (result == 1) {
			PeekabooDTO peekaboo = peekabooMapper.selectDetail((long) 1);
			try {
				String json = new ObjectMapper().writeValueAsString(peekaboo);

				System.out.println("================================");
				System.out.println(json);
				System.out.println("================================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
}
