package com.freshgreen.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshgreen.entity.Admin;
import com.freshgreen.entity.CurrentUserSession;
import com.freshgreen.entity.Customer;
import com.freshgreen.entity.User;
import com.freshgreen.exception.UserException;
import com.freshgreen.repository.AdminDao;
import com.freshgreen.repository.CustomerDao;
import com.freshgreen.repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;


@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public String logIntoAccount(User user) throws UserException {

		if(user.getRole().equalsIgnoreCase("admin")){
			Admin admin = adminDao.findByEmailId(user.getEmailId());
			 
			 if(admin==null) {
				 throw new UserException("Invalid User Id !");
			 }
			 Optional<CurrentUserSession> validOpt = userSessionDao.findById(admin.getAdminId());
			 
			 if(validOpt.isPresent()) {
				 throw new UserException("User Already Logged In !");
			 }
			 
			 if(admin.getPassword().equals(user.getPassword())) {
				
				 String key= RandomString.make(6);
				 
				 CurrentUserSession currentAdminSession = new CurrentUserSession(admin.getAdminId(),key,LocalDateTime.now());

				 userSessionDao.save(currentAdminSession);

		         return currentAdminSession.toString();
			 }else {
				 throw new UserException("Please Enter valid Password");
			 }	 
			 
		}else if(user.getRole().equalsIgnoreCase("customer")){
			
			Customer customer = customerDao.findByEmailId(user.getEmailId());
			 
			 if(customer==null) {
				 throw new UserException("Invalid User Id !");
			 }
			 Optional<CurrentUserSession> validOpt = userSessionDao.findById(customer.getCustomerId());
			 
			 if(validOpt.isPresent()) {
				 throw new UserException("User Already Logged In !");
			 }
			 
			 if(customer.getPassword().equals(user.getPassword())) {
				 String key= RandomString.make(6);
				 
				 CurrentUserSession currentCustomerSession = new CurrentUserSession(customer.getCustomerId(),key,LocalDateTime.now());

				 userSessionDao.save(currentCustomerSession);

		         return currentCustomerSession.toString();
			 }else {
				 throw new UserException("Please Enter valid Password");
			 }	 
			
		}else {
			throw new UserException("Invalid User Details !");
		}
		
	}

	@Override
	public String logOutFromAccount(String key) throws UserException {
		CurrentUserSession currentUserSession = userSessionDao.findByUuid(key);
		
		if(currentUserSession.equals(null)) {
			throw new UserException("User not logged In");
		}
		
		userSessionDao.delete(currentUserSession);
		
		
		return "User Successfully Logged Out";
	}

}
