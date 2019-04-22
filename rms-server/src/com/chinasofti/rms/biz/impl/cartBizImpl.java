package com.chinasofti.rms.biz.impl;

import java.util.List;

import com.chinasofti.rms.biz.cartBiz;
import com.chinasofti.rms.dao.cartDao;
import com.chinasofti.rms.dao.impl.cartDaoImpl;
import com.chinasofti.rms.domain.temp_cart;

public class cartBizImpl implements cartBiz {
	private cartDao dao;
	
	public cartBizImpl() {
		super();
		this.dao = new cartDaoImpl();
	}

	@Override
	public List<temp_cart> insertFoodToCart(int id,int num) {
		return this.dao.addToCart(id,num);
	}

	@Override
	public List<temp_cart> dropFoodFromCart(int id) {
		return this.dao.deleteFromCart(id);
	}

	@Override
	public List<temp_cart> showCartFood() {
		return this.dao.showAll();
	}

}
