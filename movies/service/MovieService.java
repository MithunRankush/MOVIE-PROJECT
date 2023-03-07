package com.project.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movies.dao.MovieDao;
import com.project.movies.entity.Movie;

@Service
public class MovieService {
	public MovieService() {
		System.out.println("Im MovieService");
	}

	@Autowired
	private MovieDao mvDao;

	public List<Movie> getAll() {
		return mvDao.findAll();
	}

	public Movie getById(Integer id) {
		return mvDao.findById(id).get();
	}

	public List<Movie> removeId(Integer id) {

		if (mvDao.existsById(id)) {
			mvDao.deleteById(id);
			return getAll();
		}
		return null;
	}

	public Movie saveData(Movie movie) {

		return mvDao.save(movie);
	}

	public boolean Update(int id, Movie d) {
		Optional<Movie> op = mvDao.findById(id);
		if (op != null) {
			Movie m = op.get();

			m.setMovieName(d.getMovieName());
			m.setLanguage(d.getLanguage());
			m.setImdb(d.getImdb());
			m.setYor(d.getYor());
			m.setPic(d.getPic());
			saveData(m);

			return true;
		}
		return false;
	}

}
