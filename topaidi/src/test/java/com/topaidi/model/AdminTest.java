package com.topaidi.model;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topaidi.config.JpaConfig;
import com.topaidi.dao.interfaces.IdeaDao;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.IdeaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
@Transactional
public class AdminTest {
	
	@Autowired
	IdeaService ideaService;

}
