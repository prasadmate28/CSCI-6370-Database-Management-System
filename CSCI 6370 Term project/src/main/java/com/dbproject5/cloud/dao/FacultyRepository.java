package com.dbproject5.cloud.dao;

import java.util.List;

import com.dbproject5.cloud.entity.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dbproject5.cloud.entity.Student;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {



    @Query("select u from Faculty u where u.faculty_id=?1")
    Faculty findFacultyById(long xx81_id);
}