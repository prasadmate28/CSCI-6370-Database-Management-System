package com.dbproject5.cloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dbproject5.cloud.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("select studId from Student where facultyId=?1")
	List<Integer> findByfacultyId(long profId);
  
	@Query("select u from Student u where u.studId=?1")
	Student findByStudId(long xx81_ID);
}
