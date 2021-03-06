<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Keyword Search Result</title>
</head>
<body style="background-color:#b3e0ff">
 <a href="http://localhost:8080/MVCFilmSite/" > Click here to go back home </a >
 <br><br>
	 <h2>  <span class="badge badge-success">Matching Films</span></h2>

 <c:forEach var="film" items="${filmList }">
	<em>Film id</em> - ${film.id } <br>
	
	<em>Film Title</em> -  ${film.title } <br>
	 
	 <em>Film Description</em> -  ${film.description } <br><br>
	  
	  
</c:forEach>
<br>
	 <h2>  <span class="badge badge-danger">Delete Film</span></h2>
	
	<form action="deleteFilm.do" method="POST">
		<input type="number" name="filmId" size="20" placeholder="Enter ID to Delete"/> <input type="submit"
			value="Delete" />
	</form>
<br><br>
	 <h2>  <span class="badge badge-success">Full Details</span></h2>
	<form action="findByID.do" method="GET">
		<input type="number" name="input" size="20" placeholder="Enter desired ID"/> <input type="submit"
			value="Search" />
	</form>
	<br><br>
	 <a href="http://localhost:8080/MVCFilmSite/" > Click here to go back home </a ><br><br>
</body>
</html>