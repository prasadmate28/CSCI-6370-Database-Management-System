package com.dbproject5.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.dbproject5.cloud.dao.ResourceRepository;
import com.dbproject5.cloud.dao.impl.ResourceDaoImpl;
import com.dbproject5.cloud.entity.Resources;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.ResourceServe;


@Service
public class ResourceServiceImpl implements ResourceServe{

	@Autowired
	ResourceDaoImpl resourceDao;
	@Autowired
	ResourceRepository resourceRepository;
	@Override
	public List<Resources> getResourceInfo(Users user) {
		// TODO Auto-generated method stub
		return resourceDao.getResourceInfo(user);
	}
	@Override
	public int addResource(String data) {
		// TODO Auto-generated method stub
        List<Resources> resourceList=new ArrayList<>();
        Resources res=null;
        int returnVal=0;
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(data);
		
        Resources resource=null;
		int resourcecount=jsonObj.getInt("resourcesToAdd");
		for(int i=0;i<resourcecount;i++)
		{
			resource=new Resources();
			resource.setCopies(1);
			resource.setResourceName(jsonObj.getString("resourceName"));
			resource.setMgrId(jsonObj.getLong("mgrId"));
			resource.setSpecifications(jsonObj.getString("resourceDecription"));
			resource.setServieId(null);
			resourceList.add(resource);
		}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Resources reso:resourceList)
		{
			res=resourceRepository.save(reso);
			if(res!=null)
			{
				returnVal=1;
			}
			else
			{
				returnVal=0;
			}
		}
		return returnVal;
	}

}
