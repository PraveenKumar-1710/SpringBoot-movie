package com.movie.demo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.demo.model.Movie;
import com.movie.demo.repodataaccess.MovieListRepo;

@Controller
@RequestMapping("/")
public class MoviesListController {
	@Autowired
	private MovieListRepo movieListRepo;
	
 	@RequestMapping(method=RequestMethod.GET,value="/movies/{actor}")
	public String getMovieListByActor(@PathVariable("actor")String name, Model model) {
 		
 		/*List<Movie> movieList=new ArrayList<Movie>();
 		Movie movie = new Movie();
 		movie.setName("Thuppaki");
 		movie.setDescription("Adventure");
 		movie.setActor("vijay");
 		movieList.add(movie);
 		
 		movie.setName("kaithi");
 		movie.setDescription("Adventure");
 		movie.setActor("Karthi");
 		movieList.add(movie);*/
 		List<Movie> movieList=movieListRepo.findMoviesByActor(name);
 		model.addAttribute("movies", movieList);
		return "moviesList";
		
		
		
	}
 	@RequestMapping(method=RequestMethod.POST,value="/movies", consumes="application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie){
 		movieListRepo.save(movie);
 		return ResponseEntity.ok().build();
		
	}

}
