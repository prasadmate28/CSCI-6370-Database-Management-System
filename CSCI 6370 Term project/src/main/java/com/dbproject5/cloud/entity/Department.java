package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT" ,schema="DBMS_FINAL_PROJV1")
public class Department {

	@Id @Column(name="DEPT_ID")
	private long departmentId;
	@Column(name="DEPT_NAME")
	private String deptName;
	@Column(name="DEPT_LOCATION")
	private String deptLocation;
	@Column(name="DEPT_HEAD")
	private String deptHead;
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", deptName=" + deptName + ", deptLocation=" + deptLocation
				+ ", deptHead=" + deptHead + "]";
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}
	public String getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
}
