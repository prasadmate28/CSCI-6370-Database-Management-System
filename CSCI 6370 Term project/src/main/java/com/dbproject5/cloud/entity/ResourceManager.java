package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESOURCE_MANAGER",schema="DBMS_FINAL_PROJV1")
public class ResourceManager {

	@Id @Column(name="RSR_MANAGER_ID")
	private long mgrId;
	
	@Override
	public String toString() {
		return "ResourceManager [mgrId=" + mgrId + ", userRM=" + userRM + "]";
	}

	public long getMgrId() {
		return mgrId;
	}

	public void setMgrId(long mgrId) {
		this.mgrId = mgrId;
	}

	public Users getUserRM() {
		return userRM;
	}

	public void setUserRM(Users userRM) {
		this.userRM = userRM;
	}

	@OneToOne @JoinColumn(name="XX81_ID")
	private Users userRM;
}
