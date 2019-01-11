package com.topaidi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.model.roles.Visitor;
import com.topaidi.service.interfaces.VisitorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class VisitorServiceJpaTest {

	@Autowired
	VisitorService visitorService;
	
	@Test
	public void testDelete() {
		Visitor visitor = new Visitor();
		visitorService.insert(visitor);
		
		visitorService.delete(visitor);
		assertNull(visitorService.findByKey(visitor.getId()));
	}
	
	@Test
	public void testDeleteByKey() {
		Visitor visitor = new Visitor();
		visitorService.insert(visitor);
		
		visitorService.deleteByKey(visitor.getId());
		assertNull(visitorService.findByKey(visitor.getId()));
	}
	
	@Test
	public void testFindAll() {
		Visitor visitor1 = new Visitor();
		Visitor visitor2 = new Visitor();
		Visitor visitor3 = new Visitor();
		visitorService.insert(visitor1);
		visitorService.insert(visitor2);
		visitorService.insert(visitor3);
		
		assertTrue(visitorService.findAll().size()==3);
	}
	
	@Test
	public void testFindByKey() {
		Visitor visitor = new Visitor();
		visitorService.insert(visitor);
		
		assertNotNull(visitor.getId());
		assertTrue(visitorService.findByKey(visitor.getId())!=null);
	}

	@Test
	public void testInsert() {
		int size = visitorService.findAll().size();
		
		Visitor visitor = new Visitor();
		visitorService.insert(visitor);
		
		assertNotNull(visitor.getId());
		assertTrue(visitorService.findAll().size() == size+1);
	}

}
