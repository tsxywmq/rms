package com.chinasofti.rms.biz.impl;

import com.chinasofti.rms.biz.EmployeeBiz;
import com.chinasofti.rms.dao.EmployeeDao;
import com.chinasofti.rms.dao.impl.EmployeeDaoImpl;
import com.chinasofti.rms.domain.Employee;

public class EmployeeBizImpl implements EmployeeBiz {
	private EmployeeDao empdao;
	
	public EmployeeBizImpl() {
		super();
		this.empdao = new EmployeeDaoImpl();
	}

	@Override
	public Employee findByIdAndPassword(int id,String password) {
		return this.empdao.empLogin(id, password);
	}

}
