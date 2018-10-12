package com.uv.proxy;
/*
 * @author uv
 * @date 2018/10/12 13:56
 * 没有实现类的接口的动态代理
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("接口方法调用开始");
        //执行方法
        System.out.println("method name:" + method.getName());
        System.out.println("method args:" + args[0]);
        System.out.println("接口方法调用结束");
        return "sell " + args[0];
    }

    public static <T> T newInterfaceProxy(Class<T> intf) {
        ClassLoader classLoader = intf.getClassLoader();
        Class<?>[] interfaces = new Class[]{intf};
        InterfaceProxy proxy = new InterfaceProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}
