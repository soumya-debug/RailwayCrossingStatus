<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Crossing</title>
</head>

<body>
	<h1>Search Crossing</h1>

	<form action="searchCrossing" method="post">
		<label for="searchId">Search ID:</label> <input type="number"
			id="searchId" name="searchId" required> <input type="submit"
			value="Search">
	</form>

	<c:if test="${not empty crossing}">
		<h2>Search Result</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Landmark</th>
				<th>Train Schedule</th>
				<th>Person in Charge</th>
				<th>Status</th>
			</tr>
			<tr>
				<td>${crossing.id}</td>
				<td>${crossing.name}</td>
				<td>${crossing.address}</td>
				<td>${crossing.landmark}</td>
				<td>${crossing.trainSchedule}</td>
				<td>${crossing.personInCharge}</td>
				<td>${crossing.status}</td>
			</tr>
		</table>
	</c:if>

	<a href="adminHome.jsp">Back to Admin Homepage</a>
</body>
</html>
