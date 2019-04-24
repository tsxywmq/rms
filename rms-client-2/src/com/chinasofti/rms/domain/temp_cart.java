package com.chinasofti.rms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//暂时将用户选择菜存放其中，确认结算时，将其加入订单 
public class temp_cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123;
	//属性
	private int fmid;//菜谱编号
	private String fmname;//菜谱名称
	private int dnum;//菜谱数量
	private double price;//菜谱单价 
	private double count;//菜谱总价  数量dnum*单价price
	private double opay;//菜谱实际收款金额
	private int empid;//员工编号
	private int vid;//vip编号
	
	//构造方法
	public temp_cart() {
		super();
	}
	
	//有参构造方法 rorder表中插入数据
	public temp_cart(int fmid,int dnum) {
		super();
		this.fmid=fmid;
		this.dnum=dnum;
	}
	//有参构造方法 rorder——details表中插入数据
	public temp_cart(double opay, int empid, int vid) {
		super();
		this.opay = opay;
		this.empid = empid;
		this.vid = vid;
	}
	//不是会员
	public temp_cart(int fmid, String fmname, int dnum, double price, double count, int empid) {
		super();
		this.fmid = fmid;
		this.fmname = fmname;
		this.dnum = dnum;
		this.price = price;
		this.count = count;
		this.empid = empid;
	}
	//只是存放食谱信息的构造方法
	public temp_cart(int fmid, String fmname, int dnum, double price, double count) {
		super();
		this.fmid = fmid;
		this.fmname = fmname;
		this.dnum = dnum;
		this.price = price;
		this.count = count;
	}
	//有参构造方法 加入rorder表中
	public temp_cart(int fmid, String fmname, int dnum, double price, double count, int empid, int vid) {
		super();
		this.fmid = fmid;
		this.fmname = fmname;
		this.dnum = dnum;
		this.price = price;
		this.count = count;
		this.empid = empid;
		this.vid = vid;
	}
	public int getFmid() {
		return fmid;
	}
	
	public void setFmid(int fmid) {
		this.fmid = fmid;
	}
	public String getFmname() {
		return fmname;
	}
	public void setFmname(String fmname) {
		this.fmname = fmname;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getVid() {
		return vid;
	}
	public void setVip(int vid) {
		this.vid = vid;
	}
	public double getOpay() {
		return opay;
	}
	public void setOpay(double opay) {
		this.opay = opay;
	}
	
}
