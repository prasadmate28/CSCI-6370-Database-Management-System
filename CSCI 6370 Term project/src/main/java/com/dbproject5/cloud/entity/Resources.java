package com.dbproject5.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="RESOURCES",schema="DBMS_FINAL_PROJV1") 
@Entity
public class Resources {
/*
 * CREATE TABLE RESOURCES (
	ASSET_ID INT PRIMARY KEY,
	RESOURCE_NAME VARCHAR(50) NOT NULL,
	SPECIFICATIONS VARCHAR(150) NOT NULL,
	NO_OF_COPIES INT DEFAULT 1,
	MANAGER_ID INT NOT NULL,
	SERVICE_ID INT NOT NULL,
	FOREIGN KEY (MANAGER_ID) REFERENCES RESOURCE_MANAGER(RSR_MANAGER_ID),
	FOREIGN KEY (SERVICE_ID) REFERENCES SSERVICES(SERVICE_ID)
	);
 */
	@Id @Column(name="ASSET_ID")
	@GeneratedValue(generator = "assetSequence")
	@SequenceGenerator(name = "assetSequence", sequenceName = "asset_id_sequence", allocationSize = 1)
	private long assetId;
	
	@Column(name="RESOURCE_NAME")
	private String resourceName;
	
	@Column(name="SPECIFICATIONS")
	private String specifications;
	
	@Column(name="NO_OF_COPIES")
	private int copies;
	
	/*@ManyToOne() @JoinColumn(name="RSR_MANAGER_ID")
	private ResourceManager mgrId; */
	
	@Column(name="manager_id")
	private long mgrId;
	
	public int getTotalResources() {
		return totalResources;
	}

	public void setTotalResources(int totalResources) {
		this.totalResources = totalResources;
	}

	public int getTotalActive() {
		return totalActive;
	}

	public void setTotalActive(int totalActive) {
		this.totalActive = totalActive;
	}

	public int getTotalRemaining() {
		return totalRemaining;
	}

	public void setTotalRemaining(int totalRemaining) {
		this.totalRemaining = totalRemaining;
	}

	public int getWaitListCount() {
		return waitListCount;
	}

	public void setWaitListCount(int waitListCount) {
		this.waitListCount = waitListCount;
	}

	@Column(name="service_id")
	private Long servieId;
	
	@Transient
	private int totalResources;
	
	@Transient
	private int totalActive;
	
	@Transient
	private int totalRemaining;
	
	@Transient
	private int waitListCount;
	
	
	
	
	public long getMgrId() {
		return mgrId;
	}

	public void setMgrId(long mgrId) {
		this.mgrId = mgrId;
	}

	public Long getServieId() {
		return servieId;
	}

	public void setServieId(Long servieId) {
		this.servieId = servieId;
	}

	@Override
	public String toString() {
		return "Resources [assetId=" + assetId + ", resourceName=" + resourceName + ", specifications=" + specifications
				+ ", copies=" + copies +"]";
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	/*public ResourceManager getMgrId() {
		return mgrId;
	}

	public void setMgrId(ResourceManager mgrId) {
		this.mgrId = mgrId;
	}

	public Services getServiceId() {
		return serviceId;
	}

	public void setServiceId(Services serviceId) {
		this.serviceId = serviceId;
	} */

	/*@ManyToOne() @JoinColumn(name="SERVICE_ID")
	private Services serviceId; */
}
