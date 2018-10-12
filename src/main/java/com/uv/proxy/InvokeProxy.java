package com.uv.proxy;
/*
 * @author uv
 * @date 2018/10/12 13:04
 *
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvokeProxy implements InvocationHandler{

    //要代理的真实对象
    private Object subject;

    public InvokeProxy(Object subject) {
        this.subject = subject;
    }

    /**
     * @param proxy 指代我们所代理的那个真实对象
     * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args 指代的是调用真实对象某个方法时接受的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start method:" + method.getName());
        method.invoke(subject, args);
        System.out.println("end method:" + method.getName());
        return null;
    }
}
