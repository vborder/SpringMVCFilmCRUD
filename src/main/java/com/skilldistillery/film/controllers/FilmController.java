package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	FilmDAO dao;

	// Homepage
	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView goHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/home.jsp");
		return mav;
	}

	// Results for Search by ID
	@RequestMapping(path = "findByID.do", params = "input", method = RequestMethod.GET)
	public ModelAndView getFilmByID(String input) {
		ModelAndView mav = new ModelAndView();
		try {
			int filmID = Integer.parseInt(input);
			Film film = null;

			if (filmID <= 1000) {
				film = dao.findFilmByID(filmID);
			} else {
				film = dao.findCreatedFilmsByID(filmID);
			}
			if (film != null) {
				mav.addObject("film", film);
				mav.setViewName("WEB-INF/result.jsp");
			} else
				mav.setViewName("WEB-INF/resultNotFound.jsp");
		} catch (Exception e) {
			mav.setViewName("WEB-INF/resultNotFound.jsp");
		}
		return mav;
	}

	// Results for Search by Keyword
	@RequestMapping(path = "findByKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(String keyword) throws SQLException {
		ModelAndView mav = new ModelAndView();
		List<Film> films = new ArrayList<>();

		films.addAll(dao.findFilmsByKeyword(keyword));
		films.addAll(dao.findCreatedFilmsByKeyword(keyword));
		if (films.size() > 0) {
			mav.addObject("filmList", films);
			mav.setViewName("WEB-INF/keywordResult.jsp");
		} else {
			mav.setViewName("WEB-INF/resultNotFound.jsp");

		}
		return mav;

	}

	// Redirect and FlashAttributes for Adding a Film
	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(Film film, RedirectAttributes redir) throws SQLException {
		ModelAndView mav = new ModelAndView();
		redir.addFlashAttribute("newFilm", film);
		film = dao.createFilm(film);
		mav.setViewName("redirect:filmAdded.do");

		return mav;
	}

	// Film added
	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmAdded(@ModelAttribute("newFilm") Film film) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("film", film);
		mav.setViewName("WEB-INF/result.jsp");

		return mav;
	}

	// ^^^^^^^^^^^^^^^^^^^^Note for Mike- don't touch anything above^^^^^^^^^^^^^^^^

	@RequestMapping(path = "editFilm.do", method = RequestMethod.GET)
	public ModelAndView editFilm(Film film) throws SQLException {
		ModelAndView mav = new ModelAndView();
		dao.updateFilm(film);
		mav.addObject("film", film);
		mav.setViewName("WEB-INF/result.jsp");
		return mav;

	}

//	
//	@RequestMapping(path="editedFilm.do", method= RequestMethod.POST)
//	public ModelAndView editedFilm(Film film) throws SQLException{
//		ModelAndView mav= new ModelAndView();
//		try {
//			dao.updateFilm(film);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mav.setViewName("WEB-INF/result.jsp");
//		
//		return mav;
//	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) throws SQLException {
		ModelAndView mav = new ModelAndView();
		try {
		Film film = dao.findCreatedFilmsByID(filmId);
		if (filmId > 1000) {
		boolean deleted = dao.deleteFilm(film);
		if (deleted) {
			mav.setViewName("WEB-INF/deleteSuccesful.jsp");
		}
		}
		else mav.setViewName("WEB-INF/deleteFailed.jsp");   
		
		}
		catch (Exception e) {
		
			mav.setViewName("WEB-INF/deleteFailed.jsp");
		}
		
		return mav;
	
	}
}
