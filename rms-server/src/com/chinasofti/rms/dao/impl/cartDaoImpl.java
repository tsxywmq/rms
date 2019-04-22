package com.chinasofti.rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.rms.dao.cartDao;
import com.chinasofti.rms.domain.temp_cart;
import com.chinasofti.rms.util.DBUtil;

public class cartDaoImpl implements cartDao {
	private DBUtil db;
	//创建一个集合存放结果集中的结果
	private List<temp_cart> list = new ArrayList<temp_cart>();
	@Override
	public List<temp_cart> addToCart(int id,int num) {
		this.db = new DBUtil();
		String sql="select fmname,price from food_menu where fmid="+id;
		try {	
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new temp_cart(rs.getString(1), num, num*rs.getInt(2)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<temp_cart> deleteFromCart(int id) {
		 list.remove(id-1);
		return list;
	}

	@Override
	public List<temp_cart> showAll() {
		//遍历list集合
		for (temp_cart tc : list) {
			System.out.println(tc);
		}
		return list;
	}

}
