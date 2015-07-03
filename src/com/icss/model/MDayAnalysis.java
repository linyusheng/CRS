package com.icss.model;

public class MDayAnalysis {
	
	private String fmd; 		//店名
	private String date;		//日期
	private double saleAmount;		//销售额
	private double discount;		//折扣
	private double rewards;		//赠送
	private double saleFinal;		//销售实收
	private long passengerFolw;	//客流量
	private double avgAccount;		//人均消费
	private String billAcount;		//结账单数
	public String getFmd() {
		return fmd;
	}
	public void setFmd(String fmd) {
		this.fmd = fmd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getRewards() {
		return rewards;
	}
	public void setRewards(double rewards) {
		this.rewards = rewards;
	}
	public double getSaleFinal() {
		return saleFinal;
	}
	public void setSaleFinal(double saleFinal) {
		this.saleFinal = saleFinal;
	}
	public long getPassengerFolw() {
		return passengerFolw;
	}
	public void setPassengerFolw(long passengerFolw) {
		this.passengerFolw = passengerFolw;
	}
	public double getAvgAccount() {
		return avgAccount;
	}
	public void setAvgAccount(double avgAccount) {
		this.avgAccount = avgAccount;
	}
	public String getBillAcount() {
		return billAcount;
	}
	public void setBillAcount(String billAcount) {
		this.billAcount = billAcount;
	}
	
	
	
}
