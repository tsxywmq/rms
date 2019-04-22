package com.chinasofti.rms.dao;

import java.util.List;

import com.chinasofti.rms.domain.Food_Menu;

public interface Food_MenuDao {
	//展示所有菜谱信息
	public List<Food_Menu> showFood();
	//增加菜谱信息
	public Food_Menu addFood();
	//删除菜谱信息
	public void dropFood();
	//根据菜品类别展示菜谱信息
	public List<Food_Menu> showFoodByType(int fid);	
}
