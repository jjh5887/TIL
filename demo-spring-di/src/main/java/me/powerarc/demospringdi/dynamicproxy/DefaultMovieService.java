package me.powerarc.demospringdi.dynamicproxy;

public class DefaultMovieService implements MovieService {

	@Override
	public void rent(Movie movie) {
		System.out.println("rent: " + movie.getTitle());
	}

	@Override
	public void returnMovie(Movie movie) {
		System.out.println("return: " + movie.getTitle());
	}
}
