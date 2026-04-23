package com.green.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home");
		return "home";                          // WEB-INF/views/home.jsp
	}
	
	// /temp?a=hello&b=123
	// java compiler 설정 : Enable ~, store ~
	@RequestMapping("/temp")               
	public String temp(String a, int b) {
		
		System.out.println("a=" + a);
		System.out.println("b=" + b + 3);     // 문자 + 숫자 + 숫자 / "b=" + (b + 3)
		
		return "none";                        // 파일없음 -> 404
	}
	
	// /temp1?a=hello&b=123
	@RequestMapping("/temp1")
	public String temp1(HttpServletRequest request,
			HttpServletResponse response) {
		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b");
		
		String a = in_a;
		int    b = Integer.parseInt(in_b);
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		return "none";
	}
	
	// /temp2?a=hello&b=123
	@RequestMapping("/temp2")               
	public String temp2( @RequestParam Map<String,String> map ) {
		
		System.out.println(map);
		
		String a = map.get("a");
		int    b = Integer.parseInt(map.get("b"));
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		return "none";
	}
	
	// /temp3?a=hello&b=123
	@RequestMapping("/temp3")               
	public String temp3(
			@RequestParam("a") String x, @RequestParam("b") int y) {
		
		System.out.println("a=" + x);
		System.out.println("b=" + y);     
		
		return "none";                        
	}
	
	// /temp4?a=hello&b=123
	
	
	
}
