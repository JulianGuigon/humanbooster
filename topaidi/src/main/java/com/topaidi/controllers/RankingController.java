package com.topaidi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingController {
	@GetMapping("/ranking")
	public String showRanking(Model model) {
		return "ranking";
	}
}
