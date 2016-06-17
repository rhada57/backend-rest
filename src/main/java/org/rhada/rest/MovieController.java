package org.rhada.rest;

import java.util.ArrayList;
import java.util.List;

import org.rhada.persistence.repositories.MovieRepository;
import org.rhada.persistences.entities.Genre;
import org.rhada.persistences.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping("hello")
	public String sayHello() {
		return ("Hello, SpringBoot on Openshift");
	}

	@RequestMapping(path="movies", method=RequestMethod.GET)
	public @ResponseBody Iterable<Movie> getMovies() {
		System.out.println("List of all movies");
		Iterable<Movie> movies = movieRepository.findAll();
		return movies;
	}

	@RequestMapping("addStarWarsMovie")
	public String addStarWarsMovie() {

		Movie movie = new Movie();
//		movie.setId("1");
		movie.setName("Star Wars");
		movie.setCriticRating(10.2);

		List<Genre> starWarsGenre = new ArrayList<Genre>();
		starWarsGenre.add(new Genre("ACTION"));
		starWarsGenre.add(new Genre("SCI_FI"));
		movie.setGenres(starWarsGenre);
		
		movieRepository.save(movie);

		return movie.toString();
	}
	

	@RequestMapping(path="addMovies", method=RequestMethod.PUT)
	public @ResponseBody List<Movie> addMovies(@RequestBody List<Movie> movies) {
		System.out.println("Persist a list of movies");
	
		movieRepository.save(movies);
		return movies;
	}
	
}