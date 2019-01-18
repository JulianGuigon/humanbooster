package com.topaidi.utils;

import java.util.List;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

public class RankingUtil {
	
	private UserService userService;
	private IdeaService ideaService;
	
	public RankingUtil(UserService userService, IdeaService ideaService) {
		this.userService = userService;
		this.ideaService = ideaService;
	}
	
	public User getBrainRanking(){
		throw new UnsupportedOperationException();
	}
	
	public Idea getBuzzRanking(){
		throw new UnsupportedOperationException();
	}
	
	public Idea getTopRanking(){
//		int topId = 0;
//		Idea top = new Idea();
//		List<Idea> ideas = ideaService.findAll();
//		for(Idea idea : ideas) {
//			idea.getListTop()
//		}
//		return top;
		throw new UnsupportedOperationException();
	}
	
	private User getBrainRanking(List<Idea> ideas){
		throw new UnsupportedOperationException();
	}
	
	private Idea getBuzzRanking(List<Idea> ideas){
		throw new UnsupportedOperationException();
	}
	
	private Idea getTopRanking(List<Idea> ideas){
		throw new UnsupportedOperationException();
	}
	
	public List<User> get3BrainRanking(){
		throw new UnsupportedOperationException();
	}
	
	public List<Idea> get3BuzzRanking(){
		throw new UnsupportedOperationException();
	}
	
	public List<Idea> get3TopRanking(){
		throw new UnsupportedOperationException();
	}
}
