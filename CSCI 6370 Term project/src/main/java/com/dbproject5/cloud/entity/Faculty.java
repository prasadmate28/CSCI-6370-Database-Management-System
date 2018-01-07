package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FACULTY",schema="DBMS_FINAL_PROJV1")
public class Faculty {

	/* CREATE TABLE FACULTY (
	FACULTY_ID INT PRIMARY KEY,
	SPECIALIZATION VARCHAR(50),
	FOREIGN KEY (FACULTY_ID) REFERENCES USERS(XX81_ID)
	); */
	
	@Id @Column(name="FACULTY_ID")
	private long faculty_id;
	
	@Column(name="SPECIALIZATION")
	private String specialization;
	
	@OneToOne @JoinColumn(name="XX81_ID")
	private Users userFaculty;
}
