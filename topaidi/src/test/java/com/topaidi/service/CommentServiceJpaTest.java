package com.topaidi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class CommentServiceJpaTest {

	 @Autowired
	 CommentService commentService;
	
	 @Test
		public void testDelete() {
			Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
			Category category = new Category("cuisine",LocalDate.now(),admin);
			Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
			Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
			Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
			Comment comment = new Comment("ahaha",user2,idea);
			commentService.insert(comment);
			
			commentService.delete(comment);
			assertNull(commentService.findByKey(comment.getId()));
		}
		
		@Test
		public void testDeleteByKey() {
			Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
			Category category = new Category("cuisine",LocalDate.now(),admin);
			Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
			Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
			Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
			Comment comment = new Comment("ahaha",user2,idea);
			commentService.insert(comment);
			
			commentService.deleteByKey(comment.getId());
			assertNull(commentService.findByKey(comment.getId()));
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
			commentService.insert(comment1);
			commentService.insert(comment2);
			commentService.insert(comment3);
			
			assertTrue(commentService.findAll().size()==3);
		}
		
		@Test
		public void testFindAllError() {
			assertTrue(commentService.findAll().size()==0);
		}
		
		@Test
		public void testFindByKey() {
			Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
			Category category = new Category("cuisine",LocalDate.now(),admin);
			Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
			Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
			Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
			Comment comment = new Comment("ahaha",user2,idea);
			commentService.insert(comment);
			
			assertNotNull(comment);
			assertTrue(commentService.findByKey(comment.getId())!=null);
		}
		
		@Test
		public void testInsert() {
			int size = commentService.findAll().size();
			
			Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
			Category category = new Category("cuisine",LocalDate.now(),admin);
			Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
			Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
			Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
			Comment comment = new Comment("ahaha",user2,idea);
			commentService.insert(comment);
			
			assertNotNull(comment.getId());
			assertTrue(commentService.findAll().size() == size+1);
		}
		
		@Test
		public void testUpdate() {
			Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898","http://placehold.it/100x100");
			Category category = new Category("cuisine",LocalDate.now(),admin);
			Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user1 = new User("Jean Guy","a.g@gmail.com","aaaa",address2,"0477265898","http://placehold.it/100x100",true,true);
			Idea idea = new Idea("idea1","a","a",LocalDate.now(),category,user1);
			Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
			User user2 = new User("Jean Guy","a.g@gmail.com","aaaa",address3,"0477265898","http://placehold.it/100x100",true,true);
			Comment comment = new Comment("ahaha",user2,idea);
			commentService.insert(comment);
			
			comment.setValue("Comment4");
			comment = commentService.update(comment);
			assertTrue(commentService.findByKey(comment.getId()).getValue().equals("Comment4"));
		}

}
