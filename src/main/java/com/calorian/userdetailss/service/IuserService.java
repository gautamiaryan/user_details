package com.calorian.userdetailss.service;

import java.util.List;

import com.calorian.userdetailss.model.User;


public interface IuserService {
	
	
    String login(String userName,String password);
	List<User> getAllUser();
	Long getUserId(String token);

}