package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Repository 
public class FilmDAOImpl implements FilmDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=MST";

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
		String sql = "SELECT film.*, language.name, category.name "
				+ "FROM film JOIN language ON film.language_id = language.id "
				+ "JOIN film_category ON film.id = film_category.film_id "
				+ "JOIN category ON film_category.category_id = category.id"
				+ "WHERE film.id = ? ";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, filmID);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("id"));
				film.setRentalDuration(rs.getInt("language_id"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActors(findActorsByFilmID(filmID));
				film.setCategory(rs.getString("category_name"));

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();

		String user = "student";
		String pass = "student";
		String sql = "SELECT film.*, name FROM film JOIN language ON film.language_id = language.id "
				+ "WHERE film.title LIKE ? OR film.description LIKE ?";

		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "%" + keyword + "%");
		st.setString(2, "%" + keyword + "%");

		ResultSet rs = st.executeQuery();

		try {
			while (rs.next()) {
				Film film = new Film();
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("id"));
				film.setRentalDuration(rs.getInt("language_id"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				films.add(film);

			}
			rs.close();
			st.close();
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
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("id"));
				film.setRentalDuration(rs.getInt("language_id"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findCreatedFilmsByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();

		String user = "student";
		String pass = "student";
		String sql = "SELECT film.*, name FROM film JOIN language ON film.language_id = language.id "
				+ "WHERE film.title LIKE ? OR film.description LIKE ?";

		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "%" + keyword + "%");
		st.setString(2, "%" + keyword + "%");

		ResultSet rs = st.executeQuery();

		try {
			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRating(rs.getString("rating"));
				film.setDescription(rs.getString("description"));
				film.setLanguage(rs.getString("name"));
				films.add(film);

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Actor findActorByID(int actorID) throws SQLException {
		Actor actor = null;

		String user = "student";
		String pass = "student";
		String sql = "SELECT actor.id, actor.first_name, actor.last_name, title FROM actor "
				+ "JOIN film_actor ON actor_id = actor.id" + "JOIN film on film_actor.film_id = film.id"
				+ "WHERE actor.id = ?";

		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorID);
		ResultSet actorResult = stmt.executeQuery();

		if (actorResult.next()) {
			actor = new Actor();
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
		}
		return actor;
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
					+ "JOIN actor on film_actor.actor_id = actor.id " + " WHERE film.id = ?";

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

	@Override
	public Film createFilm(Film film) throws SQLException {
		String user = "student";
		String pass = "student";

		// creating a copy of the film
		Film thisFilm = film;
		Connection conn = DriverManager.getConnection(url, user, pass);
		try {
		conn.setAutoCommit(false);
		String sql = "INSERT INTO film (film.title, film.description, film.release_year, film.language_id,"
				+ " film.rental_duration, film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, film.getTitle());
		st.setString(2, film.getDescription());
		st.setInt(3, film.getReleaseYear());
		st.setInt(4, 1);
		st.setInt(5, film.getRentalDuration());
		st.setDouble(6, film.getRentalRate());
		st.setInt(7, film.getLength());
		st.setDouble(8, film.getReplacementCost());
		st.setString(9, "G");
		st.setString(10, film.getSpecialFeatures());

		System.out.println(st);
		int updateCount = st.executeUpdate();

		if (updateCount == 1) {
			ResultSet keys = st.getGeneratedKeys();
			if (keys.next()) {
				int newFilmId = keys.getInt(1);
				film.setId(newFilmId);
			}
			
			keys.close();// close in scope
		}
		
		conn.commit();
		
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException sqle2) {
				System.err.println("Error trying to rollback");
			}
		}
		// throw new RuntimeException("Error inserting film " + film);
	}
	return thisFilm;
	
	}

	@Override
	public boolean updateFilm(Film film) throws SQLException {
		String user = "student";
		String pass = "student";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		try {
			conn.setAutoCommit(false);


			String sql = "UPDATE film SET title=?, description=?, release_year=?,"
					+ " rental_duration=?, rental_rate=?, length=?, replacement_cost=?"
					+ "WHERE id=?";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(8, film.getId());
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setInt(3, film.getReleaseYear());
			st.setInt(4, film.getRentalDuration());
			st.setDouble(5, film.getRentalRate());
			st.setInt(6, film.getLength());
			st.setDouble(7, film.getReplacementCost());

		//	st.setString(10, film.getRating());
		//	st.setString(11, film.getSpecialFeatures());

			int updateCount = st.executeUpdate();
			if (updateCount == 1) {

				st = conn.prepareStatement(sql);
				System.out.println("The film update was successful");
				conn.commit();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			System.out.println("The film update failed.");
			return false;

		}
//		System.out.println("The film " + film.getId() + " " + film.getTitle() + "was updated.");
		return true;
	}

	@Override
	public boolean deleteFilm(Film film) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);
		try {
			conn.setAutoCommit(false);
			String sql = "DELETE FROM film WHERE film.id =?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, film.getId());
			int updateCount = st.executeUpdate();
			sql = "DELETE FROM film WHERE film.id =?";
			st = conn.prepareStatement(sql);
			st.setInt(1, film.getId());
			updateCount = st.executeUpdate();
			conn.commit();

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			System.out.println("The film deletion failed.");
			return false;

		}
		System.out.println("The film " + film.getId() + " " + film.getTitle() + " was deleted.");
		return true;
	}
}
