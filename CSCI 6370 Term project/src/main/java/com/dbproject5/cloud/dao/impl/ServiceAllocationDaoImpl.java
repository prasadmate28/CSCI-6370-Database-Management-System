package com.dbproject5.cloud.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbproject5.cloud.dao.ServiceAllocationDao;
import com.dbproject5.cloud.entity.Users;

@Repository @Transactional
public class ServiceAllocationDaoImpl implements ServiceAllocationDao {

	
	@Override
	public List<Users> geStudentsHoldingService(Users user) {
		// TODO Auto-generated method stub
		String sql="select service_id, service_name, user_id, user_name from"
				+ " services equi join service_allocation equi join users"
				+ " where users.id in (select student_id from student where majorProf=‘given majorProf’)";
		return null;
	}
	
	@Autowired
    private SessionFactory sessionFactory;
 
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	public String approveRequests(String content) {
		// TODO Auto-generated method stub
	  String resultSet="query processed";
		try {
			JSONArray jsonArray=new JSONArray(content);
			//System.out.println(jsonArray);
			for(int i=0;i<jsonArray.length();i++)
			{
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				int requestId=jsonObject.getInt("requestId");
				int serviceId=jsonObject.getInt("serviceId");
				
				String sql="update DBMS_FINAL_PROJV1.SERVICE_ALLOCATION set status = 'APPROVED' where"
						+ " request_id=:reqId";
				SQLQuery query=getSession().createSQLQuery(sql);
				query.setParameter("reqId", requestId);
				int queryResult=query.executeUpdate();
				System.out.println("query res is "+queryResult);
				//List<String> resources=mapperRepository.findByServiceId(serviceId);
				/*List<String> resources=new ArrayList<>();
				String resourcesql="select resource_name from  DBMS_FINAL_PROJV1.resource_services_map where service_id=:servId";
				SQLQuery resourcesQuery=getSession().createSQLQuery(resourcesql);
				resourcesQuery.setParameter("servId", serviceId);
				List<Object[]> resourceSet=resourcesQuery.list();
				for(Object obj:resourceSet)
				{
					resources.add((String)obj);
				}
				boolean updateFlag=true;
				Integer count=0;
				for(String resource: resources)
				{
		String resourceCheckSql="select count(*) as total from DBMS_FINAL_PROJV1.resources where resource_name=:resname and service_id is null";
		SQLQuery resourceQuery=getSession().createSQLQuery(resourceCheckSql);
		resourceQuery.setParameter("resname", resource);
		Integer result=((BigInteger)resourceQuery.uniqueResult()).intValue();
		    count=Integer.parseInt(String.valueOf(result));
		   if(count==0)
		   {
			   updateFlag=false;
			   break;
		   }
				}
			if(updateFlag)
			{
				String activesql="update DBMS_FINAL_PROJV1.SERVICE_ALLOCATION set status = 'ACTIVE' where "
						+ "request_id=:reqId";
				SQLQuery activequery=getSession().createSQLQuery(activesql);
				activequery.setParameter("reqId", requestId);
				int activequeryResult=activequery.executeUpdate();
			}
			else
			{
				String inactivesql="update DBMS_FINAL_PROJV1.SERVICE_ALLOCATION set status = 'UNAVAILABLE' where "
						+ "request_id=:reqId";
				SQLQuery inactivequery=getSession().createSQLQuery(inactivesql);
				inactivequery.setParameter("reqId", requestId);
				int inactivequeryResult=inactivequery.executeUpdate();
			} */
		}
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	

}
