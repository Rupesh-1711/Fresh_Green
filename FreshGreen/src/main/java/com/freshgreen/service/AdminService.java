package com.freshgreen.service;

import com.freshgreen.entity.Admin;
import com.freshgreen.exception.AdminException;
import com.freshgreen.exception.UserException;

public interface AdminService {

	
	public Admin addAdmin(Admin admin) throws AdminException;
	
	public Admin viewAdmin(Integer admin_id,String key) throws AdminException,UserException;
	
	public Admin updateAdmin( Admin admin,String key) throws AdminException,UserException;
	
	public Admin removeAdmin(Integer admin_id,String key)throws AdminException,UserException;
}
