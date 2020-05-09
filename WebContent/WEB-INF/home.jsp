<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Database</title>
</head>
<body>

	<h3>Find film by ID</h3>
	<form action="findByID.do" method="GET">
		<input type="text" name="filmID" size="10" /> <input type="submit"
			value="Search" />
	</form>
	
	<h3>Find film by keyword</h3>
	<form action="findByKeyword.do" method="GET">
		<input type="text" name="keyword" size="10" /> <input type="submit"
			value="Search" />
	</form>

	<h3>Input new film</h3>
	<FORM action="addFilm.do" method="post">
		<P>
			<LABEL for="id">Film ID: </LABEL> <INPUT type="text" id="filmId"><BR>
			<LABEL for="title">Title: </LABEL> <INPUT type="text" id="title"><BR>
			<LABEL for="description">Description: </LABEL> <INPUT type="text"
				id="description"><BR> <LABEL for="release_year">Release
				year: </LABEL> <INPUT type="text" id="release_year"><BR> <LABEL
				for="language_id">Language numeric ID: </LABEL> <INPUT type="text"
				id="language_id"><BR> <LABEL for="rental_duration">Rental
				duration: </LABEL> <INPUT type="text" id="rental_duration"><BR>

			<LABEL for="rental_rate">Rental cost: </LABEL> <INPUT type="text"
				id="rental_rate"><BR> <LABEL for="length">Film
				Length: </LABEL> <INPUT type="text" id="length"><BR> <LABEL
				for="replacement_cost">Cost to replace: </LABEL> <INPUT type="text"
				id="replacement_cost"><BR> <LABEL for="rating">Movie
				rating: </LABEL> <INPUT type="text" id="rating"><BR> <LABEL
				for="special_features">Special features: </LABEL> <INPUT type="text"
				id="special_features"><BR> <INPUT type="submit"
				value="Send"> <INPUT type="reset">
		</P>
	</FORM>
</body>
</html>