<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Новостной портал</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="d-flex flex-column min-vh-100">


	<!-- Header -->
	<header class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/Controller/home">NewsPortal</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarContent">
				<span class="navbar-toggler-icon"></span>
			</button>


			<div class="collapse navbar-collapse" id="navbarContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item me-2"><a class="btn btn-outline-light"
						href="NewsPortalController?command=page_auth">Войти</a></li>
					<li class="nav-item me-2"><a class="btn btn-warning"
						href="NewsPortalController?command=page_registration">Регистрация</a>
					</li>
					<li class="nav-item"><select
						class="form-select form-select-sm"
						onchange="location.href=this.value">
							<option value="/Controller/setLang?lang=ru">Русский</option>
							<option value="/Controller/setLang?lang=en">English</option>
							<option value="/Controller/setLang?lang=de">Deutsch</option>
					</select></li>
				</ul>
			</div>
		</div>
	</header>


	<!-- Main Content -->
	<main class="container my-5 flex-grow-1">
		<h1 class="mb-4">Последние новости</h1>
		<div class="row g-4">

			<c:forEach var="news" items="${requestScope.topNews}">
				<!-- News 1 -->
				<div class="col-md-4">
					<div class="card h-100 shadow-sm">
					    <img src="https://picsum.photos/400/200?random=1"
					   	 class="card-img-top" alt="news1">
						<div class="card-body">
							<h5 class="card-title">${news.title}</h5>
							<p class="card-text">${news.brief}</p>
							<a href="/Controller/newsDetails?id=1" class="btn btn-primary">Подробнее</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</main>


	<!-- Footer -->
	<footer class="bg-dark text-light py-3 mt-auto">
		<div class="container text-center">
			<p class="mb-0">&copy; 2025 NewsPortal. Все права защищены.</p>
			<a href="/Controller/about"
				class="text-decoration-none text-light me-3">О нас</a> <a
				href="/Controller/contact" class="text-decoration-none text-light">Контакты</a>
		</div>
	</footer>


	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>