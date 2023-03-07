package com.project.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.movies.entity.Movie;
import com.project.movies.service.MovieService;



@CrossOrigin
@Controller
@RequestMapping("/")
public class MovieController {
	public MovieController() {
		System.out.println("Im MovieController");
	}

	@Autowired
	private MovieService mvService;

	@RequestMapping("/items")
	public ResponseEntity<List<Movie>> getAll() {
		List<Movie> obj = mvService.getAll();
		if (obj != null && obj.size() > 0) {
			return ResponseEntity.status(200).body(obj);
		}
			return ResponseEntity.status(400).body(obj);
	}
	@RequestMapping("/items/{id}")
    public ResponseEntity<Movie> getfood(@PathVariable("id") Integer id)
    {
	  Movie movie= mvService.getById(id);
		if(movie!=null) {
    	return ResponseEntity.status(200).body(movie);
		}
		return ResponseEntity.status(400).body(movie);
    }
	 @RequestMapping("/delete/{id}")
	    public ResponseEntity<List<Movie>> removeId(@PathVariable("id") Integer id)
	    {
	    	List<Movie> list = mvService.removeId(id);
			if(list!=null) {
	    	return ResponseEntity.status(200).body(list);
			}
			return ResponseEntity.status(400).body(list);
	    }
	 @RequestMapping("/create")
	    public ResponseEntity<Movie> saveData(@RequestBody Movie food) 
	    {
		 Movie listData= mvService.saveData(food);
			if(listData!=null) {
	    	return ResponseEntity.status(200).body(listData);
			}
			return ResponseEntity.status(400).body(listData);
	    }
	 @PutMapping("/update/{id}")
	    public ResponseEntity<Movie> update(@PathVariable("id") Integer id ,@RequestBody Movie d) 
	    {
			boolean value= mvService.Update(id ,d);
			if(value) {
	    	return ResponseEntity.status(200).body(d);
			}
			return ResponseEntity.status(400).body(d);
	    }

}
