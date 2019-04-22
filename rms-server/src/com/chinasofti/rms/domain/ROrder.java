package com.chinasofti.rms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ROrder implements Serializable{
	private int Oid;
	private Date Otime;
	private double Opay;
	private int Eid;
	private int Vid;
	private List<Employee> list;
	private List<Vip> listV;
	public ROrder(int oid, Date Otime, double opay, int eid, int vid) {
		super();
		Oid = oid;
		this.Otime = Otime;
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
	public void setOid(int oid) {
		Oid = oid;
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
	public void setEid(int Eid) {
		Eid = Eid;
	}
	public int getVid() {
		return Vid;
	}
	public void setVid(int vid) {
		Vid = vid;
	}
	
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public List<Vip> getListV() {
		return listV;
	}
	public void setListV(List<Vip> listV) {
		this.listV = listV;
	}
	@Override
	public String toString() {
		return this.Oid+"\t"+this.Otime+"\t"+this.Opay+"\t"+this.Eid+"\t"+this.Vid;
	}
}
