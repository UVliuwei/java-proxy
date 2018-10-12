package com.uv;

import com.uv.proxy.CglibProxy;
import com.uv.proxy.InterfaceProxy;
import com.uv.proxy.InvokeProxy;
import com.uv.service.BuyService;
import com.uv.service.SellService;
import com.uv.service.impl.BuyServiceImpl;
import com.uv.service.impl.SayService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <uv> [2018/10/12 10:50]
 */
public class Main {

    public static void main(String[] args) {

        //要代理的真实对象
        BuyService service = new BuyServiceImpl();
        InvocationHandler handler = new InvokeProxy(service);
        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象
         * 第一个参数 handler.getClass().getClassLoader() ，使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数 realSubject.getClass().getInterfaces()，为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数 handler，将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        BuyService buyService = (BuyService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        buyService.buy("cap");

        //---------------接口无实现类----------------

        SellService sellService = InterfaceProxy.newInterfaceProxy(SellService.class);
        System.out.println(sellService.sell("cap"));

        //--------------cglib---------------
        //被代理的对象
        SayService s = new SayService();
        //代理类
        CglibProxy cglibProxy = new CglibProxy();
        SayService sayService = cglibProxy.getInstance(s);
        sayService.say("Tom");
    }
}
