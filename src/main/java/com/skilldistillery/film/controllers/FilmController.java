package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	FilmDAO dao;
	
	//Homepage
	@RequestMapping(path ="home.do", method= RequestMethod.GET)
	public ModelAndView goHome() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("WEB-INF/home.jsp");
		return mav;
	}
	
	//Results for Search by ID
	@RequestMapping(path="findByID.do", params="filmID", method= RequestMethod.GET)
	public ModelAndView getFilmByID(int filmID) {
		ModelAndView mav= new ModelAndView();
		Film film=null;
		
		if(filmID < 1000) {
			film= dao.findFilmByID(filmID);
		}
		else {
			film= dao.findCreatedFilmsByID(filmID);
		}
		mav.addObject("film", film);
		mav.setViewName("WEB-INF/result.jsp");
		
		
		return mav;
	}
	
	//Results for Search by Keyword
	@RequestMapping(path="findByKeyword.do", params="keyword", method= RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(String keyword) {
		ModelAndView mav= new ModelAndView();
		List<Film> films= new ArrayList<>();
		
		films.addAll(dao.findFilmsByKeyword(keyword));
		//films.addAll(dao.findCreatedFilmsByKeyword(keyword));
		
		mav.addObject("filmList", films);
		mav.setViewName("WEB-INF/result.jsp");
		
		return mav;
	}
	
	//Redirect and FlashAttributes for Adding a Film
	@RequestMapping(path="addFilm.do", method= RequestMethod.POST )
	public String creatFilm(Film film, RedirectAttributes redir){
		redir.addFlashAttribute("newFilm", film);
		film.setId(dao.createFilm(film));
		return "redirect:filmAdded.do";
	}
	
	//Film added
	@RequestMapping(path="filmAdded.do", method= RequestMethod.GET)
	public ModelAndView filmAdded(@ModelAttribute("newFilm") Film film) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("film", film);
		mav.setViewName("WEB-INF/result.jsp");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
