package me.powerarc.designpatterns.structural_patterns.proxy_pattern._03_java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import me.powerarc.designpatterns.structural_patterns.proxy_pattern._02_after.DefaultGameService;
import me.powerarc.designpatterns.structural_patterns.proxy_pattern._02_after.GameService;

public class ProxyInJava {

	public static void main(String[] args) throws InterruptedException {
		ProxyInJava proxyInJava = new ProxyInJava();
		proxyInJava.dynamicProxy();
	}

	private void dynamicProxy() throws InterruptedException {
		GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
		gameServiceProxy.startGame();
	}

	private GameService getGameServiceProxy(GameService target) {
		return (GameService)Proxy.newProxyInstance(this.getClass().getClassLoader(),
			new Class[] {GameService.class},
			new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("O");
					Object invoke = method.invoke(target, args);
					System.out.println("ㅁ");
					return invoke;
				}
			});
	}
}
