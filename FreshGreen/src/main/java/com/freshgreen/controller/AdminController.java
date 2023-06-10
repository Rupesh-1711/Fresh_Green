package com.freshgreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freshgreen.entity.Admin;
import com.freshgreen.exception.AdminException;
import com.freshgreen.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	
	@PostMapping("/registerNewAdmin")
	public ResponseEntity<Admin> registerNewAdminHandler(@RequestBody Admin admin ) throws AdminException{
		
		Admin newAdmin = adminService.addAdmin(admin);
		
		return new ResponseEntity<Admin>(newAdmin,HttpStatus.OK);
	}
}
