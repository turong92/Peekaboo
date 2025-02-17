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

import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.service.PeekabooService;

@Controller
public class PeekabooController {
	
	@Autowired
	private PeekabooService peekabooService;
	
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
		List<PeekabooDTO> list = peekabooService.getPeekabooList();
//		for(PeekabooDTO dto : list) {
//			try {
//				String json = new ObjectMapper().writeValueAsString(dto);
//				result += json;
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return list;
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
