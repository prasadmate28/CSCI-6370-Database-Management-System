package com.dbproject5.cloud.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Services;

@Repository 
public interface ServiceAllocationRepository extends CrudRepository<ServiceAllocation,Long>,JpaRepository<ServiceAllocation, Long> {

    @Query("select serviceId from ServiceAllocation  where status=?1 and userId=?2")
	Set<Long> findByStatusAndUserId(String status, long userId);

    @Query("select userId from ServiceAllocation where deptId=?1")
	Set<Long> findBydeptId(long departmentId);
    
    List<ServiceAllocation> findByDeptId(long departmentId);
}
