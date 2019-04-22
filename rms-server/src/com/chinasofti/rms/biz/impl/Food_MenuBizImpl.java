package com.chinasofti.rms.biz.impl;

import java.util.List;

import com.chinasofti.rms.biz.Food_MenuBiz;
import com.chinasofti.rms.dao.Food_MenuDao;
import com.chinasofti.rms.dao.impl.Food_MenuDaoImpl;
import com.chinasofti.rms.domain.Food_Menu;

public class Food_MenuBizImpl implements Food_MenuBiz {
	private Food_MenuDao dao;
	
	public Food_MenuBizImpl() {
		super();
		this.dao = new Food_MenuDaoImpl();
	}

	@Override
	public List<Food_Menu> findAllFood() {	
		return this.dao.showFood();
	}

	@Override
	public List<Food_Menu> findFoodByType(int fid) {
		return this.dao.showFoodByType(fid);
	}

}
