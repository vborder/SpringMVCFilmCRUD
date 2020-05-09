package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDAOImpl implements FilmDAO {

	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	private final String user = "student";
	private final String pass = "student";

	private final String fullDataQuery = "SELECT id, title, description, release_year, language_id,"
			+ " rental_duration, rental_rate, length, replacement_cost, rating, special_features " + "FROM film ";

	public FilmDAOImpl() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Override
	public Film findFilmByID(int filmID) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = fullDataQuery + "WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, filmID);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				film = mapResultSetToFilm(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film findCreatedFilmsByID(int filmID) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = fullDataQuery + "WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, filmID);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				film = mapResultSetToFilm(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findCreatedFilmsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor findActorByID(int actorID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmID(int filmID) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public int addFilm(Film film) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public String deleteFilm(int FilmID) {
		// TODO Auto-generated method stub
		return null;
	}

	private Film mapResultSetToFilm(ResultSet rs) throws SQLException {
		Film film = null;
		film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("release_year"),
				rs.getInt("language_id"), rs.getInt("rental_duration"), rs.getDouble("rental_rate"), rs.getInt("length"),
				rs.getDouble("replacement_cost"), rs.getString("rating"), rs.getString("special_features"));

		return film;
	}

	@Override
	public int createFilm(Film film) {
		// TODO Auto-generated method stub
		return 0;
	}

}
