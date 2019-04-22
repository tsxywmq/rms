package com.chinasofti.rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.rms.dao.Food_MenuDao;
import com.chinasofti.rms.domain.Food_Menu;
import com.chinasofti.rms.util.DBUtil;

public class Food_MenuDaoImpl implements Food_MenuDao {
	private DBUtil db;
	//展示所有的菜谱信息
	@Override
	public List<Food_Menu> showFood() {

		this.db=new DBUtil();
		String sql="select m.fmid,m.fmname,m.price,t.ftype from food_menu m ,food_type t where m.fid=t.fid";
		try {
			//创建一个集合存放所有的菜谱
			List<Food_Menu> list=new ArrayList<Food_Menu>();
			//执行sql语句获取结果集
			ResultSet rs = this.db.query(sql);
			//将结果集遍历	
			while(rs.next()){
				list.add(new Food_Menu(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));	
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.db.closed();
		}
	}
	//增加菜谱的信息
	@Override
	public Food_Menu addFood() {
		this.db=new DBUtil();
		String sql="";
		return null;
	}
	//删除菜谱的信息
	@Override
	public void dropFood() {
		this.db=new DBUtil();
		String sql="";

	}
	//按类别展示菜谱
	@Override
	public List<Food_Menu> showFoodByType(int fid) {
		this.db=new DBUtil();
		String sql="select * from food_menu where fid="+fid;
		try {
			//创建一个list集合 存放查询到的结果
			List<Food_Menu> list=new ArrayList<Food_Menu>();
			ResultSet rs = this.db.query(sql);
			//遍历结果集
			while(rs.next()){
				list.add(new Food_Menu(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
