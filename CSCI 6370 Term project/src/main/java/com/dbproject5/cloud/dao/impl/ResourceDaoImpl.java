package com.dbproject5.cloud.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbproject5.cloud.entity.Resources;
import com.dbproject5.cloud.entity.Users;

@Repository @Transactional
public class ResourceDaoImpl {


	@Autowired
    private SessionFactory sessionFactory;
 
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	public List<Resources> getResourceInfo(Users user) {
		// TODO Auto-generated method stub
		List<Resources> resources=new ArrayList<>();
		Resources resource=null;
		//select resname, count(*) from resources where servid is null group by resname
		SQLQuery det1=getSession().createSQLQuery("select resource_name, count(*) as total_count ,specifications from DBMS_FINAL_PROJV1.RESOURCES where manager_id=:id group by resource_name,specifications");
		det1.setParameter("id", user.getXx81_ID());
		List<Object[]> result1=det1.list();
         for(Object[] obj:result1)
         {
            	 resource=new Resources();
 			resource.setResourceName((String)obj[0]);
 			resource.setTotalResources(Integer.parseInt(String.valueOf(obj[1])));
 			resource.setTotalActive(Integer.parseInt(String.valueOf(obj[1])));
 			resource.setTotalRemaining(0);
 			resource.setSpecifications((String)obj[2]);
 			resources.add(resource);
         }
        	  
		
		SQLQuery det=getSession().createSQLQuery(" select resource_name, count(*) from DBMS_FINAL_PROJV1.RESOURCES where service_id is null and manager_id =:id group by resource_name;\n" + 
				"\n" + 
				"");
		det.setParameter("id", user.getXx81_ID());
		List<Object[]> result=det.list();
		for( int i=0;i<resources.size();i++)
		{
			Resources res=resources.get(i);
			for(Object[] obj:result)
			{
				if(res.getResourceName().equals("GPU"))
				{
					System.out.println("");
				}
				if(res.getResourceName().equals((String)obj[0])||res.getResourceName()==(String)obj[0])
				{
					res.setTotalActive(res.getTotalActive()-Integer.parseInt(String.valueOf(obj[1])));
					res.setTotalRemaining(res.getTotalResources()-res.getTotalActive());
					resources.set(i,res);
					
						}
			}
		}
		
		
		return resources;
	}
}
