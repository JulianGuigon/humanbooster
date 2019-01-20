package com.topaidi.utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.NoteService;
import com.topaidi.service.interfaces.UserService;

public class RankingUtil {
	private UserService userService;
	private IdeaService ideaService;
	private NoteService noteService;
	
	public RankingUtil(UserService userService, IdeaService ideaService, NoteService noteService) {
		this.userService = userService;
		this.ideaService = ideaService;
		this.noteService = noteService;
	}
	
	public List<User> getBrainRanking(){
		return userService.findAll().stream()
				.sorted(Comparator.comparing((User u) -> (ideaService.findAllWithUser(u).size())*-1))
				.collect(Collectors.toList());
	}
	
	public List<Idea> getBuzzRanking(){
		return ideaService.findAll().stream()
				.sorted(Comparator.comparing((Idea i) -> (noteService.findAllTopByIdea(i.getId()).size()+noteService.findAllFlopByIdea(i.getId()).size())*-1))
				.collect(Collectors.toList());
	}
	
	public List<Idea> getTopRanking(){
		return ideaService.findAll().stream()
				.sorted(Comparator.comparing((Idea i) -> (((float)noteService.findAllTopByIdea(i.getId()).size())/((float)noteService.findAllFlopByIdea(i.getId()).size()))*-1)
						.thenComparing((Idea i) -> (noteService.findAllTopByIdea(i.getId()).size()+noteService.findAllFlopByIdea(i.getId()).size())*-1)
						.thenComparing((Idea i) -> i.getCreatedAt()))
				.collect(Collectors.toList());
	}
}
