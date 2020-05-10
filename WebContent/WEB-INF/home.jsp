<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Film Database</title>
</head>
<body style="background-color:#b3e0ff">

	  <h2>  <span class="badge badge-success">Find Film By ID</span></h2>
	<form action="findByID.do" method="GET">
		<input type="text" name="filmID" size="20" placeholder="Enter ID" /> <input type="submit"
			value="Search" />
	</form>
	<br><br>
	  <h2>  <span class="badge badge-success">Find Film By Keyword</span></h2>
	<form action="findByKeyword.do" method="GET">
		<input type="text" name="keyword" size="20" placeholder="Enter Keyword" /> <input type="submit"
			value="Search" />
	</form>
<br><br>
	  <h2>  <span class="badge badge-success">Input New Film</span></h2>
	<form action="addFilm.do" method="POST">
		<P>
			<LABEL for="id">Film ID: </LABEL> <INPUT type="text" id="filmId" placeholder="Enter ID"><BR>
			<LABEL for="title">Title: </LABEL> <INPUT type="text" id="title" placeholder="Enter Title"><BR>
			<LABEL for="description">Description: </LABEL> <INPUT type="text"
				id="description" placeholder="Enter Description"><BR> <LABEL for="release_year">Release
				year: </LABEL> <INPUT type="text" id="release_year" placeholder="Enter Release Year"><BR> <LABEL
				for="language_id">Language numeric ID: </LABEL> <INPUT type="text"
				id="language_id" placeholder="Enter Language ID"><BR> <LABEL for="rental_duration">Rental
				duration: </LABEL> <INPUT type="text" id="rental_duration" placeholder="Enter Rental Duration"><BR>

			<LABEL for="rental_rate">Rental cost: </LABEL> <INPUT type="text"
				id="rental_rate" placeholder="Enter Rental Rate"><BR> <LABEL for="length">Film
				Length: </LABEL> <INPUT type="text" id="length" placeholder="Enter Length"><BR> <LABEL
				for="replacement_cost">Cost to replace: </LABEL> <INPUT type="text"
				id="replacement_cost" placeholder="Enter Replacement Cost"><BR> <LABEL for="rating">Movie
				rating: </LABEL> <INPUT type="text" id="rating" placeholder="Enter Rating"><BR> <LABEL
				for="special_features">Special features: </LABEL> <INPUT type="text"
				id="special_features" placeholder="Enter Special Features"><BR> <INPUT type="submit"
				value="Send"> <INPUT type="reset">
		</P>
	</FORM>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>