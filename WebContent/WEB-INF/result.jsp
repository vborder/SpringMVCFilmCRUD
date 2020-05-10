<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<title>Search Result</title>
</head>
<body style="background-color:#b3e0ff">
    <div class="w-auto p-3"  >
    <a href="http://localhost:8080/MVCFilmSite/" > Click here to go back home </a >
    <br><br>
  <h2>  <span class="badge badge-primary">Film Details</span></h2>
	

<p class="text-black">
Film ID -	${film.id }<br>
Title -	 ${film.title }<br>
Description -	  ${film.description }<br>
Release Year -	   ${film.releaseYear }<br>
Language ID -	${film.languageId }<br>
Rental Duration -	 ${film.rentalDuration } day(s)<br>
Rental Cost -	  $${film.rentalRate }<br>
Length -	${film.length } minutes<br>
Replacement Cost -	 $${film.replacementCost }<br>
Rating -	  ${film.rating }<br>
Special Features -	${film.specialFeatures }<br>
</p>
<br><br>
	<h2>  <span class="badge badge-danger">Delete Film By ID</span></h2>
	
	<div class="text-white">

	<form action="deleteID.do" method="POST">
		<input type="text" placeholder="Enter film ID to delete" name="ID" size="20" /> <input type="submit"
			value="Delete" />
	</form>
	</div>
	
<br><br>
<h2>  <span class="badge badge-success">Edit Film</span></h2>
	</em>
	<div class="form-group">
   
	<FORM action="editFilm.do" method="GET">


		
			<LABEL for="id">Film ID -  </LABEL><INPUT type="text"
				id="title" value="${film.id }" name="id" readonly> <BR>
			
			 <LABEL
				for="title">Title -  </LABEL> <INPUT type="text"
				id="title" value="${film.title }" name="title"><BR>
				
				 <LABEL for="description">Description - 
				 </LABEL> <INPUT type="text" id="description" value="${film.description }" name="description"><BR>
				
				
			<LABEL for="releaseYear">Release year -  </LABEL> <INPUT
				type="text" id="releaseYear" value="${film.releaseYear }" name="releaseYear"><BR> 
				
			
				
				 <LABEL
				for="rentalDuration">Rental duration -  day
			</LABEL> <INPUT type="text" id="rentalDuration" value="${film.rentalDuration }" name="rentalDuration"><BR> 
			
			<LABEL
				for="rentalRate">Rental cost -  </LABEL> <INPUT
				type="text" id="rentalRate" value="${film.rentalRate }" name="replacementCost"><BR> 
				
				<LABEL for="length">Film
				Length -  minutes</LABEL> <INPUT type="text" id="length" value="${film.length }" name="length"><BR>
				
				
			<LABEL for="replacementCost">Cost to replace -
				 </LABEL> <INPUT type="text" id="replacementCost" value="${film.replacementCost }" name="replacementCost"><BR>
				
				
	
				
			
			
			<INPUT
				type="submit" value="Send"> <INPUT type="reset">
		

	</FORM>
	
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</div>
</body>
</html>