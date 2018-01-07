package com.dbproject5.cloud.service;

import java.util.List;

import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Users;

public interface CloudAllocationService {

	List<Users> findByDepartment(Users user);

	List<Users> geStudentsHoldingService(Users user);

}
