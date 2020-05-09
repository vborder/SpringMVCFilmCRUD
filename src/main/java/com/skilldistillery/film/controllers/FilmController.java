package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	FilmDAO dao;
	
	@RequestMapping(path ="home.do", method= RequestMethod.GET)
	public ModelAndView goHome() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("WEB-INF/home.jsp");
		return mav;
	}
}
