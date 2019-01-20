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
public class RankingController {
	public static final int CONSTANT_MAX_VALUES_RANK = 3;
	
	@Autowired
	IdeaService ideaService;
	@Autowired
	NoteService noteService;
	@Autowired
	UserService userService;
	
	@GetMapping("/ranking")
	public String showRanking(Model model) {
		RankingUtil rankingUtil = new RankingUtil(userService, ideaService, noteService);
		
		List<Idea> topRanking = rankingUtil.getTopRanking();		
		if(topRanking.size()>CONSTANT_MAX_VALUES_RANK) {
			model.addAttribute("listTop",topRanking.subList(0, 3));
			model.addAttribute("containsFake",false);
		}else {
			List<Idea> listTop = new ArrayList<Idea>();
			for (Idea idea : topRanking) {
				listTop.add(idea);
			}
			for(int i = listTop.size(); i<CONSTANT_MAX_VALUES_RANK; i++) {
				Idea fake = new Idea("Not enough informations.","not enough informations.","https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png",LocalDate.of(1980, 1, 1),new Category(),new User());
				fake.setActive(false);
				listTop.add(fake);
			}
			model.addAttribute("listTop",listTop);
			model.addAttribute("containsFake",true);
		}
		
		List<Idea> buzzRanking = rankingUtil.getBuzzRanking();
		if(buzzRanking.size()>CONSTANT_MAX_VALUES_RANK) {
			model.addAttribute("listBuzz",buzzRanking.subList(0, 3));
			model.addAttribute("containsFake",false);
		}else {
			List<Idea> listBuzz = new ArrayList<Idea>();
			for (Idea idea : buzzRanking) {
				listBuzz.add(idea);
			}
			for(int i = listBuzz.size(); i<CONSTANT_MAX_VALUES_RANK; i++) {
				Idea fake = new Idea("Not enough informations.","not enough informations.","https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png",LocalDate.of(1980, 1, 1),new Category(),new User());
				fake.setActive(false);
				listBuzz.add(fake);
			}
			model.addAttribute("listBuzz",listBuzz);
			model.addAttribute("containsFake",true);
		}
		
		List<User> brainsRanking = rankingUtil.getBrainRanking();
		if(brainsRanking.size()>CONSTANT_MAX_VALUES_RANK) {
			model.addAttribute("listBrains",brainsRanking.subList(0, 3));
			model.addAttribute("containsFake",false);
		}else {
			List<User> listBrains = new ArrayList<User>();
			for (User user : brainsRanking) {
				listBrains.add(user);
			}
			for(int i = listBrains.size(); i<CONSTANT_MAX_VALUES_RANK; i++) {
				User fake = new User("Not enough informations", "", "", null, "", "https://mmpkorea.files.wordpress.com/2016/05/big-question-mark.png", false, false);
				fake.setActive(false);
				listBrains.add(fake);
			}
			model.addAttribute("listBrains",listBrains);
			model.addAttribute("containsFake",true);
		}
		
		return "ranking";
	}
}
