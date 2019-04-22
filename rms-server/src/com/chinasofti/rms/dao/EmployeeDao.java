package com.chinasofti.rms.dao;

import com.chinasofti.rms.domain.Employee;

public interface EmployeeDao {
	//登录
	public Employee empLogin(int id, String pwd);
}
