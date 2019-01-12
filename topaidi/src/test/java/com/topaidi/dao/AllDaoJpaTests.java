package com.topaidi.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressDaoJpaTest.class, AdminDaoJpaTest.class, AlertDaoJpaTest.class, CategoryDaoJpaTest.class,
		CommentDaoJpaTest.class, IdeaDaoJpaTest.class, NoteDaoJpaTest.class, UserDaoJpaTest.class,
		VisitorDaoJpaTest.class })
public class AllDaoJpaTests {

}
