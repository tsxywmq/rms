package com.chinasofti.rms.biz;

import java.util.List;

import com.chinasofti.rms.domain.Food_Menu;

public interface Food_MenuBiz {

	List<Food_Menu> findAllFood();

	List<Food_Menu> findFoodByType(int fid);

}
