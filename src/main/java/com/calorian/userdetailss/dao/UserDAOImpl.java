package com.calorian.userdetailss.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calorian.userdetailss.model.User;

@Repository
public class UserDAOImpl implements IuserDAO {

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public List<User> getAllUser() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		return userList;
	}

	

	@Override
	public User getUserById(Long id) {
		List<User> userList = getAllUser();
		User user = null;
		for (User userObj : userList) {
			if (userObj.getUserId().equals(id)) {
				user = userObj;
			}
		}
		return user;
	}

}
