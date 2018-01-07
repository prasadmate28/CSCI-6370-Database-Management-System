package com.dbproject5.cloud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbproject5.cloud.entity.Resources;
import com.dbproject5.cloud.entity.ServiceAllocation;

public interface ResourceRepository extends CrudRepository<Resources,Long> {


}
