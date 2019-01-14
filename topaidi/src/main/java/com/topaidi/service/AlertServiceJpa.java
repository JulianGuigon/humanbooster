package com.topaidi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topaidi.dao.interfaces.AlertDao;
import com.topaidi.enums.AlertType;
import com.topaidi.model.Alert;
import com.topaidi.service.interfaces.AlertService;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@Service
public class AlertServiceJpa implements AlertService{

	@Autowired
	AlertDao alertDao;
	@Autowired
	IdeaService ideaService;
	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	
	@Override
	public void delete(Alert obj) {
		alertDao.delete(obj);
	}

	@Override
	public void deleteByKey(Integer key) {
		alertDao.deleteByKey(key);
	}

	@Override
	public List<Alert> findAll() {
		return alertDao.findAll();
	}
	
	@Override
	public List<Alert> findAllByCreateAt(){
		return alertDao.findAllByCreateAt();
	}
	
	@Override
	public List<Alert> findAllByCreateAtAndByType(AlertType type){
		return alertDao.findAllByCreateAtAndByType(type);
	}

	@Override
	public Alert findByKey(Integer key) {
		return alertDao.findByKey(key);
	}

	@Override
	public Alert insert(Alert obj) {
		if(obj.getUserAlerting().getId()==null) {
			userService.insert(obj.getUserAlerting());
		}else {
			obj.setUserAlerting(userService.findByKey(obj.getUserAlerting().getId()));
		}
		if(obj.getAlertType().equals(AlertType.Idea)) {
			if(obj.getIdeaAlerted().getId()==null) {
				ideaService.insert(obj.getIdeaAlerted());
			}else {
				obj.setIdeaAlerted(ideaService.findByKey(obj.getIdeaAlerted().getId()));
			}
		}
		else if(obj.getAlertType().equals(AlertType.Comment)) {
			if(obj.getCommentAlerted().getId()==null) {
				commentService.insert(obj.getCommentAlerted());
			}else {
				obj.setCommentAlerted(commentService.findByKey(obj.getCommentAlerted().getId()));
			}
		}
		return alertDao.insert(obj);
	}

	@Override
	public Alert update(Alert obj) {
		return alertDao.update(obj);
	}

}
