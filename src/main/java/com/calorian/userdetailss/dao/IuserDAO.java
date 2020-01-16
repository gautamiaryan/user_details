package com.calorian.userdetailss.dao;
import java.util.List;

import com.calorian.userdetailss.model.User;


public interface IuserDAO {
	
	
	List<User> getAllUser();
	
	
	User getUserById(Long id);
	
	

}