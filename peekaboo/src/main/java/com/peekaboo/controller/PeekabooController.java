package com.peekaboo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeekabooController {
	
	@RequestMapping("/")
	public String index() {
		return "hello world!";
	}
	
	@RequestMapping("/test")
	public String test1() {
		return "test page!";
	}
}
