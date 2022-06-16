package me.powerarc.demospringdi.dynamicproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

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

}