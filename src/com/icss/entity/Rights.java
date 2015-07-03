package com.icss.entity;

import java.sql.Timestamp;

/**
 * Rights entity. @author MyEclipse Persistence Tools
 */

public class Rights implements java.io.Serializable {

	// Fields

	private Integer rightsId;
	private User user;
	private String rightsNum;
	private String rightsName;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Rights() {
	}

	/** full constructor */
	public Rights(User user, String rightsNum, String rightsName,
			Timestamp createTime) {
		this.user = user;
		this.rightsNum = rightsNum;
		this.rightsName = rightsName;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getRightsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRightsNum() {
		return this.rightsNum;
	}

	public void setRightsNum(String rightsNum) {
		this.rightsNum = rightsNum;
	}

	public String getRightsName() {
		return this.rightsName;
	}

	public void setRightsName(String rightsName) {
		this.rightsName = rightsName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}