package com.chinasofti.rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.rms.dao.EmployeeDao;
import com.chinasofti.rms.domain.Employee;
import com.chinasofti.rms.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{
	private DBUtil db;
	//实现员工登录的功能
	@Override
	public Employee empLogin(int id, String pwd) {
		this.db=new DBUtil();
		String sql="select * from employee where eid="+id+"and password="+pwd;
		try {	
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				return new Employee(rs.getInt("eid"), rs.getString("ename"), rs.getString("password"), rs.getInt("power"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
