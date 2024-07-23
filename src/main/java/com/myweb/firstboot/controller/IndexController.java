package com.myweb.firstboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myweb.firstboot.dto.BoardDto;
import com.myweb.firstboot.service.BoardService;


@Controller
public class IndexController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		List<BoardDto> menu = service.getBoardMenu();
		model.addAttribute("menu", menu);
		return "index";
	}
}
