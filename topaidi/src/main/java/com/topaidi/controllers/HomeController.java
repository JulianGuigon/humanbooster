package com.topaidi.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.NoteService;
import com.topaidi.service.interfaces.UserService;
import com.topaidi.utils.RankingUtil;


@Controller
public class HomeController {
	public static final int CONSTANT_MAX_VALUES_LATEST = 6;
	
	@Autowired
	IdeaService ideaService;
	@Autowired
	NoteService noteService;
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String showHome(Model model) {
		RankingUtil rankingUtil = new RankingUtil(userService, ideaService, noteService);
		
		List<Idea> topRanking = rankingUtil.getTopRanking();
		if(topRanking.size()!=0) {
			model.addAttribute("top",topRanking.get(0));
		}else {
			model.addAttribute("top",new Idea("Not enough informations.","not enough informations.","https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png",LocalDate.now(),new Category(),new User()));
		}
		
		List<Idea> buzzRanking = rankingUtil.getBuzzRanking();
		if(buzzRanking.size()!=0) {
			model.addAttribute("buzz",buzzRanking.get(0));			
		}else {
			model.addAttribute("buzz",new Idea("Not enough informations.","not enough informations.","https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png",LocalDate.now(),new Category(),new User()));
		}
		
		List<User> brainsRanking = rankingUtil.getBrainRanking();
		if(brainsRanking.size()!=0) {
			model.addAttribute("brains",brainsRanking.get(0));			
		}else {
			model.addAttribute("brains",new User("Not enough informations", "", "", null, "", "https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png", false, false));
		}
		
		List<Idea> ideasByCreatedAt = ideaService.findAllByCreateAt();
		if(ideasByCreatedAt.size()>CONSTANT_MAX_VALUES_LATEST) {			
			model.addAttribute("lastIdeas",ideasByCreatedAt.subList(0, 6));
			model.addAttribute("containsFake",false);
		}else {
			List<Idea> lastIdeas = new ArrayList<Idea>();
			for (Idea idea : ideasByCreatedAt) {
				lastIdeas.add(idea);
			}
			for(int i = lastIdeas.size(); i<CONSTANT_MAX_VALUES_LATEST; i++) {
				Idea fake = new Idea("Not enough informations.","not enough informations.","https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png",LocalDate.of(1980, 1, 1),new Category(),new User());
				fake.setActive(false);
				lastIdeas.add(fake);
			}
			model.addAttribute("lastIdeas",lastIdeas);
			model.addAttribute("containsFake",true);
		}
		
		return "home";
	}
}
