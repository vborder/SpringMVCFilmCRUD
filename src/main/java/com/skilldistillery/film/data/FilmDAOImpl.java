package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDAOImpl implements FilmDAO {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=MST";

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

		String user = "student";
		String pass = "student";
		String sql = "SELECT film.*, name FROM film JOIN language ON film.language_id = language.id WHERE film.id = ? ";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, filmID);
			ResultSet rs = st.executeQuery();

//			if (rs.next()) {
//				film = mapResultSetToFilm(rs);
//			}

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRating(rs.getString("rating"));
				film.setDescription(rs.getString("description"));
				film.setLanguage(rs.getString("name"));
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		String user = "student";
		String pass = "student";
		String sql = "SELECT film.*, name FROM film JOIN language ON film.language_id = language.id "
				+ "WHERE film.title LIKE ? OR film.description LIKE ?";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
//				films = mapResultSetToFilm(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
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
		List<Actor> actors = new ArrayList<>();

		String user = "student";
		String pass = "student";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id "
					+ "JOIN actor on film_actor.actor_id = actor.id " + " WHERE film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int actorId = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				Actor actor = new Actor(actorId, firstName, lastName);
				actors.add(actor);

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;
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
				rs.getInt("language_id"), rs.getInt("rental_duration"), rs.getDouble("rental_rate"),
				rs.getInt("length"), rs.getDouble("replacement_cost"), rs.getString("rating"),
				rs.getString("special_features"));

		return film;
	}

	@Override
	public int createFilm(Film film) {
		// TODO Auto-generated method stub
		return 0;
	}

}
