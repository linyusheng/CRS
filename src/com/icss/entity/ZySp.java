package com.icss.entity;

/**
 * ZySp entity. @author MyEclipse Persistence Tools
 */

public class ZySp implements java.io.Serializable {

	// Fields

	private ZySpId id;

	// Constructors

	/** default constructor */
	public ZySp() {
	}

	/** full constructor */
	public ZySp(ZySpId id) {
		this.id = id;
	}

	// Property accessors

	public ZySpId getId() {
		return this.id;
	}

	public void setId(ZySpId id) {
		this.id = id;
	}

}