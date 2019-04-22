package com.chinasofti.rms.biz;

import com.chinasofti.rms.domain.Employee;

public interface EmployeeBiz {
	//根据id密码查找老师
	Employee findByIdAndPassword(int id,String password);
}
