package com.icss.entity;

import java.sql.Timestamp;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */

public class Shop implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private String shopName;
	private String shopAddress;
	private Timestamp openTime;
	private Timestamp closedTime;
	private String shopType;
	private String description;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** full constructor */
	public Shop(String shopName, String shopAddress, Timestamp openTime,
			Timestamp closedTime, String shopType, String description,
			Timestamp createTime) {
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.openTime = openTime;
		this.closedTime = closedTime;
		this.shopType = shopType;
		this.description = description;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Timestamp getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}

	public Timestamp getClosedTime() {
		return this.closedTime;
	}

	public void setClosedTime(Timestamp closedTime) {
		this.closedTime = closedTime;
	}

	public String getShopType() {
		return this.shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}