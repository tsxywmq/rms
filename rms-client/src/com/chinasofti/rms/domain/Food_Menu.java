package com.chinasofti.rms.domain;

import java.io.Serializable;

public class Food_Menu implements Serializable{
	private int fmid;
	private String fmname;
	private double price;
	private String type;
		
	public Food_Menu() {
		super();
	}

	public Food_Menu(int fmid, String fmname, double price, String type) {
		super();
		this.fmid = fmid;
		this.fmname = fmname;
		this.price = price;
		this.type = type;
	}
	public Food_Menu(int fmid, String fmname, double price) {
		super();
		this.fmid = fmid;
		this.fmname = fmname;
		this.price = price;	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.fmid+"\t"+this.fmname+"\t\t"+this.price+"\t\t"+this.type;
		//return this.fmid+"\t"+this.fmname+this.price+this.type;
	}
	
}
