package com.topaidi.dao;

import com.topaidi.enums.AlertType;
import com.topaidi.model.Alert;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;

import javassist.NotFoundException;

public class AlertJpaDao extends GenericJpaDao<Alert, Integer> {
	private UserJpaDao userJpaDao = new UserJpaDao();
	private IdeaJpaDao ideaJpaDao = new IdeaJpaDao();
	private CommentJpaDao commentJpaDao = new CommentJpaDao();
	
	@Override
	public void insert(Alert obj) {
		if(obj.getAlertType()==AlertType.Comment) {
			Comment comment = obj.getCommentAlerted();
			if(comment.getId()!=0) {
				try {
					comment = commentJpaDao.findByKey(comment.getId());
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
			}else {
				commentJpaDao.insert(comment);
			}
		}else if(obj.getAlertType()==AlertType.Idea) {
			Idea idea = obj.getIdeaAlerted();
			if(idea.getId()!=0) {
				try {
					idea = ideaJpaDao.findByKey(idea.getId());
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
			}else {
				ideaJpaDao.insert(idea);
			}
		}
		User user = obj.getUserAlerting();
		if(user.getId()!=0) {
			try {
				user = userJpaDao.findByKey(user.getId());
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}else {
			userJpaDao.insert(user);
		}
		
		super.insert(obj);
	}
	
	public Alert update(Alert entity) throws NotFoundException {
		return super.update(entity, entity.getId());
	}

	@Override
	public void delete(Integer key) throws NotFoundException {
		super.delete(key);
	}
	
	public void delete(Alert entity) throws NotFoundException {
		delete(entity.getId());
	}
}
