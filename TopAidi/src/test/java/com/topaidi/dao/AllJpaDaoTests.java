package com.topaidi.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressJpaDaoTest.class, AdminJpaDaoTest.class, AlertJpaDaoTest.class, CategoryJpaDaoTest.class,
		CommentJpaDaoTest.class, IdeaJpaDaoTest.class, NoteJpaDaoTest.class, UserJpaDaoTest.class,
		VisitorJpaDaoTest.class })
public class AllJpaDaoTests {

}
