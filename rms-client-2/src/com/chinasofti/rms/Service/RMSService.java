package com.chinasofti.rms.Service;

import java.util.Date;
import java.util.List;

import com.chinasofti.rms.domain.Employee;
import com.chinasofti.rms.domain.Food_Menu;
import com.chinasofti.rms.domain.ROrder;
import com.chinasofti.rms.domain.ROrder_details;
import com.chinasofti.rms.domain.Vip;
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
	//根据菜谱id查询购物车的菜谱信息
	public List<temp_cart> SelectCartByFmid(int id);
	/*---订单处理 */
	//添加订单细目
	public String addRorder_details(temp_cart c);
	//查询所有订单细目
	public List<ROrder_details> showAllDetails();
	//根据订单id查询订单细目
	public List<ROrder_details> showDetailsById(int id);
	//添加订单
	public String addROrder(temp_cart c);
	//查询所有订单
	public List<ROrder> showAllOrder();
	//根据订单id查询订单
	public List<ROrder> showOrderById(int id);
	/*---为会员服务 */
	//添加会员
	public String addVip();
	//根据会员id查找会员
	public Vip findByVid(int vid);
	//为会员充值 ，更改会员状态
	public String changVipStatus();
	//更改过期会员
	public String removeVipStatus();
	//为会员补卡
	public String changVipVid();
	/*-------------经理的功能---------------*/
	
}
