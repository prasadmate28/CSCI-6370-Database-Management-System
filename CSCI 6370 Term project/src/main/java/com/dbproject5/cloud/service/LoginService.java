package com.dbproject5.cloud.service;

import java.util.List;

import com.dbproject5.cloud.entity.Department;
import com.dbproject5.cloud.entity.Faculty;
import com.dbproject5.cloud.entity.Student;
import com.dbproject5.cloud.entity.Users;

public interface LoginService {


	Users findBymyIdAndPassword(String myId, String password);

	List<Users> findBydepartment(Department department);

	Student findBystudId(long xx81_ID);

	Faculty findFacultyById(long xx81_id);

}
