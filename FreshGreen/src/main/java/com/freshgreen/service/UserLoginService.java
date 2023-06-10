package com.freshgreen.service;

import com.freshgreen.entity.User;
import com.freshgreen.exception.UserException;

public interface UserLoginService {

	public String logIntoAccount(User user) throws UserException;

    public String logOutFromAccount(String key) throws UserException;
}
