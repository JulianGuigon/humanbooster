package com.topaidi.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressServiceJpaTest.class, AdminServiceJpaTest.class, AlertServiceJpaTest.class,
		CategoryServiceJpaTest.class, CommentServiceJpaTest.class, IdeaServiceJpaTest.class, NoteServiceJpaTest.class,
		UserServiceJpaTest.class, VisitorServiceJpaTest.class })
public class AllServiceJpaTests {

}
