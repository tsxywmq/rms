package com.chinasofti.rms.view;


import java.util.List;

import com.chinasofti.rms.domain.Food_Menu;
import com.chinasofti.rms.domain.ROrder_details;
import com.chinasofti.rms.domain.temp_cart;
import com.chinasofti.rms.util.UserInput;

public class View {
	private UserInput ui;
	//员工登陆后的界面主要界面
	public void welcomeYuan(){
		System.out.println("-------------欢迎使用饭店管理系统-------------");
		System.out.println("1、点餐系统");
		System.out.println("2、结账系统");
		System.out.println("3、会员系统");
		System.out.println("0、退出系统");
	}
	//点餐界面
	public void DianCan(){
		System.out.println(">>点餐系统");
		System.out.println("--------------------------");
		System.out.println("1、查看菜单");
		System.out.println("2、选择菜谱");
		System.out.println("3、删除菜谱");
		System.out.println("4、查看已选菜谱");
		System.out.println("0、返回上一级");
	}
	//具体的菜单界面
	public void caidan(){
		System.out.println(">>查看菜单");
		System.out.println("--------------------------");
		System.out.println("1、面食");
		System.out.println("2、海鲜类");
		System.out.println("3、汤类");
		System.out.println("4、凉菜类");
		System.out.println("5、干锅类");	
		System.out.println("6、查看所有菜谱");	
		System.out.println("0、返回上一级");
	}
	//结算界面，选择结算方式
	public void jiesuan(){
		System.out.println(">>结账系统");
		System.out.println("--------------------------");
		System.out.println("1、账单结算");
		System.out.println("2、小票打印");
		System.out.println("0、返回");
	}
	//会员办理界面
	public void vip(){
		System.out.println(">>会员系统");
		System.out.println("--------------------------");
		System.out.println("1、会员办理");
		System.out.println("2、会员卡充值");
		System.out.println("3、会员卡挂失");
		System.out.println("4、移除会员权限");
		System.out.println("0、退出");
	}
	//打印提示信息的内容
	public void print(String msg){
		System.out.println(msg);
	}
	//显示客户预选订单的信息
	public void showArray(ROrder_details[] rOrder_details){
		System. out. println("菜谱编号\t菜谱数量");
		for (ROrder_details od : rOrder_details) {
			System.out.println(od);
		}
	}
	//显示所有菜谱的信息
	public void showArray(List<Food_Menu> food){
		System. out. println("菜谱编号\t菜谱名称\t\t菜谱单价\t\t菜谱类别");
		for (Food_Menu f : food) {
			System.out.println(f);
		}	
	}
	//按照类别显示菜谱的信息
	public void showFood(List<Food_Menu> food){
		System. out. println("菜谱编号\t菜谱名称\t\t菜谱单价");
		for (Food_Menu f : food) {
			System.out.println(f.getFmid()+"\t"+f.getFmname()+"\t\t"+f.getPrice());
		}	
	}
	
	//显示购物车信息
	public void showCartMessage(List<temp_cart> cart){
		System.out.println("菜谱编号\t菜谱名称\t\t菜谱数量\t菜谱单价\t总计\n");
		for (temp_cart t : cart) {
			System.out.println(t.getFmid()+"\t"+t.getFmname()+"\t\t"+t.getDnum()+"\t"+t.getPrice()+"\t"+t.getCount());
		}
	}
}
