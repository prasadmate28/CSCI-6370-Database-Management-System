package com.dbproject5.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbproject5.cloud.dao.LoginDao;
import com.dbproject5.cloud.dao.ServiceAllocationDao;
import com.dbproject5.cloud.dao.ServiceAllocationRepository;
import com.dbproject5.cloud.dao.StudentRepository;
import com.dbproject5.cloud.dao.impl.LoginDaoImpl;
import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.CloudAllocationService;

@Service
public class CloudAllocationServiceImpl implements CloudAllocationService {
	
	@Autowired
	public ServiceAllocationRepository serviceRepo;
	
	@Autowired
	public ServiceAllocationDao serviceAllocDao;
	
	@Autowired
	public StudentRepository studRepo;
	
	@Autowired 
	LoginDao loginDao;
	
	@Autowired
	LoginDaoImpl logDaoImpl;



	@Override
	public List<Users> geStudentsHoldingService(Users user) {
		// TODO Auto-generated method stub
		List<Integer> studId=studRepo.findByfacultyId(user.getXx81_ID());
		List<Users> students=loginDao.findByuserIdIn(studId);
		return students;
	}



	@Override
	public List<Users> findByDepartment(Users user) {
		// TODO Auto-generated method stub
		return logDaoImpl.findStudentsInDepartment(user);
	}

}
