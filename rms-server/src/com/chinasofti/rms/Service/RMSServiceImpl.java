package com.chinasofti.rms.Service;

import java.util.List;

import com.chinasofti.rms.biz.EmployeeBiz;
import com.chinasofti.rms.biz.Food_MenuBiz;
import com.chinasofti.rms.biz.cartBiz;
import com.chinasofti.rms.biz.impl.EmployeeBizImpl;
import com.chinasofti.rms.biz.impl.Food_MenuBizImpl;
import com.chinasofti.rms.biz.impl.cartBizImpl;
import com.chinasofti.rms.domain.Employee;
import com.chinasofti.rms.domain.Food_Menu;
import com.chinasofti.rms.domain.temp_cart;

public class RMSServiceImpl implements RMSService {
	private EmployeeBiz empbiz;
	private Food_MenuBiz fmbiz;
	private cartBiz cbiz;
	//private VipBiz vbiz;
	public RMSServiceImpl() {
		super();
		this.empbiz=new EmployeeBizImpl();
		this.fmbiz=new Food_MenuBizImpl();
		this.cbiz=new cartBizImpl();
		//this.vbiz=new VipBizImpl();
	}

	@Override
	public Employee login(int id, String password) {	
		return this.empbiz.findByIdAndPassword(id, password);
	}

	@Override
	public String addVip() {
	//	return this.vbiz.insertVip()?"会员办理成功":"会员办理失败";
		return null;
	}

	@Override
	public String changVipStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeVipStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changVipVid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food_Menu> showAllFood() {
		return this.fmbiz.findAllFood();
	}

	@Override
	public List<Food_Menu> showFoodByType(int fid) {
		return this.fmbiz.findFoodByType(fid);
	}

	@Override
	public List<temp_cart> addFoodToCart(int id,int num) {
		return this.cbiz.insertFoodToCart(id,num);
	}

	@Override
	public List<temp_cart> deleteFoodFromCart(int id) {
		return this.cbiz.dropFoodFromCart(id);
	}

	@Override
	public List<temp_cart> showFoodInCart() {
		return this.cbiz.showCartFood();
	}

}
