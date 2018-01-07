package com.dbproject5.cloud.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Services;
@Repository
public interface CloudServiceRepository extends CrudRepository<Services, Long> {

	ServiceAllocation save(ServiceAllocation allocation);
    
	//@Query("select o from Services o where o.service_id in :ids")
	List<Services> findByServiceIdIn(Set<Long> serviceIds);

	
    
	

}
