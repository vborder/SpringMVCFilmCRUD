<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
	<h2>Film Details</h2>
	${Film.id Film.title } ${film.description } ${film.release_year }
	${film.language_id } ${film.rental_duration } ${film.rental_rate }
	${film.length } ${film.replacement_cost } ${film.rating }
	${film.special_features }

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
			<LABEL for="id">Film ID ${Film.id } </LABEL> <BR> <LABEL
				for="title">Title ${film.title } </LABEL> <INPUT type="text"
				id="title"><BR> <LABEL for="description">Description
				${film.description } </LABEL> <INPUT type="text" id="description"><BR>
			<LABEL for="release_year">Release year ${film.release_year }
			</LABEL> <INPUT type="text" id="release_year"><BR> <LABEL
				for="language_id">Language numeric ID ${film.language_id } </LABEL>
			<INPUT type="text" id="language_id"><BR> <LABEL
				for="rental_duration">Rental duration ${film.rental_duration }
			</LABEL> <INPUT type="text" id="rental_duration"><BR> <LABEL
				for="rental_rate">Rental cost ${film.rental_rate } </LABEL> <INPUT
				type="text" id="rental_rate"><BR> <LABEL for="length">Film
				Length ${film.length } </LABEL> <INPUT type="text" id="length"><BR>
			<LABEL for="replacement_cost">Cost to replace
				${film.replacement_cost } </LABEL> <INPUT type="text" id="replacement_cost"><BR>
			<LABEL for="rating">Movie rating ${film.rating } </LABEL> <INPUT
				type="text" id="rating"><BR> <LABEL
				for="special_features">Special features
				{film.special_features </LABEL> <INPUT type="text" id="special_features"><BR>
			<INPUT type="submit" value="Send"> <INPUT type="reset">
		</P>
	</FORM>
</body>
</html>