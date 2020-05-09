package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmByID(int filmID);
	public List<Film> findFilmsByKeyword(String keyword) throws SQLException;
	public Film findCreatedFilmsByID(int filmID);
	public List<Film> findCreatedFilmsByKeyword(String keyword) throws SQLException;
	public Actor findActorByID(int actorID) throws SQLException;
	public List<Actor> findActorsByFilmID(int filmID);
	
	public Film createFilm(Film film) throws SQLException;
	public void updateFilm(Film film);
	public String deleteFilm(int FilmID);
}
