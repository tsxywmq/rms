package com.chinasofti.rms.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

//创建网络连接服务器端获取代理对象
public class ProxyClient {
	//参数的介绍  1、当前对象的类加载器  2、客户端中介  3、实现代理接口
	public static<T>T getClient(Class<T>clazz,String ip,int port){
		return (T) Proxy.newProxyInstance(ProxyClient.class.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
	//匿名内部类		
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//创建套接字对象
				Socket client=new Socket(ip,port);
				//创建输出流 向服务器端发送数据
				ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
				oos.writeUTF(method.getName());
				oos.flush();
				oos.writeObject(method.getParameterTypes());
				oos.flush();
				oos.writeObject(args);
				oos.flush();
				ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
				return ois.readObject();
			}
		});
	}
}
