<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.simpli.RailwayCrossing"%>
<%@ page import="com.simpli.RailwayCrossingDAO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Railway Crossings - Favorite Crossings</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
}

.container {
	border: 1px solid #ccc;
	border-radius: 10px;
	padding: 20px;
	margin-bottom: 20px;
	margin-top: 20px;
}

.container h3 {
	margin-top: 0;
}

.container p {
	margin: 0;
}

.status {
	display: inline-block;
	padding: 5px;
	color: white;
	font-weight: bold;
}

.status-open {
	background-color: green;
}

.status-closed {
	background-color: red;
}
</style>
</head>
<body>
	<h2>User Home Page</h2>

	<!-- Display All button -->
	<button onclick="location.href='userHome.jsp'">All Crossings</button>

	<!-- Favorite Crossings Container -->
	<div class="favorites">
		<%
		RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
		List<RailwayCrossing> favoriteCrossings = crossingDAO.getFavoriteCrossings();
		for (RailwayCrossing crossing : favoriteCrossings) {
			String status = crossing.getStatus();
			String statusClass = status.equalsIgnoreCase("Open") ? "status-open" : "status-closed";
		%>
		<div class="container">
			<h3><%=crossing.getName()%></h3>
			<p>
				Status: <strong><span class="status <%=statusClass%>"><%=status%></span></strong>
			</p>
			<p>
				Person in Charge: <strong><%=crossing.getPersonInCharge()%></strong>
			</p>
			<p>
				Train Schedules: <strong><%=crossing.getTrainSchedule()%></strong>
			</p>
			<p>
				Landmark: <strong><%=crossing.getLandmark()%></strong>
			</p>
			<p>
				Address: <strong><%=crossing.getAddress()%></strong>
			</p>
			<form action="removeFromFavorites" method="post"
				style="display: inline;">
				<input type="hidden" name="crossingId" value="<%=crossing.getId()%>">
				<button type="submit"
					style="border-radius: 10px; font-weight: bold; margin-top: 10px;">REMOVE
					FROM FAVORITES</button>
			</form>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>
