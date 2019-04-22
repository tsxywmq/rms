package com.chinasofti.rms.dao;

import java.util.List;

import com.chinasofti.rms.domain.temp_cart;

public interface cartDao {

	List<temp_cart> addToCart(int id,int num);

	List<temp_cart> deleteFromCart(int id);

	List<temp_cart> showAll();

}
