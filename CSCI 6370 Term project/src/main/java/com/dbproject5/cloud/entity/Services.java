package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Services",schema="DBMS_FINAL_PROJV1")
public class Services {

	
	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDesc=" + serviceDesc
				+ "]";
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	@Id @Column(name="SERVICE_ID")
	private long serviceId;
	
	@Column(name="SERVICE_NAME")
	private String serviceName;
	
	@Column(name="SERVICE_DESC")
	private String serviceDesc;
}
