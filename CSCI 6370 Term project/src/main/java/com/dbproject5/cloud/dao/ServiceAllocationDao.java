package com.dbproject5.cloud.dao;

import java.util.List;

import com.dbproject5.cloud.entity.Users;

public interface ServiceAllocationDao {

	List<Users> geStudentsHoldingService(Users user);

	String approveRequests(String content);

}
