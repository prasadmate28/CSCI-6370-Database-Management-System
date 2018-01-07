package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT",schema="DBMS_FINAL_PROJV1")
public class Student {

	
	@Id @Column(name="STUDENT_ID")
	private long studId;
	
	@Column(name="COURSE_TYPE")
	private String courseType;
	
	@Column(name="SEMESTER_OF_JOINING")
	private String semJoin;
	
	@Column(name="MAJOR_PROF_ID")
	private long facultyId;
	
	/*@OneToOne @JoinColumn(name="XX81_ID")
	private Users userStud;*/
	
	/*@ManyToOne @JoinColumn(name="FACULTY_ID")
	private Faculty advisor; */

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", courseType=" + courseType + ", semJoin=" + semJoin +"]";
				
	}

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getSemJoin() {
		return semJoin;
	}

	public void setSemJoin(String semJoin) {
		this.semJoin = semJoin;
	}

	
	/*public Users getUser() {
		return userStud;
	}

	public void setUser(Users userStud) {
		this.userStud = userStud;
	} */
}
