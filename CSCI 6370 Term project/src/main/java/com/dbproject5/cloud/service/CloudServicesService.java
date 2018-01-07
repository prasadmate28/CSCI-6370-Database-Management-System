package com.dbproject5.cloud.service;

import java.util.List;

import com.dbproject5.cloud.entity.Department;
import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Services;
import com.dbproject5.cloud.entity.Users;
public interface CloudServicesService {

	public List<Services> findAll();

	public ServiceAllocation requestService(String content);

	public List<Services> findByPending(long l);

	public List<Services> findActive(long xx81_ID);

	public List<Users> getPendingUsers(Users users);

	public String approveRequests(String content);


}
