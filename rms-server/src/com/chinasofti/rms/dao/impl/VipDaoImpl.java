package com.chinasofti.rms.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.chinasofti.rms.dao.VipDao;
import com.chinasofti.rms.domain.Vip;
import com.chinasofti.rms.util.DBUtil;

public class VipDaoImpl implements VipDao {
	private DBUtil db;

	@Override
	public boolean insertVip(Vip v) {
		//实例化db
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into vip values(Seq_vip.Nextval,?,?,?,to_date(?,'yyyy-mm-dd'),?)";	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			//执行sql
			int i = this.db.update(sql,v.getVname(),v.getVsex(),v.getVphone(),sdf.format(v.getVbirth()),v.getVstatus());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}
	}

	@Override
	public boolean updateVStatus(int id) {
		this.db=new DBUtil();
		String sql="update vip set vstatus=1 where vid="+id;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.db.closed();
		}
		return false;
	}

	@Override
	public boolean updateVid(int id) {
		this.db=new DBUtil();
		String sql="update vip set vid=Seq_vip.Nextval where vid="+id;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			this.db.closed();
		}
	}

	@Override
	public boolean removeVip() {
		this.db=new DBUtil();
		String sql="update vip set vstatus=0 where months_between((select sysdate from dual),vbirth)>1";
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.db.closed();
		}
		return false;
	}

}
