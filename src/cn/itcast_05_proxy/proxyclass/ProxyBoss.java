package cn.itcast_05_proxy.proxyclass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBoss {
	/**
	 * 对接口方法进行代理
	 */
	//第一个参数结合具体的业务,第二个是代理的接口，第三个是代理类
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(final int discountCoupon,final Class<?> interfaceClass, final Class<?> implementsClass) throws Exception {
		//被代理的类的类加载器soneObjectclass.getClassLoader()，被代理类的所有实现接口new Class[] { Interface.class }，句柄方法new InvocationHandler()
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[] { interfaceClass }, new InvocationHandler() {
	   //三个参数，Object proxy(代理类对象),Method method(被代理类的方法),Object[] args（被代理类方法的传入参数）
			
			public Object invoke(Object proxy, Method method,Object[] args) throws Throwable {
						Integer returnValue = (Integer) method.invoke(implementsClass.newInstance(), args);// 调用原始对象以后返回的值
						return returnValue - discountCoupon; //原先的-discountCoupon
					}
			
			});
	}
}
