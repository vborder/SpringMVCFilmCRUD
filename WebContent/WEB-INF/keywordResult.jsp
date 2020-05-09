<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
	<h2>Film Details</h2>

 <c:forEach var="film" items="${films }">
	${film.id } ${film.title } ${film.description } ${film.releaseYear }
	${film.languageId } ${film.rentalDuration } ${film.rentalRate }
	${film.length } ${film.replacementCost } ${film.rating }
	${film.specialFeatures }
</c:forEach>

	<h2>Delete Film</h2>
	<LABEL for="id">Film ID: </LABEL>
	<form action="deleteID.do" method="POST">
		<input type="text" name="ID" size="10" /> <input type="submit"
			value="Delete" />
	</form>

	<h2>Edit Film</h2>
	<h5>Enter any fields you would like to update</h5>
	<FORM action="EditFilm.do" method="post">
		<P>
			<LABEL for="id">Film ID ${film.id } </LABEL> <BR> <LABEL
				for="title">Title ${film.title } </LABEL> <INPUT type="text"
				id="title"><BR> <LABEL for="description">Description
				${film.description } </LABEL> <INPUT type="text" id="description"><BR>
			<LABEL for="releaseYear">Release year ${film.releaseYear } </LABEL> <INPUT
				type="text" id="releaseYear"><BR> <LABEL
				for="languageId">Language numeric ID ${film.languageId } </LABEL> <INPUT
				type="text" id="languageId"><BR> <LABEL
				for="rentalDuration">Rental duration ${film.rentalDuration }
			</LABEL> <INPUT type="text" id="rentalDuration"><BR> <LABEL
				for="rentalRate">Rental cost ${filmRental_rate } </LABEL> <INPUT
				type="text" id="rentalRate"><BR> <LABEL for="length">Film
				Length ${film.length } </LABEL> <INPUT type="text" id="length"><BR>
			<LABEL for="replacementCost">Cost to replace
				${film.replacementCost } </LABEL> <INPUT type="text" id="replacementCost"><BR>
			<LABEL for="rating">Movie rating ${film.rating } </LABEL> <INPUT
				type="text" id="rating"><BR> <LABEL
				for="specialFeatures">Special features {film.specialFeatures
			</LABEL> <INPUT type="text" id="specialFeatures"><BR> <INPUT
				type="submit" value="Send"> <INPUT type="reset">
		</P>
	</FORM>
</body>
</html>