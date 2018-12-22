package com.topaidi.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Note;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.utility.Connection;

import javassist.NotFoundException;

public class NoteJpaDaoTest {
	private User user = new User("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a",true,true);
	private Idea idea = new Idea("idea1","a","a",LocalDate.now(),new Category("cuisine",LocalDate.now(),new Admin("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a"),null),user);
	
	@Before
	public void init() {
		
	}

	@Test
	public void testUpdateNote() {
		Note note = new Note(true,idea,user);
		NoteJpaDao noteJpaDao = new NoteJpaDao();
		noteJpaDao.insert(note);
		note.setTop(false);;
		try {
			note = noteJpaDao.update(note);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			Assert.assertTrue(!noteJpaDao.findByKey(note.getId()).isTop());
		} catch (NotFoundException e) {
			fail();
		}
	}

	@Test
	public void testDeleteNote() {
		Note note = new Note(true,idea,user);
		NoteJpaDao noteJpaDao = new NoteJpaDao();
		noteJpaDao.insert(note);
		try {
			noteJpaDao.delete(note);
		} catch (NotFoundException e) {
			fail();
		}
		try {
			noteJpaDao.findByKey(note.getId());
			fail();
		} catch (NotFoundException e) {
		}
	}

	@Test
	public void testFindAll() {
		Note note1 = new Note(true,idea,user);
		Note note2 = new Note(true,idea,user);
		Note note3 = new Note(true,idea,user);
		NoteJpaDao NoteJpaDao = new NoteJpaDao();
		NoteJpaDao.insert(note1);
		NoteJpaDao.insert(note2);
		NoteJpaDao.insert(note3);
		assertTrue(NoteJpaDao.findAll().size()==3);
	}

	@Test
	public void testInsertAndFindByKey() {
		Note note = new Note(true,idea,user);
		NoteJpaDao NoteJpaDao = new NoteJpaDao();
		NoteJpaDao.insert(note);
		try {
			NoteJpaDao.findByKey(note.getId());
		} catch (NotFoundException e) {
			fail();
		}
	}
	
	@After
	public void after() {
		Connection.stop();
	}
}
