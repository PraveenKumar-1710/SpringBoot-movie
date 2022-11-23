package com.movie.demo.repodataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.demo.model.Movie;

public interface MovieListRepo extends JpaRepository<Movie, Long>{
	
	List<Movie> findMoviesByActor(String name);

}
