<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Railway Crossing Status</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<style>
body {
	background-image:
		url("https://source.unsplash.com/1000x1000/?nature,mountain");
	background-repeat: no-repeat;
	background-size: cover;
}

.navbar-brand span.quiz-text {
	color: red;
}

.navbar-nav.custom-ml-auto {
	margin-left: auto;
}

.navbar-nav.custom-ml-auto .nav-item {
	margin-left: 10px;
}
</style>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg bg-body-tertiary navbar-dark border-bottom border-bottom-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Railway Crossing Status</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav custom-ml-auto">
					<!-- Move the "Home", "Quiz", "Login/Signup" links to the right using custom CSS -->
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="adminLogin.jsp">Admin-Login/Signup</a></li>
					<li class="nav-item"><a class="nav-link" href="userLogin.jsp">User-Login/Signup</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>
