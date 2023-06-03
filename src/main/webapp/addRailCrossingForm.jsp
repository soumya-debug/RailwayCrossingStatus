<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Railway Crossing</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	text-align: center;
	background-color: #f2f2f2;
}

.panel {
	width: 500px;
	padding: 40px;
	background-color: #ffffff;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.panel label {
	display: block;
	margin-bottom: 10px;
	text-align: left;
}

.panel input[type="text"], .panel select {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.panel button[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.panel button[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="panel">
		<h2>Railway Crossings</h2>
		<h4>Add Railway Crossing Information</h4>
		<form action="addCrossing" method="post">
			<label for="name">Enter Name</label> <input type="text" id="name"
				name="name" required><br> <label for="address">Address</label>
			<input type="text" id="address" name="address" required><br>
			<label for="landmark">Landmark</label> <input type="text"
				id="landmark" name="landmark" required><br> <label
				for="trainSchedules">Train Schedules</label> <input type="text"
				id="trainSchedules" name="trainSchedules" required><br>
			<label for="personInCharge">Person in Charge</label> <input
				type="text" id="personInCharge" name="personInCharge" required><br>
			<label for="status">Crossing Status</label> <select id="status"
				name="status">
				<option value="Open">Open</option>
				<option value="Closed">Closed</option>
			</select><br>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
