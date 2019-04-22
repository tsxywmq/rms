package com.chinasofti.rms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import com.chinasofti.rms.dao.VipDao;
import com.chinasofti.rms.dao.cartDao;
import com.chinasofti.rms.dao.impl.VipDaoImpl;
import com.chinasofti.rms.dao.impl.cartDaoImpl;
import com.chinasofti.rms.domain.Vip;
import com.chinasofti.rms.domain.temp_cart;
public class Mytest {
	
	@Test
	public void insertVip(){
		VipDao vdao=new VipDaoImpl();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			boolean b = vdao.insertVip(new Vip("阿强", "男", 12332112342L, sdf.parse("2019-4-10"), 1));
			System.out.println(b);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateVStatus(){
		VipDao vdao=new VipDaoImpl();
		boolean b = vdao.updateVStatus(10002);
		System.out.println(b);
	}
	@Test
	public void updateVid(){
		VipDao vdao=new VipDaoImpl();
		System.out.println(vdao.updateVid(10002));
	}
	@Test
	public void removeVip(){
		VipDao vdao=new VipDaoImpl();
		System.out.println(vdao.removeVip());
	}
	@Test
	public void addfoodtocart(){
		cartDao dao=new cartDaoImpl();
		 List<temp_cart> list = dao.addToCart(5,3);
		for (temp_cart t : list) {
			System.out.println(t);
		}
	}
	@Test
	public void showfoodtocart(){
		cartDao dao=new cartDaoImpl();
		 List<temp_cart> list = dao.showAll();
		for (temp_cart t : list) {
			System.out.println(t);
		}
	}
}
