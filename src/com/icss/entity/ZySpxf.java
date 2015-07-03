package com.icss.entity;

/**
 * ZySpxf entity. @author MyEclipse Persistence Tools
 */

public class ZySpxf implements java.io.Serializable {

	// Fields

	private ZySpxfId id;

	// Constructors

	/** default constructor */
	public ZySpxf() {
	}

	/** full constructor */
	public ZySpxf(ZySpxfId id) {
		this.id = id;
	}

	// Property accessors

	public ZySpxfId getId() {
		return this.id;
	}

	public void setId(ZySpxfId id) {
		this.id = id;
	}

}