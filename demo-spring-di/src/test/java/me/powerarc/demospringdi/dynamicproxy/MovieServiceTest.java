package me.powerarc.demospringdi.dynamicproxy;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MovieServiceTest {

	MovieService movieService = (MovieService)Proxy.newProxyInstance(MovieService.class.getClassLoader(),
		new Class[] {MovieService.class},
		(proxy, method, args) -> {
			// interface로만 가능
			MovieService movieService = new DefaultMovieService();
			if (method.getName().equals("rent")) {
				System.out.println("aaaa");
				Object invoke = method.invoke(movieService, args);
				System.out.println("bbb");
				return invoke;
			}
			return method.invoke(movieService, args);
		});

	@Test
	public void proxy() {
		Movie movie = new Movie();
		movie.setTitle("spring");

		movieService.rent(movie);
		System.out.println();
		movieService.returnMovie(movie);
	}

	@Test
	public void enhancer() {
		// class에 프록시 적용하는 방법 by Cglib
		// 상속을 허용하지 않으면 사용 불가능
		MethodInterceptor handler = new MethodInterceptor() {
			DefaultMovieService defaultMovieService = new DefaultMovieService();
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws
				Throwable {
				if (method.getName().equals("rent")) {
					System.out.println("aaaa");
					Object invoke = method.invoke(defaultMovieService, objects);
					System.out.println("bbb");
					return invoke;
				}
				return method.invoke(defaultMovieService, objects);
			}
		};

		DefaultMovieService defaultMovieService = (DefaultMovieService)Enhancer.create(DefaultMovieService.class, handler);

		Movie movie = new Movie();
		movie.setTitle("spring");

		defaultMovieService.rent(movie);
		System.out.println();
		defaultMovieService.returnMovie(movie);
	}


	@Test
	public void byteBuddy() throws
		NoSuchMethodException,
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException {
		// class에 프록시 적용하는 방법 by ByteBuddy
		// 상속을 허용하지 않으면 사용 불가능
		Class<? extends DefaultMovieService> proxyClass = new ByteBuddy().subclass(DefaultMovieService.class)
			.method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
				DefaultMovieService defaultMovieService = new DefaultMovieService();
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("aaa");
					Object invoke = method.invoke(defaultMovieService, args);
					System.out.println("bbb");
					return invoke;
				}
			}))
			.make().load(DefaultMovieService.class.getClassLoader()).getLoaded();

		DefaultMovieService defaultMovieService = proxyClass.getConstructor(null).newInstance();

		Movie movie = new Movie();
		movie.setTitle("spring");

		defaultMovieService.rent(movie);
		System.out.println();
		defaultMovieService.returnMovie(movie);

	}
}