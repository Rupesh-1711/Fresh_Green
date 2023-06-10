package com.freshgreen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshgreen.entity.Admin;
import com.freshgreen.exception.AdminException;
import com.freshgreen.exception.UserException;
import com.freshgreen.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminDao adminDao;

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {

		Admin newAdmin = adminDao.save(admin);

		return newAdmin;
	}

	@Override
	public Admin viewAdmin(Integer admin_id, String key) throws AdminException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin removeAdmin(Integer admin_id, String key) throws AdminException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
