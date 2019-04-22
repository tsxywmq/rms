package com.chinasofti.rms.biz;

import com.chinasofti.rms.domain.Vip;

public interface VipBiz {
	//增加会员信息
	public String addVip(Vip v);
	//为会员进行充值,更改会员状态 ,需要输入会员id
	public String updateVStatus(int id);
	//为会员补卡，输入之前的卡号
	public String updateVid(int id );
	//将会员卡使用日期超过一个月的人的会员权限撤销
	public String removeVip();
}
