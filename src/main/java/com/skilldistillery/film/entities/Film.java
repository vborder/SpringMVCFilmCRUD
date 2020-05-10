package com.skilldistillery.film.entities;

import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private Integer languageId;
	private Integer rentalDuration;
	private double rentalRate;
	private Integer length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public Film() {

	}

//	public Film(String title2, String desc, int releaseYear2, int rentDur, double rate)
	/*
	 * This was previously empty. While the parameters were being used, they were never set to the objects fields.
	 */
	public Film(int filmId, String title2, String desc, int releaseYear2, int langId, int rentDur, double rate,
			int length2, double repCost, String rating2, String features) {
		this.id= filmId;
		this.title= title2;
		this.description= desc;
		this.releaseYear= releaseYear2;
		this.languageId= langId;
		this.rentalDuration= rentDur;
		this.rentalRate= rate;
		this.length= length2;
		this.replacementCost= repCost;
		this.rating= rating2;
		this.specialFeatures= features;
	}
	
	/*
	 * Overloading a Film constructor to create a Film without an ID... yet Our hardcoded setId() needs to be used or the id will be null/0;
	 * minimum constructor.
	 */
	public Film(String title, String description, int releaseYear, int languageID, int length, String rating) {
		super();
		this.title=title;
		this.description= description;
		this.releaseYear= releaseYear;
		this.languageId= languageID;
		this.length= length;
		this.rating= rating;
	}
	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String r = "Film id: " + id + "\n" + "Title: " + title + "\n" + "Description: " + description + "\n"
				+ "Release year: " + releaseYear + "\n" + "Language: " + language + "\n" + "\n";

//		for (Actor actor : actors) {
//			r += actor + "\n";
//		}

		return r;
	}
}
