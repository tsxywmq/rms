package com.chinasofti.rms.domain;

import java.io.Serializable;
import java.util.Date;

public class Vip implements Serializable{
	private int Vid;
	private String Vname;
	private String Vsex;
	private long Vphone;
	private Date Vbirth;
	private int Vstatus;
	
	public Vip() {
		super();
	}

	public Vip(String vname, String vsex, long vphone, Date vbirth, int vstatus) {
		super();
		Vname = vname;
		Vsex = vsex;
		Vphone = vphone;
		Vbirth = vbirth;
		Vstatus = vstatus;
	}
	
	public int getVid() {
		return Vid;
	}

	public String getVname() {
		return Vname;
	}

	public void setVname(String vname) {
		Vname = vname;
	}

	public String getVsex() {
		return Vsex;
	}

	public void setVsex(String vsex) {
		Vsex = vsex;
	}

	public long getVphone() {
		return Vphone;
	}

	public void setVphone(long vphone) {
		Vphone = vphone;
	}

	public Date getVbirth() {
		return Vbirth;
	}

	public void setVbirth(Date vbirth) {
		Vbirth = vbirth;
	}

	public int getVstatus() {
		return Vstatus;
	}

	public void setVstatus(int vstatus) {
		Vstatus = vstatus;
	}

	@Override
	public String toString() {
		return this.Vid+"\t"+this.Vname+"\t"+this.Vsex+"\t"+this.Vphone+"\t"+this.Vbirth+"\t"+this.Vstatus;
	}
}
