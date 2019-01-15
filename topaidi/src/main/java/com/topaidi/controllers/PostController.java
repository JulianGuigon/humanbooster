package com.topaidi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping("/post")
	public String showPost(Model model) {
		return "post";
	}
}
