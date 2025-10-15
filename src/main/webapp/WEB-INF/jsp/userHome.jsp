<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<title>Личный кабинет</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light d-flex flex-column min-vh-100">

	<!-- HEADER -->
	<header class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/Controller/index">NewsPortal</a>
			<div class="ms-auto d-flex align-items-center">

				<!-- Приветствие через JSTL -->
				<span class="text-light me-3"> Привет, <c:choose>
						<c:when test="${not empty sessionScope.auth}">
                        ${sessionScope.auth.name}
                    </c:when>
						<c:otherwise>
                        Гость
                    </c:otherwise>
					</c:choose>
				</span> <a href="NewsPortalController?command=page_main"
					class="btn btn-outline-light me-2">Новости</a> <a
					href="NewsPortalController?command=page_auth"
					class="btn btn-outline-light">Выйти</a>
			</div>
		</div>
	</header>

	<!-- MAIN -->
	<main class="flex-fill container py-5">
		<!-- Приветствие -->
		<div class="card shadow-lg p-4 mb-5 text-center">
			<h1 class="h3 mb-3">Добро пожаловать на NewsPortal!</h1>
			<p class="mb-0">Вы успешно вошли в систему. Ниже представлены
				последние новости.</p>
		</div>

		<!-- Список новостей -->
		<div class="row g-4">

			<div class="col-md-6 col-lg-4">
				<div class="card h-100 shadow-sm">
					<img src="https://picsum.photos/400/200?random=1"
						class="card-img-top" alt="Новости технологий">
					<div class="card-body d-flex flex-column">
						<h5 class="card-title">Новости технологий</h5>
						<p class="card-text text-muted flex-grow-1">Новый
							искусственный интеллект уже умеет писать код лучше разработчиков.
						</p>
						<a href="#" class="btn btn-primary mt-auto">Читать дальше</a>
					</div>
					<div class="card-footer text-muted small">Опубликовано: 25
						сентября 2025</div>
				</div>
			</div>

			<div class="col-md-6 col-lg-4">
				<div class="card h-100 shadow-sm">
					<img src="https://picsum.photos/400/200?random=2"
						class="card-img-top" alt="Политика">
					<div class="card-body d-flex flex-column">
						<h5 class="card-title">Политика</h5>
						<p class="card-text text-muted flex-grow-1">В Европе обсуждают
							новый пакет экономических реформ.</p>
						<a href="#" class="btn btn-primary mt-auto">Читать дальше</a>
					</div>
					<div class="card-footer text-muted small">Опубликовано: 24
						сентября 2025</div>
				</div>
			</div>

			<div class="col-md-6 col-lg-4">
				<div class="card h-100 shadow-sm">
					<img src="https://picsum.photos/400/200?random=3"
						class="card-img-top" alt="Спорт">
					<div class="card-body d-flex flex-column">
						<h5 class="card-title">Спорт</h5>
						<p class="card-text text-muted flex-grow-1">Национальная
							сборная одержала уверенную победу в товарищеском матче.</p>
						<a href="#" class="btn btn-primary mt-auto">Читать дальше</a>
					</div>
					<div class="card-footer text-muted small">Опубликовано: 23
						сентября 2025</div>
				</div>
			</div>

		</div>
	</main>

	<!-- FOOTER -->
	<footer class="bg-dark text-light text-center py-3 mt-auto">
		&copy; 2025 NewsPortal. Все права защищены. </footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
