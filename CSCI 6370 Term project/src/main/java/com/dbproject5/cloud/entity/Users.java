package com.dbproject5.cloud.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USERS",schema="DBMS_FINAL_PROJV1")
public class Users {

	@Id @Column(name="xx81_ID")
	private long xx81_ID;
	
	@Column(name="MY_ID")
	private String myId;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department; 
	/*@Column(name="DEPT_ID")
	private long deptId;
	
	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	} */

	@Column(name="GENDER")
	private char gender;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dob;
	
	@Column(name="ROLE")
	private char role;

	@Override
	public String toString() {
		return "Users [xx81_ID=" + xx81_ID + ", myId=" + myId + ", password=" + password + ", name=" + name
				+ ", address=" + address  + ", gender=" + gender + ", email=" + email
				+ ", dob=" + dob + ", role=" + role + "]";
	}

	public long getXx81_ID() {
		return xx81_ID;
	}

	public void setXx81_ID(long xx81_ID) {
		this.xx81_ID = xx81_ID;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	} 

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}
	
	@Transient
	public Services services;
	
	@Transient
	public Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public ServiceAllocation getAllocation() {
		return allocation;
	}

	public void setAllocation(ServiceAllocation allocation) {
		this.allocation = allocation;
	}

	@Transient
	public Faculty faculty;
	
	@Transient
	public ServiceAllocation allocation;

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}
}
