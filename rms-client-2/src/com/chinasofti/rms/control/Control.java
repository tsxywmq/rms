package com.chinasofti.rms.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.rms.Service.RMSService;
import com.chinasofti.rms.domain.Employee;
import com.chinasofti.rms.domain.ROrder;
import com.chinasofti.rms.domain.ROrder_details;
import com.chinasofti.rms.domain.Vip;
import com.chinasofti.rms.domain.temp_cart;
import com.chinasofti.rms.util.UserInput;
import com.chinasofti.rms.view.View;
public class Control {
	private UserInput ui;
	private View v;
	private int empid=0;//登陆者编号
	private int vid=0;//vip编号
	private double opay=0;//实际收款金额
	//private temp_cart cart;
	//创建业务层对象
	private RMSService service;
	public static final String IP="127.0.0.1";
	public static final int PORT=7669;
	
	public Control() {
		this.v = new View();
		this.ui = new UserInput();
		//this.cart =new temp_cart();
		service=ProxyClient.getClient(RMSService.class, IP, PORT);
		
	}

	//程序开始的方法
	public void start(){
		Employee emp=null;
		temp_cart cart = null;
		//商品结算  
		/*double sumAll = this.sumAll();//总价
		double opay=sumAll*0.8;//实收
		double cut=sumAll*(1-0.8);//折扣
*/		//开始登录
		while(true){
			this.empid=this.ui.getInt("请输入登录账号：");
			String pwd=this.ui.getString("请输入登录密码：");
			emp=this.service.login(empid, pwd);
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
							int selectT = this.ui.getInt("请选择想购买的菜品类别：(输入0返回上一级)");
							if(selectT==0){
								break w3;
							}else if(selectT>=1 &&selectT<=5){		
					w4:			while(true){
									//按类别展示菜谱
									this.showFoodByType(selectT);
									//将用户选择的信息加入购物车
									this.addToCart();
									if(!"y".equals(this.ui.getString("是否继续选择菜谱(y/n)"))){
										this.v.print("该菜品类别的选餐终止~");
										break w4;
									}
								}
							}else if(selectT==6){
						w4:		while(true){
									//展示所有的菜谱信息
									this.showAllFood();
									//将用户选择的信息加入购物车
									this.addToCart();
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
						//将用户选择的信息加入购物车
						this.addToCart();
							if(!"y".equals(this.ui.getString("是否继续选择菜谱(y/n)"))){
								this.v.print("选餐终止~");
								break w5;
							}
							
						}
					}else if(select2==3){
						//删除已经选择的菜谱信息
						this.deleteFromCart();
					}else if(select2==4){
						//查看已经选择的菜谱
						this.v.print(">>预选菜单如下\n");
						this.showCart();
					}
				}
			}else if(select==2){
				
				//结算界面
				this.v.jiesuan();
		w1:		while(true){
					double sumAll = this.sumAll();
					this.opay=sumAll;
					double cut=0;
					int selectjs = this.ui.getInt(">>请选择");
					if(selectjs==0){
						break w1;
					}else if(selectjs==1){
						//账单结算功能						
						if("y".equals(this.ui.getString("(是否为会员y/n)"))){
							this.vid = this.ui.getInt("请输入会员卡号：");
							Vip vip = this.service.findByVid(vid);						
							while(vip.getVstatus()!=0 || vip != null){
								//权限没有过期，并且该vip存在  会会员，可以打折
								this.opay=sumAll*0.8;
							    cut=sumAll*(1-0.8);
								this.v.print("消费合计："+sumAll);
								this.v.print("优惠合计："+cut);
								this.v.print("实际收款："+opay);
							}
							this.v.print("消费合计："+sumAll);
						}else{
							this.v.print("消费合计："+sumAll);
						}	
						break w1;
					}else if(selectjs==2){
						//小票打印功能
						//获取当前系统时间
						Date now=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
						SimpleDateFormat da=new SimpleDateFormat("yyyyMMdd");
						this.v.print("\n-------------壹点心意餐馆结账单-------------\n");
						this.v.print("收银员编号："+emp.getEid());
						this.v.print("交易时间："+sdf.format(now));
						this.v.print("交易号："+da.format(now));
						this.v.print("\n-----------------------------------------------");
						this.showCart();
						this.v.print("-----------------------------------------------");
						this.v.print("消费合计："+sumAll);
						this.v.print("-----------------------------------------------");
						this.v.print("优惠合计："+cut);
						this.v.print("-----------------------------------------------");
						this.v.print("实际收款："+opay);
						this.v.print("-----------------------------------------------");
						
										/*将数据填入数据库表中*/	
						//将数据添加到订单表中
						temp_cart tc=new temp_cart(opay, empid, vid);
						//this.service.addROrder(tc);
						//将数据添加到订单详情表中
						temp_cart c=new temp_cart();
						//获得最终确定list集合 
						List<temp_cart> list = this.service.showFoodInCart();
						//遍历该集合
						for (int i = 0; i <list.size(); i++) {
							//获取每个食谱的编号和数量
							int fmid = list.get(i).getFmid();
							int dnum = list.get(i).getDnum();
							//将其填入订单详情表中
							c=new temp_cart(fmid, dnum);
							this.service.addRorder_details(c);
						}
						System.exit(0);
					}
				}
			}else if(select==3){
				//进入会员系统
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
	//显示购物车中的信息
	private void showCart(){
		this.v.showCartMessage(this.service.showFoodInCart());
	}
	//向购物车中添加信息
	private List<temp_cart> addToCart(){
		this.v.print(">>>购买界面");
		int fmid=this.ui.getInt("请输入菜谱编号：");
		int fmnum=this.ui.getInt("请输入要购买的数量");
		return this.service.addFoodToCart(fmid, fmnum);
	}
	//删除购物车中的信息
	private void deleteFromCart(){
		this.v.print(">>预选菜单删除");
		int id=this.ui.getInt("请输入要删除的菜谱编号:");
		if(!"y".equals(this.ui.getString("是否确定删除(y/n)"))){
			this.v.print("删除终止~");
		}
		this.service.deleteFoodFromCart(id);
		this.v.print("\n删除成功");
	}
	//购物车中结算总价
	private double sumAll(){
		List<temp_cart> list = this.service.showFoodInCart();
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			double d= list.get(i).getCount();
			sum+=d;
		}
		return sum;
	}
	
	
	//最终将信息插入订单表和订单详情表中
	private void insertToRorderDetails(temp_cart c){
		String s = this.service.addRorder_details(c);
		System.out.println("插入成功");
	}
}
