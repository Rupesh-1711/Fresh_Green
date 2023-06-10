package com.freshgreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freshgreen.entity.User;
import com.freshgreen.exception.UserException;
import com.freshgreen.service.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserLoginService userService;

	@PostMapping("/login")
	public ResponseEntity<String> logInUserHandler(@RequestBody User user) throws UserException{
		
		String key =  userService.logIntoAccount(user);
		
		return new ResponseEntity<String>(key,HttpStatus.OK);
	}
	
	@PostMapping("/userlogout")
    public  ResponseEntity<String>  logoutUserHandler(@RequestParam(required = false) String key) throws UserException {
        
		String user = userService.logOutFromAccount(key);
		return  new ResponseEntity<String>(user,HttpStatus.OK);

    }
}
