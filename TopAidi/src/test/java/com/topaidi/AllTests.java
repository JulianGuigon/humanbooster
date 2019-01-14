package com.topaidi;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.topaidi.dao.AllDaoJpaTests;
import com.topaidi.model.AllModelTest;
import com.topaidi.service.AllServiceJpaTests;

@RunWith(Suite.class)
@SuiteClasses({AllDaoJpaTests.class,AllServiceJpaTests.class, AllModelTest.class})
public class AllTests {

}
