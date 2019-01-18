package com.topaidi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.enums.AlertType;
import com.topaidi.model.Address;
import com.topaidi.model.Alert;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AlertService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AlertServiceJpaTest {

	@Autowired
	AlertService alertService;
	
	@Test
	public void testDeleteWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",idea,user2);
		alertService.insert(alert);
		
		alertService.delete(alert);
		assertNull(alertService.findByKey(alert.getId()));
	}
	
	@Test
	public void testDeleteWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",comment,user3);
		alertService.insert(alert);
		
		alertService.delete(alert);
		assertNull(alertService.findByKey(alert.getId()));
	}
	
	@Test
	public void testDeleteByKeyWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",idea,user2);
		alertService.insert(alert);
		
		alertService.deleteByKey(alert.getId());
		assertNull(alertService.findByKey(alert.getId()));
	}
	
	@Test
	public void testDeleteByKeyWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",comment,user3);
		alertService.insert(alert);
		
		alertService.deleteByKey(alert.getId());
		assertNull(alertService.findByKey(alert.getId()));
	}

	@Test
	public void testFindAll() {
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
		Address address6 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address6,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user3);
		Address address7 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address8 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address9 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user4 = new User("Jean Guy","a.g@gmail.com","aaaa",address7,"0477265898","http://placehold.it/100x100",true,true);
		User user5 = new User("Jean Robert","a.g@gmail.com","aaaa",address8,"0477265898","http://placehold.it/100x100",true,true);
		User user6 = new User("Jean Bernard","a.g@gmail.com","aaaa",address9,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment1 = new Comment("ahaha",user4,idea1);
		Comment comment2 = new Comment("ahaha2",user5,idea2);
		Comment comment3 = new Comment("ahaha3",user6,idea3);
		Address address10 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address11 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address12 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user7 = new User("Jean Guy","a.g@gmail.com","aaaa",address10,"0477265898","http://placehold.it/100x100",true,true);
		User user8 = new User("Jean Robert","a.g@gmail.com","aaaa",address11,"0477265898","http://placehold.it/100x100",true,true);
		User user9 = new User("Jean Bernard","a.g@gmail.com","aaaa",address12,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert1 = new Alert("Alert1",comment1,user7);
		Alert alert2 = new Alert("Alert2",comment2,user8);
		Alert alert3 = new Alert("Alert3",comment3,user9);
		alertService.insert(alert1);
		alertService.insert(alert2);
		alertService.insert(alert3);
		
		Address address13 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address14 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address15 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin4 = new Admin("Jean Guy","a.g@gmail.com","aaaa",address13,"0477265898","http://placehold.it/100x100");
		Admin admin5 = new Admin("Jean Robert","a.g@gmail.com","aaaa",address14,"0477265898","http://placehold.it/100x100");
		Admin admin6 = new Admin("Jean Bernard","a.g@gmail.com","aaaa",address15,"0477265898","http://placehold.it/100x100");
		Category category4 = new Category("cuisine",LocalDate.now(),admin4);
		Category category5 = new Category("botanique",LocalDate.now(),admin5);
		Category category6 = new Category("echecs",LocalDate.now(),admin6);
		Address address16 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address17 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address18 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user10 = new User("Jean Guy","a.g@gmail.com","aaaa",address16,"0477265898","http://placehold.it/100x100",true,true);
		User user11 = new User("Jean Robert","a.g@gmail.com","aaaa",address17,"0477265898","http://placehold.it/100x100",true,true);
		User user12 = new User("Jean Bernard","a.g@gmail.com","aaaa",address18,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea4 = new Idea("idea1","a","a",LocalDate.now(),category4,user10);
		Idea idea5 = new Idea("idea2","a","a",LocalDate.now(),category5,user11);
		Idea idea6 = new Idea("idea3","a","a",LocalDate.now(),category6,user12);
		Alert alert4 = new Alert("Alert1",idea4,user10);
		Alert alert5 = new Alert("Alert2",idea5,user11);
		Alert alert6 = new Alert("Alert3",idea6,user12);
		alertService.insert(alert4);
		alertService.insert(alert5);
		alertService.insert(alert6);
		
		assertTrue(alertService.findAll().size()==6);
	}
	
	@Test
	public void testFindAllByCreateAt() {
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
		Address address6 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address6,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user3);
		Address address7 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address8 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address9 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user4 = new User("Jean Guy","a.g@gmail.com","aaaa",address7,"0477265898","http://placehold.it/100x100",true,true);
		User user5 = new User("Jean Robert","a.g@gmail.com","aaaa",address8,"0477265898","http://placehold.it/100x100",true,true);
		User user6 = new User("Jean Bernard","a.g@gmail.com","aaaa",address9,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment1 = new Comment("ahaha",user4,idea1);
		Comment comment2 = new Comment("ahaha2",user5,idea2);
		Comment comment3 = new Comment("ahaha3",user6,idea3);
		Address address10 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address11 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address12 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user7 = new User("Jean Guy","a.g@gmail.com","aaaa",address10,"0477265898","http://placehold.it/100x100",true,true);
		User user8 = new User("Jean Robert","a.g@gmail.com","aaaa",address11,"0477265898","http://placehold.it/100x100",true,true);
		User user9 = new User("Jean Bernard","a.g@gmail.com","aaaa",address12,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert1 = new Alert("Alert1",LocalDate.of(2015, 01, 10),AlertType.Comment,comment1,user7);
		Alert alert2 = new Alert("Alert2",LocalDate.of(2015, 02, 10),AlertType.Comment,comment2,user8);
		Alert alert3 = new Alert("Alert3",LocalDate.of(2015, 03, 10),AlertType.Comment,comment3,user9);
		alertService.insert(alert1);
		alertService.insert(alert2);
		alertService.insert(alert3);
		
		assertTrue(alertService.findAllByCreateAt().get(2).getMessage().equals("Alert1"));
	}
	
	@Test
	public void testFindAllByCreateAtAndByType() {
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
		Address address6 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		User user2 = new User("Jean Robert","a.g@gmail.com","aaaa",address5,"0477265898","http://placehold.it/100x100",true,true);
		User user3 = new User("Jean Bernard","a.g@gmail.com","aaaa",address6,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea1 = new Idea("idea1","a","a",LocalDate.now(),category1,user1);
		Idea idea2 = new Idea("idea2","a","a",LocalDate.now(),category2,user2);
		Idea idea3 = new Idea("idea3","a","a",LocalDate.now(),category3,user3);
		Address address7 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address8 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address9 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user4 = new User("Jean Guy","a.g@gmail.com","aaaa",address7,"0477265898","http://placehold.it/100x100",true,true);
		User user5 = new User("Jean Robert","a.g@gmail.com","aaaa",address8,"0477265898","http://placehold.it/100x100",true,true);
		User user6 = new User("Jean Bernard","a.g@gmail.com","aaaa",address9,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment1 = new Comment("ahaha",user4,idea1);
		Comment comment2 = new Comment("ahaha2",user5,idea2);
		Comment comment3 = new Comment("ahaha3",user6,idea3);
		Address address10 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address11 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Address address12 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user7 = new User("Jean Guy","a.g@gmail.com","aaaa",address10,"0477265898","http://placehold.it/100x100",true,true);
		User user8 = new User("Jean Robert","a.g@gmail.com","aaaa",address11,"0477265898","http://placehold.it/100x100",true,true);
		User user9 = new User("Jean Bernard","a.g@gmail.com","aaaa",address12,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert1 = new Alert("Alert1",LocalDate.of(2015, 01, 10),AlertType.Comment,comment1,user7);
		Alert alert2 = new Alert("Alert2",LocalDate.of(2015, 02, 10),AlertType.Comment,comment2,user8);
		Alert alert3 = new Alert("Alert3",LocalDate.of(2015, 03, 10),AlertType.Comment,comment3,user9);
		alertService.insert(alert1);
		alertService.insert(alert2);
		alertService.insert(alert3);
		
		assertTrue(alertService.findAllByCreateAtAndByType(AlertType.Comment).get(0).getMessage().equals("Alert3"));
	}
	
	@Test
	public void testFindByKeyWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",idea,user2);
		alertService.insert(alert);
		
		assertNotNull(alert);
		assertTrue(alertService.findByKey(alert.getId())!=null);
	}
	
	@Test
	public void testFindByKeyWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",comment,user3);
		alertService.insert(alert);
		
		assertNotNull(alert);
		assertTrue(alertService.findByKey(alert.getId())!=null);
	}
	
	@Test
	public void testInsertWithIdea() {
		int size = alertService.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",idea,user2);
		alertService.insert(alert);
		
		assertNotNull(alert.getId());
		assertTrue(alertService.findAll().size() == size+1);
	}
	
	@Test
	public void testInsertWithComment() {
		int size = alertService.findAll().size();
		
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",comment,user3);
		alertService.insert(alert);
		
		assertNotNull(alert.getId());
		assertTrue(alertService.findAll().size() == size+1);
	}
	
	@Test
	public void testUpdateWithIdea() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",idea,user2);
		alertService.insert(alert);
		
		alert.setMessage("Alert4");
		alert = alertService.update(alert);
		Assert.assertTrue(alertService.findByKey(alert.getId()).getMessage().equals("Alert4"));
	}
	
	@Test
	public void testUpdateWithComment() {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
		Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
		Comment comment = new Comment("ahaha",user2,idea);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user3 = new User("Jean Guy","a.g@gmail.com","aaaa",address4,"0477265898","http://placehold.it/100x100",true,true);
		Alert alert = new Alert("Alert1",comment,user3);
		alertService.insert(alert);
		
		alert.setMessage("Alert4");
		alert = alertService.update(alert);
		Assert.assertTrue(alertService.findByKey(alert.getId()).getMessage().equals("Alert4"));
	}
}
