package com.green.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.board.vo.DataVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home");
		return "home";                          // WEB-INF/views/home.jsp
	}

//---------------------------------------------------------------------------------------
	// /temp?a=hello&b=123
	// java compiler 설정 : Enable ~, store ~
	@RequestMapping("/temp")               
	public String temp(String a, int b) {
		
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 1));     // 문자 + (숫자 + 숫자) -> 숫자먼저 계산
		
		return "none";                          // 파일없음 -> 404
	}
	
	// /temp1?a=hello&b=123
	@RequestMapping("/temp1")  // 파일 업로드
	public String temp1(HttpServletRequest request,
			HttpServletResponse response) {
		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b");
		
		String a = in_a;
		int    b = Integer.parseInt(in_b);
		
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 2));
		
		return "none";
	}
	
	// /temp2?a=hello&b=123
	@RequestMapping("/temp2")                   
	public String temp2( @RequestParam Map<String,String> map ) {
		
		System.out.println(map);
		
		String a = map.get("a");
		int    b = Integer.parseInt(map.get("b"));
		
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 3));
		
		return "none";
	}
	
	// /temp3?a=hello&b=123    // 요즘 spring boot 가 인자를 처리하는 방식
	@RequestMapping("/temp3")  // 이름 바꾸기 가능        
	public String temp3(
			@RequestParam("a") String x, @RequestParam("b") int y) {
		
		System.out.println("a=" + x);
		System.out.println("b=" + (y + 4));     
		
		return "none";                        
	}
	
	// /temp4?a=hello&b=123
	@RequestMapping("/temp4")
	public String temp4( DataVo vo ) {
		
		String a = vo.getA(); 
		int    b = vo.getB();
		
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 5));
		
		return "none";
	}

//--------------------------------------------------------------------------------	
	// 넘겨받은 값을 처리해서 jsp 에 넘기는 방법
	// model 을 사용
	// jsp 에 넘겨줄 데이터를 model class 에 담아서 전달 -> jsp 는 El(${})로 받음
	// /temp5?a=hello&b=123
	@RequestMapping("/temp5")
	public String temp5(String a, int b, Model model) {
		
		System.out.println("a=" + a);
		System.out.println("b=" + b*3);
		
		model.addAttribute("a", a);
		model.addAttribute("b", b*3);
		model.addAttribute("c", "cc");
		
		return "reqdata";
	}
	
	// /temp6?a=hello&b=123
	@RequestMapping("/temp6")
	public String temp6(DataVo vo, Model model) {
		
		String a = vo.getA(); 
		int    b = vo.getB();
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		model.addAttribute("a", a);
		model.addAttribute("b", b-7);
		model.addAttribute("c", "cc");
		
		return "reqdata";
	}
	
	// /temp7?a=hello&b=123
	@RequestMapping("/temp7")
	public String temp7(
			@ModelAttribute("attrName") DataVo vo,
			Model model) {
		
		System.out.println("a=" + vo.getA());
		System.out.println("b=" + vo.getB());
		
		model.addAttribute("a", vo.getA());
		model.addAttribute("b", vo.getB());
		
		return "noneModel";
	}

//---------------------------------------------------------------------------
	// PathVariable : 경로에 data 를 포함시키는 방법
	// @PathVariable 생략하면 err
	// /temp8/hello/123     | /temp8/123/list |
	@RequestMapping("/temp8/{a}/{b}")
	public String temp8 (@PathVariable String a, @PathVariable int b) {
		
		System.out.println("a=" + a);
		System.out.println("b=" + (b - 23));
		
		return "none";
	}
	
	// /temp9/hello/123 
	// @PathVariable 생략가능
	@RequestMapping("/temp9/{a}/{b}")
	public String temp9 (DataVo vo) {
		
		System.out.println("a=" + vo.getA());
		System.out.println("b=" + vo.getB());
		
		return "none";
	}
	
	// /temp10/hello/123 
	@RequestMapping("/temp10/{a}/{b}")
	public String temp10 (@ModelAttribute("vo") DataVo vo, Model model) {
		
		System.out.println("a=" + vo.getA());
		System.out.println("b=" + vo.getB());
		
		return "noneModel";
	}
	
	
}
