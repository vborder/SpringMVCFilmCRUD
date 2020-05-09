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

 <c:forEach var="film" items="${filmList }">
	Film id - ${film.id } <br>
	
	Film Title -  ${film.title } <br>
	 
	 Film Description -  ${film.description } <br><br>
	  
	  
</c:forEach>

	<h2>Delete Film</h2>
	<LABEL for="id">Film ID: </LABEL>
	<form action="deleteID.do" method="POST">
		<input type="text" name="ID" size="10" /> <input type="submit"
			value="Delete" />
	</form>

	<h2>Edit Film</h2>
	<h5>Enter the film ID you would like to edit</h5>
	<form action="findByID.do" method="GET">
		<input type="text" name="filmID" size="10" /> <input type="submit"
			value="Search" />
	</form>
</body>
</html>