package com.dbproject5.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbproject5.cloud.dao.FacultyRepository;
import com.dbproject5.cloud.dao.LoginDao;
import com.dbproject5.cloud.dao.StudentRepository;
import com.dbproject5.cloud.entity.Department;
import com.dbproject5.cloud.entity.Faculty;
import com.dbproject5.cloud.entity.LoginDetails;
import com.dbproject5.cloud.entity.Student;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

@Autowired	
LoginDao loginDao;

@Autowired
StudentRepository studentRepository;

@Autowired
FacultyRepository facultyRepository;





@Override
public Users findBymyIdAndPassword(String myId, String password) {
	// TODO Auto-generated method stub
	return loginDao.findBymyIdAndPassword(myId,password);
	//return null;
}

@Override
public Faculty findFacultyById(long xx81_id){
	return facultyRepository.findFacultyById(xx81_id);
}

@Override
public List<Users> findBydepartment(Department department) {
	// TODO Auto-generated method stub
	//return loginDao.findByDepartment();
	return null;
}



@Override
public Student findBystudId(long xx81_ID) {
	// TODO Auto-generated method stub
	
	return studentRepository.findByStudId(xx81_ID);
}
	
	
}
