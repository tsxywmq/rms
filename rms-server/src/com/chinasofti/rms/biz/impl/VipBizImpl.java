package com.chinasofti.rms.biz.impl;

import com.chinasofti.rms.biz.VipBiz;
import com.chinasofti.rms.dao.VipDao;
import com.chinasofti.rms.dao.impl.VipDaoImpl;
import com.chinasofti.rms.domain.Vip;

public class VipBizImpl implements VipBiz{
	private VipDao vdao;
	
	public VipBizImpl() {
		super();
		this.vdao = new VipDaoImpl();
	}

	@Override
	public String addVip(Vip v) {
		return this.vdao.insertVip(v)?"会员信息添加成功":"会员信息添加失败";
	}

	@Override
	public String updateVStatus(int id) {
		return this.vdao.updateVStatus(id)?"会员充值成功":"会员充值失败";
	}

	@Override
	public String updateVid(int id) {
		return this.vdao.updateVid(id)?"补卡成功":"补卡失败";
	}

	@Override
	public String removeVip() {
		return this.vdao.removeVip()?"会员权限移除成功":"会员权限移除失败";
	}

}
