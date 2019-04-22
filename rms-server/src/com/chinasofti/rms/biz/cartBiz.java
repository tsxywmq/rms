package com.chinasofti.rms.biz;

import java.util.List;

import com.chinasofti.rms.domain.temp_cart;

public interface cartBiz {

	List<temp_cart> insertFoodToCart(int id,int num);

	List<temp_cart> dropFoodFromCart(int id);

	List<temp_cart> showCartFood();

}
