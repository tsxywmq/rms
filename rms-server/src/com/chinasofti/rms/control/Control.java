package com.chinasofti.rms.control;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.chinasofti.rms.Service.RMSService;
import com.chinasofti.rms.Service.RMSServiceImpl;

//负责接收客户端连接  创建线程
public class Control {
	//创建服务器套接字对象
	private ServerSocket server;
	public static final int PORT=7669;
	//创建线程池对象
	private ExecutorService es;
	//创建被代理的对象
	private RMSService service;
	public Control(){
		try {
			System.out.println("服务器正在开启中......");
			//创建服务器
			this.server=new ServerSocket(PORT);
			Thread.sleep(1000);
			System.out.println("服务器已经开启");
			//实例化线程池对象
			es=Executors.newCachedThreadPool();
			this.service=new RMSServiceImpl();
			//this.tb=new TeacherBizImpl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//自定义方法-项目流程方法
	public void start(){
		//创建while循环  为死循环，服务器一旦开启。不关闭
		while(true){
			//等待客户端连接
			try {
				Socket client=this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				//创建线程对象
				ControlThread ct=new ControlThread(client,service);			
				//将线程对象交给线程池管理
				es.submit(ct);
				
				//返回活跃线程数
				int num = ((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前活跃用户："+num);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
