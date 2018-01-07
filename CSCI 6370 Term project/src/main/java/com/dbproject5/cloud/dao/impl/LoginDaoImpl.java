package com.dbproject5.cloud.dao.impl;




import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.dbproject5.cloud.dao.LoginDao;
import com.dbproject5.cloud.entity.LoginDetails;
import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Services;
import com.dbproject5.cloud.entity.Users;


@Repository
@Transactional
public class LoginDaoImpl  {
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	    private Session getSession() {
	        return sessionFactory.getCurrentSession();
	    }

	
		
		public List<Users> findStudentsInDepartment(Users user) {
			
			// TODO Auto-generated method stub
	List<Users> users=new ArrayList<>();
	SQLQuery det=getSession().createSQLQuery("select s.service_id ,s.service_name, u.xx81_id, u.name from DBMS_FINAL_PROJV1.Services s, \n" + 
			"DBMS_FINAL_PROJV1.SERVICE_ALLOCATION d,DBMS_FINAL_PROJV1.Users u where s.service_id=d.service_id and d.user_id=u.xx81_id\n" + 
			"and u.dept_id=:deptId and d.status='ACTIVE'");
	    det.setParameter("deptId", user.getDepartment().getDepartmentId());
	    List<Object[]> objList=det.list();
         for(Object[] obj :objList)
         {  Users userDet =new Users();
            Services services=new Services();
            int serviceId=Integer.parseInt(String.valueOf(obj[0]));
            services.setServiceId(serviceId);
            services.setServiceName((String) obj[1]);
        	    int studId=Integer.parseInt(String.valueOf(obj[2]));
        	    userDet.setXx81_ID(studId);
        	    userDet.setName((String)obj[3]);
        	    userDet.setServices(services);
        	    users.add(userDet);
         }
			return users;
		}



	



		public List<Users> getPendingUsers(Users users) {
			// TODO Auto-generated method stub
			  
			String sql=	"  select r.request_id, s.service_name ,u.name ,s.service_id from DBMS_FINAL_PROJV1.SERVICE_ALLOCATION r ,\n" + 
					"  DBMS_FINAL_PROJV1.SERVICES s , DBMS_FINAL_PROJV1.USERS u where u.xx81_id=r.user_id\n" + 
					"  and r.service_id=s.service_id and r.status='PENDING' and r.dept_id=:deptId";
			SQLQuery det=getSession().createSQLQuery(sql);
			det.setParameter("deptId", users.getDepartment().getDepartmentId());
			List<Object[]> resultSet=det.list();
			List<Users>userList=new ArrayList<>();
			ServiceAllocation allocation=null;
			Services services=null;
			Users user=null;
			for(Object[] result:resultSet)
			{ 
				allocation=new ServiceAllocation();
				services=new Services();
				user =new Users();
				int reqId=Integer.parseInt(String.valueOf(result[0]));
				allocation.setRequestId(reqId);
				services.setServiceName((String)result[1]);
				int serviceId=Integer.parseInt(String.valueOf(result[3]));
				services.setServiceId(serviceId);
				user.setName((String)result[2]);
				user.setAllocation(allocation);
				user.setServices(services);
				
				userList.add(user);
			}
			return userList;
		}

	/*	@Override
		public void loginAttempt(Users details) {
			// TODO Auto-generated method stub
			//Users det=getSession().get(Users.class, details.getXx81_ID());
			SQLQuery det=getSession().createSQLQuery("select * from Users where xx81_id=:id and password=:pass");
		    Users  udet=null; 
		
			det.setParameter("id", 810509557);
			det.setParameter("pass", "PASSWORD2");
			
			List user= det.list();
			if(user!=null)
			{  
				udet=new Users();
				
			}
		} */
	    
	    
	    
	    
	    
	    
} 
