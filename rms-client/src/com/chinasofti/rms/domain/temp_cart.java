package com.chinasofti.rms.domain;

//暂时将用户选择菜存放其中，确认结算时，将其加入订单
public class temp_cart {
	//属性
	private String fmname;//菜谱名称
	private int dnum;//菜谱数量
	private double price;//菜谱单价 
	private double count;//菜谱总价  数量dnum*单价price
	//创建暂时存放的订单详细数组
	private ROrder_details[] odetailsArr=new ROrder_details[0];

	public temp_cart() {
		super();
	}
	public String getFmname() {
		return fmname;
	}
	public void setFmname(String fmname) {
		this.fmname = fmname;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}

	//重写toString方法
	@Override
	public String toString() {
		return this.fmname+"\t"+this.dnum+"\t"+this.count;
	}
	
	//设置get方法，得到数组中的全部对象
	public ROrder_details[] getOdetails(){
		return odetailsArr;
	}
	//设置添加菜单的方法，一次加一个
	public void add(ROrder_details odetails){
		//创建一个新的数组,长度加一
		ROrder_details[] newArr=new ROrder_details[this.odetailsArr.length+1];
		//将旧数组中的数据存到新的数组中
		for (int i = 0; i < odetailsArr.length; i++) {
			newArr[i]=this.odetailsArr[i];
		}
		//将新添加进的数据放入新的数组中，放入最后一个位置上
		newArr[this.odetailsArr.length]=odetails;
		//将新的数组的地址 赋值给旧的数组
		this.odetailsArr=newArr;
	}
	
	//根据id查询菜单的方法
	public ROrder_details selectById(int fmid){
		//遍历数组
		for (ROrder_details rd : odetailsArr) {
			//数组中值得id与输入的id一致时 ，返回rd
			while(rd.getFmid()==fmid){
				return rd;
			}
		}
		return null;
	}
	
	//根据id删除选择的菜单的方法
	public boolean deleteById(int fmid){
		//创建一个数组，存放被删除的菜单信息，长度减1
		ROrder_details[] newArr=new ROrder_details[this.odetailsArr.length-1];
		//遍历旧的数组
		for (int i = 0; i < odetailsArr.length; i++) {
			//找到与输入的id相同的food的id
			if(this.odetailsArr[i].getFmid()==fmid){
				//id之前的信息直接存入新的数组中
				//id之后的信息下标-1存入信息的数组中
				for (int j = 0; j <i; j++) {
					newArr[j]=odetailsArr[j];
				}
				for (int j = i+1; j < odetailsArr.length; j++) {
					newArr[j-1]=odetailsArr[j];
				}
			}
		}
		//遍历删除数据后的数组
		for (ROrder_details rd : newArr) {
			System.out.println(rd);
		}	
		//将新的数组的引用地址传给就旧的数组
		this.odetailsArr=newArr;
		return true;
	}
}
