package com.uv.proxy;
/*
 * @author uv
 * @date 2018/10/12 14:36
 *
 */

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

    //业务对象，被代理
    private Object subject;

    //相当于JDK动态代理中的绑定
    public <T> T getInstance(T subject) {
        //给业务对象赋值
        this.subject = subject;
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.subject.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return (T)enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before");
        //调用业务类（父类中）的方法
        proxy.invokeSuper(obj, args);
        System.out.println("after");
        return null;
    }
}
