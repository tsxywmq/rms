package com.chinasofti.rms.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
//客户端被代理的对象
public class ClientHandler implements InvocationHandler{
	//创建属性  IP地址和端口号
	private String ip;
	private int port;
	
	public ClientHandler(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
		//创建套接字对象
		Socket client=new Socket(ip,port);
		//获取输出流
		ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
		//具体要实用发射实现代理操作的传输
		//将代理的方法名称发送费服务器
		oos.writeUTF(method.getName());
		//刷新缓冲流
		oos.flush();
		//讲方法的参数发送给服务器端
		oos.writeObject(method.getParameterTypes());
		oos.flush();
		oos.writeObject(arg);
		oos.flush();
		//创建输入流     接收服务器返回的结果
		ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
		return ois.readObject();
	}

}
