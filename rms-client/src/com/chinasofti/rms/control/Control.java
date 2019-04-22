package com.chinasofti.rms.control;

import com.chinasofti.rms.Service.RMSService;
import com.chinasofti.rms.domain.Employee;
import com.chinasofti.rms.domain.ROrder_details;
import com.chinasofti.rms.domain.temp_cart;
import com.chinasofti.rms.util.UserInput;
import com.chinasofti.rms.view.View;
public class Control {
	private UserInput ui;
	private View v;
	private temp_cart cart;
	//创建业务层对象
	private RMSService service;
	public static final String IP="127.0.0.1";
	public static final int PORT=7669;
	
	public Control() {
		this.v = new View();
		this.ui = new UserInput();
		this.cart =new temp_cart();
		service=ProxyClient.getClient(RMSService.class, IP, PORT);
		
	}
	//程序开始的方法
	public void start(){
		Employee emp=null;
		//开始登录
		while(true){
			int id=this.ui.getInt("请输入登录账号：");
			String pwd=this.ui.getString("请输入登录密码：");
			emp=this.service.login(id, pwd);
			if(emp !=null){
				break;
			}
			this.v.print("信息输入有误，请重新输入！");
		}
		if(emp.getPower()==0){
			this.v.print("欢迎员工"+emp.getEname()+"登录系统");
		}
		if(emp.getPower()==1){
			this.v.print("欢迎经理"+emp.getEname()+"登录系统");
		}
		while(true){
			this.v.welcomeYuan();
			int select=this.ui.getInt("请选择：");
			if(select==0){
				//退出程序
				this.v.print("系统终止");
				System.exit(0);
			}else if(select==1){
				//进入点菜系统
				this.v.DianCan(); 
		 w1:	while(true){
			 		this.v.DianCan(); 
					int select2=this.ui.getInt("请选择操作：");	
					if(select2==0){
						//退出点菜系统
						break w1;
					}else if(select2==1){
						//展示菜谱的详细信息
						this.v.caidan();
						System.out.println();
			w3:			while(true){
							int selectT = this.ui.getInt("请选择想购买的菜品类别：");
							if(selectT==0){
								break w3;
							}else if(selectT>=1 &&selectT<=5){		
					w4:			while(true){
									//按类别展示菜谱
									this.showFoodByType(selectT);
									//接收用户要购买的信息
									//this.addOdetails();
									this.v.print(">>>购买界面");
									this.service.addFoodToCart(this.ui.getInt("请输入菜谱编号："), this.ui.getInt("请输入要购买的数量："));
									if(!"y".equals(this.ui.getString("是否继续选择菜谱(y/n)"))){
										this.v.print("该菜品类别的选餐终止~");
										break w4;
									}
								}
							}else if(selectT==6){
						w4:		while(true){
									//展示所有的菜谱信息
									this.showAllFood();
									//接收用户要购买的信息
									//this.addOdetails();
									this.v.print(">>>购买界面");
									this.service.addFoodToCart(this.ui.getInt("请输入菜谱编号："), this.ui.getInt("请输入要购买的数量："));
									if(!"y".equals(this.ui.getString("是否继续选择菜谱(y/n)"))){
										this.v.print("选餐终止~");
										break w4;
									}
								}
							}else{
								this.v.print("输入有误，请重新输入");
							}	
						}
					}else if(select2==2){
						//选择要购买的菜谱
					w5:	while(true){
						this.v.print(">>>购买界面");
						this.service.addFoodToCart(this.ui.getInt("请输入菜谱编号："), this.ui.getInt("请输入要购买的数量："));
						//	this.addOdetails();
							if(!"y".equals(this.ui.getString("是否继续选择菜谱(y/n)"))){
								this.v.print("选餐终止~");
								break w5;
							}
						}
					}else if(select2==3){
						//删除已经选择的菜谱信息
						//this.deleteOdetailsById();
						this.v.print(">>预选菜单删除");
						this.service.deleteFoodFromCart(this.ui.getInt("请输入要移除菜谱的编号："));
					}else if(select2==4){
						//查看已经选择的菜谱
						//this.showOdetails();
						this.v.print(">>预选菜单如下\n");
						this.service.showFoodInCart();
					}
				}
			}else if(select==2){
				this.v.jiesuan();
			}else if(select==3){
				this.v.vip();
			}
		}
	}
	//查看所有菜谱信息
	private void showAllFood(){
		this.v.print(">>所有菜谱如下：\n");
		this.v.showArray(this.service.showAllFood());
	}
	//按着类查看菜谱信息
	private void showFoodByType(int fid){
		this.v.print(">>该类菜谱信息如下：\t");
		this.v.showFood(this.service.showFoodByType(fid));
	}
	
	//由用户选择 向购物车添加食物
	private String addOdetails(){
		this.v.print(">>>购买界面");
		int fmid=this.ui.getInt("请输入菜品编号");
		int num=this.ui.getInt("请输入要购买的数量");
		this.cart.add(new ROrder_details(fmid, num));
		return "添加成功~~";
	}
	//展示已经选择的信息
	private void showOdetails() {
		this.v.print(">>预选菜单如下\n");
		this.v.showArray(cart.getOdetails());
	}
	//删除已经选择的信息
	private void deleteOdetailsById(){
		this.v.print(">>预选菜单删除");
		int id=this.ui.getInt("请输入要删除的菜谱的编号");
		//根据id查询菜单信息
		ROrder_details od=this.cart.selectById(id);
		//判断是否存在
		if(od==null){
			System.out.println("菜谱信息不存在！");
			return;
		}
		this.v.print("要删除的菜谱信息如下：");
		this.v.print(od.toString());
		//寻味是否要删除
		if(!"y".equals(this.ui.getString("是否确定删除(y/n)"))){
			this.v.print("删除终止~");
		}
		cart.deleteById(id);
		this.v.print("删除成功");
	}
}
