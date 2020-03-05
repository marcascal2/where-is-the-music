<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WhereIsTheMusic</title>
<link rel="icon" type="image/vnd.microsoft.icon"
	href="assets/favicon.ico">

<!-- Importo Bootstrap y JQuery -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<!-- Importo hojas de estilo -->
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen" />
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.4.0/dist/leaflet.css"
	integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
	crossorigin="" />


<!-- Importo mapa -->
<script src="https://unpkg.com/leaflet@1.4.0/dist/leaflet.js"
	integrity="sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg=="
	crossorigin=""></script>


<!-- Importo tipografías -->
<link href="https://fonts.googleapis.com/css?family=Concert+One"
	rel="stylesheet">

<style>
#map {
	height: 100%;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>


	<!-- HEADER -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light ">
		<a class="navbar-brand font-logo align-middle" href="./index.html"
			style="padding-top: initial"> <img src="./assets/icon.png"
			width="30" height="40" class="d-inline-block" alt=""> <span
			style="vertical-align: bottom"> Where Is The Music </span>
		</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.html">Inicio</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/TicketmasterEventsGet">Eventos</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="about.html">Sobre mí</a></li>
			</ul>
		</div>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>



	<h1 class="h1-WITM">¡Descubre tu próximo evento en
		Where Is The Music!</h1>

	<div id="mapid" class="mapa"></div>
	<script type="text/javascript">
		var map = L.map('mapid').setView([ 51.505, -0.09 ], 13);

		L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
						{
							attribution : '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
						}).addTo(map);
	</script>

	<div class="container">

		<c:forEach items="${events}" var="event">

			<script>
				L.marker([<c:out value="${event.getEmbedded().getVenues().get(0).getLocation().getLatitude()}"/>, <c:out value="${event.getEmbedded().getVenues().get(0).getLocation().getLongitude()}"/> ],  "zIndex: 2").addTo(map).bindPopup(
				'<h4><c:out value="${event.name}" /></h4> <p>Fecha: <c:out value="${event.dates.start.localDate}" /></p> <p>Hora: <c:out value="${event.dates.start.localTime}" /></p> <img class="popup-image" src="<c:out value="${event.images[0].url}"/>"> <form action="/EventInformationGet" method="POST"><input type="hidden" name="nombre" value="<c:out value="${event.name}" />"><input type="hidden" name="imagen" value="<c:out value="${event.images[0].url}" />"><input type="hidden" name="urlEvento" value="<c:out value="${event.links.self.href}" />"><input type="hidden" name="sala" value="<c:out value="${event.getEmbedded().getVenues().get(0).getName()}" />"><button class="btn btn-primary more-information-button" type="submit">Obtener más información</button></form>').openPopup();
				</script>

		</c:forEach>
		<div class="jumbotron how-to-use">
			<h4 class="display-4">¡Bienvenido a Where Is The Music!</h4>
			<p class="lead">Where Is The Music es la mejor manera de buscar tu próximo evento musical. El funcionamiento es sencillo, por lo
			que te será muy fácil encontrar los mejores conciertos y festivales cerca de ti.</p>
			<p class="lead">Para empezar a buscar eventos, basta con hacer click sobre los marcadores que hay en el mapa. En cada uno de ellos, podrás encontrar
			un botón que te redirigirá a una página para encontrar más información sobre el evento, comprar las entradas,
			o incluso agregarlo directamente a tu calendario.</p>
			<hr class="my-4">
			<p>¿Quieres saber cómo funciona Where Is The Music? En nuestra página principal podrás encontrar más información.</p>
			<a class="btn btn-primary btn-lg" href="index.html" role="button">Quiero saber más</a>
		</div>

	</div>
	<%@include file="includes/footer.jsp"%>