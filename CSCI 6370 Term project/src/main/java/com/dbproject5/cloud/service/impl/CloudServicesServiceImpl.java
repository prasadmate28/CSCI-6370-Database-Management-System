package com.dbproject5.cloud.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbproject5.cloud.dao.CloudServiceRepository;
import com.dbproject5.cloud.dao.ServiceAllocationDao;
import com.dbproject5.cloud.dao.ServiceAllocationRepository;
import com.dbproject5.cloud.dao.impl.LoginDaoImpl;
import com.dbproject5.cloud.dao.impl.ServiceAllocationDaoImpl;
import com.dbproject5.cloud.entity.Department;
import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Services;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.CloudServicesService;

@Service
public class CloudServicesServiceImpl implements CloudServicesService {
   
	@Autowired
	CloudServiceRepository serviceRepo;
	
	@Autowired
	ServiceAllocationRepository allocationRepo;
	
	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	@Autowired
	ServiceAllocationDao serviceDaoImpl;
	
	
	@Override
	public List<Services> findAll() {
		// TODO Auto-generated method stub
		return (List<Services>) serviceRepo.findAll();
	}


	@Override
	public ServiceAllocation requestService(String content) {
		// TODO Auto-generated method stub
		ServiceAllocation allocation=null;
		try {
			
			JSONObject jsonObj=new JSONObject(content);
			allocation=new ServiceAllocation();
			allocation.setDeptId(jsonObj.getLong("deptId"));
			allocation.setUserId(jsonObj.getLong("id"));
			allocation.setStatus("PENDING");
			allocation.setFromTimeStamp(new Timestamp(System.currentTimeMillis()));
			allocation.setToTimeStamp(new Timestamp(System.currentTimeMillis()));
			allocation.setServiceId(jsonObj.getLong("serviceId"));
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serviceRepo.save(allocation);
	}


	


	@Override
	public List<Services> findByPending(long userId) {
		// TODO Auto-generated method stub
		Set<Long> serviceIds=allocationRepo.findByStatusAndUserId("PENDING",userId);
		List<Services> pendingServices=serviceRepo.findByServiceIdIn(serviceIds);
		return pendingServices;
	}


	@Override
	public List<Services> findActive(long userId) {
		// TODO Auto-generated method stub
		Set<Long> serviceIds=allocationRepo.findByStatusAndUserId("ACTIVE",userId);
		List<Services> activeServices=serviceRepo.findByServiceIdIn(serviceIds);
		return activeServices;
	}


	@Override
	public List<Users> getPendingUsers(Users users) {
		// TODO Auto-generated method stub
		
		return loginDaoImpl.getPendingUsers(users);
	}


	@Override
	public String approveRequests(String content) {
		// TODO Auto-generated method stub
		return serviceDaoImpl.approveRequests(content);
	}





	

}
