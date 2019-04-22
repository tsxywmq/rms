package com.chinasofti.rms.Service;

import java.util.List;

import com.chinasofti.rms.domain.Employee;
import com.chinasofti.rms.domain.Food_Menu;
import com.chinasofti.rms.domain.temp_cart;

public interface RMSService {
	//登陆的功能，员工和经理   需要输入账号和密码
	public Employee login(int id,String password);
	/*-------------员工的功能---------------*/
	/*---为客户点菜 */
	//查询所有的菜单信息
	public List<Food_Menu> showAllFood();
	//根据类别查询菜谱的方法
	public List<Food_Menu> showFoodByType(int fid);
	//将用户选择的菜单 加入购物车
	public List<temp_cart> addFoodToCart(int id,int num);
	//删除购物车中的信息
	public List<temp_cart> deleteFoodFromCart(int id);
	//展示购物车中的信息
	public List<temp_cart> showFoodInCart();
	/*---为会员服务 */
	//添加会员
	public String addVip();
	//为会员充值 ，更改会员状态
	public String changVipStatus();
	//更改过期会员
	public String removeVipStatus();
	//为会员补卡
	public String changVipVid();
	/*-------------经理的功能---------------*/
	
}
