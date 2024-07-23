package com.myweb.firstboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myweb.firstboot.dto.MemberDto;

@RequestMapping("/hello")  // 고정값으로 들어가는 맵핑
@Controller
public class HelloController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot!!";
	}
	
	//파라메타 받는 법
	@GetMapping("/testParam")
	@ResponseBody
	public String getRequestParam(@RequestParam(value="name") String name) {
		return "name = " + name;
	}
	
	//파라메타 여러개 받는 법
	@GetMapping("/testParams")
	@ResponseBody
	public String getRequestParams(@RequestParam(value="name") String name,
								   @RequestParam(value="age") String age) {
		return "name = " + name + ", age = " + age;
	}
	
	// 회원 가입창 같이 많은 파라매타를 받아오는 법 (DTO)
	@GetMapping("/testParamDto")
	@ResponseBody
	public String getRequestParamDto(MemberDto member) {
		return member.toString();
	}
	
	// 리퀘스트 멥핑에 들어와있는 것을 변수로 사용해 받아오는 법
	@GetMapping("/variable/{variable}")
	@ResponseBody
	public String getRequestVal(@PathVariable("variable") String var) {
		return var;
	}
	
}
