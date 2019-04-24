package com.chinasofti.rms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ROrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123;
	private int Oid;
	private Date Otime;
	private double Opay;//实收金额
	private int Eid;
	private int Vid;
	public ROrder( double opay, int eid, int vid) {
		super();
		Opay = opay;
		Eid = eid;
		Vid = vid;
	}
	public ROrder() {
		super();
	}
	public int getOid() {
		return Oid;
	}
	
	public Date getOtime() {
		return Otime;
	}
	public void setOtime(Date otime) {
		Otime = otime;
	}
	public double getOpay() {
		return Opay;
	}
	public void setOpay(double opay) {
		Opay = opay;
	}
	public int getEid() {
		return Eid;
	}
	
	public void setEid(int eid) {
		Eid = eid;
	}
	public int getVid() {
		return Vid;
	}
	public void setVid(int vid) {
		Vid = vid;
	}
	
	@Override
	public String toString() {
		return this.Oid+"\t"+this.Otime+"\t"+this.Opay+"\t"+this.Eid+"\t"+this.Vid;
	}
}
