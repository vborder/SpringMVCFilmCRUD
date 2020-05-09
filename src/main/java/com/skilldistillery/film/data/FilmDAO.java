package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmByID(int filmID);
	public List<Film> findFilmsByKeyword(String keyword);
	public Film findCreatedFilmsByID(int filmID);
	public List<Film> findCreatedFilmsByKeyword(String keyword);
	public Actor findActorByID(int actorID);
	public List<Actor> findActorsByFilmID(int filmID);
	
	public int addFilm(Film film);
	public void updateFilm(Film film);
	public String deleteFilm(int FilmID);
}
