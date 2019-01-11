package com.topaidi.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.ContextConfig;
import com.topaidi.dao.interfaces.VisitorDao;
import com.topaidi.model.roles.Visitor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ContextConfig.class})
@Transactional
public class VisitorDaoJpaTest {
	
	@Autowired
	VisitorDao visitorDao;

	@Test
	public void testDelete() {
		Visitor visitor = new Visitor();
		visitorDao.insert(visitor);
		
		visitorDao.delete(visitor);
		assertNull(visitorDao.findByKey(visitor.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Visitor visitor = new Visitor();
		visitorDao.insert(visitor);
		
		visitorDao.deleteByKey(visitor.getId());
		assertNull(visitorDao.findByKey(visitor.getId()));
	}
	
	@Test
	public void testFindAll() {
		Visitor visitor1 = new Visitor();
		Visitor visitor2 = new Visitor();
		Visitor visitor3 = new Visitor();
		visitorDao.insert(visitor1);
		visitorDao.insert(visitor2);
		visitorDao.insert(visitor3);
		
		assertTrue(visitorDao.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Visitor visitor = new Visitor();
		visitorDao.insert(visitor);
		
		assertNotNull(visitor.getId());
		assertTrue(visitorDao.findByKey(visitor.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = visitorDao.findAll().size();
		
		Visitor visitor = new Visitor();
		visitorDao.insert(visitor);
		
		assertNotNull(visitor.getId());
		assertTrue(visitorDao.findAll().size() == size+1);
	}
	
}
