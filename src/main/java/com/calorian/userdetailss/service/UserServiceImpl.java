package com.calorian.userdetailss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calorian.userdetailss.dao.IuserDAO;
import com.calorian.userdetailss.model.User;
import com.calorian.userdetailss.utility.JWTProvider;

@Service
public class UserServiceImpl implements IuserService {

	@Autowired
	private IuserDAO userDAO;

	@Autowired
	private JWTProvider provider;

	
	@Transactional
	@Override
	public String login(String emailId, String password) {
		String tocken = null;
		List<User> userList = userDAO.getAllUser();
		for (User user : userList) {
			if (user.getEmailId().equalsIgnoreCase(emailId) && user.getPassword().equals(password)) {
					String id = user.getUserId().toString();
					tocken = provider.generateToken(id);
					return tocken;
				}
		}
		return tocken;
	}


	@Transactional
	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public Long getUserId(String token) {
		Long id = Long.parseLong(provider.parseToken(token));
		User user = userDAO.getUserById(id);
		return user.getUserId();
	}

}
