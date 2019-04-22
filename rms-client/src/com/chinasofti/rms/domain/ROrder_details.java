package com.chinasofti.rms.domain;

import java.util.List;

public class ROrder_details {
	private int fmid;
	private int dunm;
	private int oid;
	private List<ROrder> list;
	public ROrder_details(int fmid, int dunm) {
		super();
		this.fmid = fmid;
		this.dunm = dunm;
	}
	public ROrder_details() {
		super();
	}
	public int getFmid() {
		return fmid;
	}
	public void setFmid(int fmid) {
		this.fmid = fmid;
	}
	public int getDunm() {
		return dunm;
	}
	public void setDunm(int dunm) {
		this.dunm = dunm;
	}
	public int getOid() {
		return oid;
	}
	
	public List<ROrder> getList() {
		return list;
	}
	public void setList(List<ROrder> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getFmid()+"\t"+this.getDunm();
	}
}
