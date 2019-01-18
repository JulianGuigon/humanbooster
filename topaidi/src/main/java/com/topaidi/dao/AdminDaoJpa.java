package com.topaidi.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.topaidi.dao.interfaces.AdminDao;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

@Repository
@Transactional
public class AdminDaoJpa implements AdminDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void delete(Admin obj) {
		em.remove(findByKey(obj.getId()));
	}
	
	@Override
	public void deleteByKey(Integer key) {
		em.remove(findByKey(key));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Admin> findAll() {
		return em.createQuery("from Admin e order by e.id").getResultList();
	}

	@Override
	public Admin findByKey(Integer key) {
		return em.find(Admin.class, key);
	}

	@Override
	public Admin insert(Admin obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Admin update(Admin obj) {
		return em.merge(obj);
	}

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		Admin found;
		try {
			found = (Admin) em.createQuery("from Admin where email = :email AND password = :password")
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		}catch(NoResultException n) {
			found = null;
		}
		return found;
	}

	@Override
	public boolean findEmailExist(String email) {
		boolean retour = true;
		try {
			Query query = em.createQuery("from Admin where email = :email");
			query.setParameter("email", email);
			query.getSingleResult();
		} catch (NoResultException e) {
			retour = false;
		}
		
		return retour;
	}

	@Override
	public boolean desactiveIdea(Idea idea) {
		boolean retour = true;
		try {
			idea.setActive(false);
			idea.setDisabledAt(LocalDate.now());
			em.merge(idea);
		} catch (IllegalArgumentException ie) {
			retour = false;
		} catch (TransactionRequiredException te) {
			retour = false;
		}
		return retour;
	}

	@Override
	public boolean desactiveUser(User user) {
		boolean retour = true;
		try {
			user.setActive(false);
			em.merge(user);
		} catch (IllegalArgumentException ie) {
			retour = false;
		} catch (TransactionRequiredException te) {
			retour = false;
		}
		return retour;
	}
	
	@Override
	public boolean activateUser(User user) {
		boolean retour = true;
		try {
			user.setActive(true);
			em.merge(user);
		} catch (IllegalArgumentException ie) {
			retour = false;
		} catch (TransactionRequiredException te) {
			retour = false;
		}
		return retour;
	}

	@Override
	public boolean desactiveComment(Comment comment) {
		boolean retour = true;
		try {
			comment.setActive(false);
			em.merge(comment);
		} catch (IllegalArgumentException ie) {
			retour = false;
		} catch (TransactionRequiredException te) {
			retour = false;
		}
		return retour;
	}

	@Override
	public boolean validateUser(User user) {
		boolean retour = true;
		try {
			user.setValid(true);
			em.merge(user);
		} catch (IllegalArgumentException ie) {
			retour = false;
		} catch (TransactionRequiredException te) {
			retour = false;
		}
		return retour;
	}

}