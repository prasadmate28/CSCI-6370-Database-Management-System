package com.dbproject5.cloud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbproject5.cloud.entity.LoginDetails;
import com.dbproject5.cloud.entity.Student;
import com.dbproject5.cloud.entity.Users;
@Repository // @Transactional   extends CrudRepository<Users, Long
public interface LoginDao extends CrudRepository<Users, Long>,JpaRepository<Users, Long> {

	//Users findBymyId(String userId);
   /* @Query("select * from users where xx81_id=?1 and password=?2")
	Users findByxx81_IdAndPassword(long xx81_ID, String password); */
    @Query("select u from Users u where u.myId=?1 AND u.password = crypt(?2,u.password)")
	Users findBymyIdAndPassword(String myId, String password);
    @Query("select u from Users u where xx81_ID in :id")
	List<Users> findByuserIdIn(@Param("id")List<Integer> studId);
	

	//List<Users> findByDepartment();

	
	

	

}
