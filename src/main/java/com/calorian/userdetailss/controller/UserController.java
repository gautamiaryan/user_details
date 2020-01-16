package com.calorian.userdetailss.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calorian.userdetailss.dto.LoginDTO;
import com.calorian.userdetailss.response.Response;
import com.calorian.userdetailss.service.IuserService;


@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*",exposedHeaders = {"jwtToken"})
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IuserService userService;
	
	
    @PostMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody LoginDTO user) {

		String tocken=userService.login(user.getEmailId(),user.getPassword());
		if(tocken!=null) {
			return new ResponseEntity<>(new Response(HttpStatus.OK.value(),tocken, user),HttpStatus.OK);
		}
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),tocken,user),HttpStatus.BAD_REQUEST);

	}


	 @GetMapping("/verify/{token}")
    public Long getUserId(@PathVariable String token) {
		return userService.getUserId(token);
		
    }
	


}