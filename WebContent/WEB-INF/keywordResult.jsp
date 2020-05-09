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
	 <h2>  <span class="badge badge-success">Film Details</span></h2>

 <c:forEach var="film" items="${filmList }">
	Film id - ${film.id } <br>
	
	Film Title -  ${film.title } <br>
	 
	 Film Description -  ${film.description } <br><br>
	  
	  
</c:forEach>

	 <h2>  <span class="badge badge-danger">Delete Film</span></h2>
	<LABEL for="id">Film ID: </LABEL>
	<form action="deleteID.do" method="POST">
		<input type="text" name="ID" size="20" placeholder="Enter ID to Delete"/> <input type="submit"
			value="Delete" />
	</form>
<br><br>
	 <h2>  <span class="badge badge-success">Edit Film</span></h2>
	<form action="findByID.do" method="GET">
		<input type="text" name="filmID" size="20" placeholder="Enter ID to Edit"/> <input type="submit"
			value="Search" />
	</form>
	<br><br><br>
</body>
</html>