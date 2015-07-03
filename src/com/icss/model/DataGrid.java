package com.icss.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * EasyUI DataGrid模型
 * 
 * @author 林玉生
 * 
 */
public class DataGrid implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long total = 0L;
	private List rows = new ArrayList();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	

}
