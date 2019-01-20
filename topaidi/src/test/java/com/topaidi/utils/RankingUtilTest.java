package com.topaidi.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.NoteService;
import com.topaidi.service.interfaces.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class RankingUtilTest {

	@Autowired
	IdeaService ideaService;
	@Autowired
	UserService userService;
	@Autowired
	NoteService noteService;
	
	private RankingUtil rankingUtil;

	@Test
	public void testGetBrainRanking() {
		rankingUtil = new RankingUtil(userService, ideaService, noteService);
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100");
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Category category3 = new Category("echecs",LocalDate.now(),admin3);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user2);
		ideaService.insert(idea1);
		ideaService.insert(idea2);
		ideaService.insert(idea3);
		
		List<User> brainRanking = rankingUtil.getBrainRanking();
		assertTrue(brainRanking.get(0).getName().equals("Jean Robert"));
	}

	@Test
	public void testGetBuzzRanking() {
		rankingUtil = new RankingUtil(userService, ideaService, noteService);
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Admin admin3 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100");
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Category category3 = new Category("echecs",LocalDate.now(),admin3);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user2);
		Note note1 = new Note(true,idea1,user2);
		Note note2 = new Note(true,idea1,user2);
		Note note3 = new Note(true,idea1,user2);
		Note note4 = new Note(true,idea2,user2);
		Note note5 = new Note(true,idea2,user2);
		Note note6 = new Note(true,idea3,user2);
		noteService.insert(note1);
		noteService.insert(note2);
		noteService.insert(note3);
		noteService.insert(note4);
		noteService.insert(note5);
		noteService.insert(note6);
		
		List<Idea> buzzRanking = rankingUtil.getBuzzRanking();
		assertTrue(buzzRanking.get(0).getTitle().equals("idea1"));
	}

	@Test
	public void testGetListByTopRankingCriteriaRatio() {
		rankingUtil = new RankingUtil(userService, ideaService, noteService);
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Note note1 = new Note(true,idea1,user2);
		Note note2 = new Note(true,idea1,user2);
		Note note3 = new Note(true,idea1,user2);
		Note note4 = new Note(false,idea1,user2);
		Note note5 = new Note(false,idea1,user2);
		Note note6 = new Note(true,idea2,user2);
		Note note7 = new Note(true,idea2,user2);
		Note note8 = new Note(true,idea2,user2);
		Note note9 = new Note(false,idea2,user2);
		Note note10 = new Note(false,idea2,user2);
		Note note11 = new Note(false,idea2,user2);
		noteService.insert(note1);
		noteService.insert(note2);
		noteService.insert(note3);
		noteService.insert(note4);
		noteService.insert(note5);
		noteService.insert(note6);
		noteService.insert(note7);
		noteService.insert(note8);
		noteService.insert(note9);
		noteService.insert(note10);
		noteService.insert(note11);
		
		List<Idea> topRanking = rankingUtil.getTopRanking();
		assertTrue(topRanking.get(0).getTitle().equals("idea1"));
	}
	
	@Test
	public void testGetListByTopRankingCriteriaRatioAndVote() {
		rankingUtil = new RankingUtil(userService, ideaService, noteService);
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Note note1 = new Note(true,idea1,user2);
		Note note2 = new Note(true,idea1,user2);
		Note note4 = new Note(false,idea1,user2);
		Note note5 = new Note(false,idea1,user2);
		Note note6 = new Note(true,idea2,user2);
		Note note7 = new Note(true,idea2,user2);
		Note note8 = new Note(true,idea2,user2);
		Note note9 = new Note(false,idea2,user2);
		Note note10 = new Note(false,idea2,user2);
		Note note11 = new Note(false,idea2,user2);
		noteService.insert(note1);
		noteService.insert(note2);
		noteService.insert(note4);
		noteService.insert(note5);
		noteService.insert(note6);
		noteService.insert(note7);
		noteService.insert(note8);
		noteService.insert(note9);
		noteService.insert(note10);
		noteService.insert(note11);
		
		List<Idea> topRanking = rankingUtil.getTopRanking();
		assertTrue(topRanking.get(0).getTitle().equals("idea2"));
	}
	
	@Test
	public void testGetListByTopRankingCriteriaRatioVoteAndCreatedAt() {
		rankingUtil = new RankingUtil(userService, ideaService, noteService);
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin1 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Admin admin2 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100");
		Category category1 = new Category("cuisine",LocalDate.now(),admin1);
		Category category2 = new Category("botanique",LocalDate.now(),admin2);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.of(1997, 01, 01),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Note note1 = new Note(true,idea1,user2);
		Note note2 = new Note(true,idea1,user2);
		Note note4 = new Note(false,idea1,user2);
		Note note5 = new Note(false,idea1,user2);
		Note note6 = new Note(true,idea2,user2);
		Note note7 = new Note(true,idea2,user2);
		Note note9 = new Note(false,idea2,user2);
		Note note10 = new Note(false,idea2,user2);
		noteService.insert(note1);
		noteService.insert(note2);
		noteService.insert(note4);
		noteService.insert(note5);
		noteService.insert(note6);
		noteService.insert(note7);
		noteService.insert(note9);
		noteService.insert(note10);
		
		List<Idea> topRanking = rankingUtil.getTopRanking();
		assertTrue(topRanking.get(0).getTitle().equals("idea1"));
	}

}
