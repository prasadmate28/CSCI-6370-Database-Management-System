package com.dbproject5.cloud.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity @Table(name="SERVICE_ALLOCATION",schema="DBMS_FINAL_PROJV1")
public class ServiceAllocation {
/*
 * CREATE TABLE SERVICE_ALLOCATION (
	REQUEST_ID INT PRIMARY KEY,
	STATUS VARCHAR(25) NOT NULL,
	FROM_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	TO_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	SERVICE_ID INT NOT NULL,
	USER_ID INT NOT NULL,
	DEPT_ID INT NOT NULL,
	CONSTRAINT SERV_FK1 FOREIGN KEY (SERVICE_ID) REFERENCES SERVICES(SERVICE_ID),
	CONSTRAINT SERV_FK2 FOREIGN KEY (USER_ID) REFERENCES USERS(XX81_ID),
	CONSTRAINT SERV_FK3 FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID) 
	);
 */
	
	@Id @Column(name="REQUEST_ID")
	@GeneratedValue(generator = "idSequence")
	@SequenceGenerator(name = "idSequence", sequenceName = "request_id_sequence", allocationSize = 1)
	private long requestId; 
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="FROM_TIME")
	private Timestamp fromTimeStamp;
	
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getFromTimeStamp() {
		return fromTimeStamp;
	}

	public void setFromTimeStamp(Timestamp fromTimeStamp) {
		this.fromTimeStamp = fromTimeStamp;
	}

	public Timestamp getToTimeStamp() {
		return toTimeStamp;
	}

	public void setToTimeStamp(Timestamp toTimeStamp) {
		this.toTimeStamp = toTimeStamp;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	@Column(name="TO_TIME")
	private Timestamp toTimeStamp;
	
	@Column(name="SERVICE_ID")
	private long serviceId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="DEPT_ID")
	private long deptId;
	
	/*@ManyToOne @JoinColumn(name="SERVICE_ID")
	private Services servId; */
	
	 @ManyToOne @JoinColumn(name="xx81_ID")
	private Users userDet;
	
}
