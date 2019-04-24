package com.chinasofti.rms.domain;

import java.io.Serializable;

public class Employee implements Serializable{
	private int Eid;
	private String Ename;
	private String password;
	private  int power;
	
	public Employee(int eid, String ename, String password, int power) {
		super();
		Eid = eid;
		Ename = ename;
		this.password = password;
		this.power = power;
	}

	public Employee() {
		super();
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return this.Eid+"\t"+this.Ename+"\t"+this.password+"\t"+this.power;
	}
}
