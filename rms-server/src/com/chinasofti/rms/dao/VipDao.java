package com.chinasofti.rms.dao;

import com.chinasofti.rms.domain.Vip;

//创建对会员进行操作的接口
public interface VipDao {
	//增加会员信息
	public boolean insertVip(Vip v);
	//为会员进行充值,更改会员状态 ,需要输入会员id
	public boolean updateVStatus(int id);
	//为会员补卡，输入之前的卡号
	public boolean updateVid(int id );
	//将会员卡使用日期超过一个月的人的会员权限撤销
	public boolean removeVip();
}
