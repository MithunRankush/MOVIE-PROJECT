package com.project.movies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String movieName;
	int yor;
	String language;
	double imdb;
	String pic;
	String trailer;
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getYor() {
		return yor;
	}
	public void setYor(int yor) {
		this.yor = yor;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getImdb() {
		return imdb;
	}
	public void setImdb(double imdb) {
		this.imdb = imdb;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Movie(int id, String movieName, int yor, String language, double imdb, String pic,String trailer) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.yor = yor;
		this.language = language;
		this.imdb = imdb;
		this.pic = pic;
		this.trailer=trailer;
	}
	
	public Movie()
	{
		System.out.println("im contructor");
	}

	
	

}
