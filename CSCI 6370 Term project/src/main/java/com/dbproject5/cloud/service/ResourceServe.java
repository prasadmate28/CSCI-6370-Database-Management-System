package com.dbproject5.cloud.service;

import java.util.List;

import com.dbproject5.cloud.entity.Resources;
import com.dbproject5.cloud.entity.Users;

public interface ResourceServe {

	List<Resources> getResourceInfo(Users user);

	int addResource(String data);

}
