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
	
<!-- Importo FontAwesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">



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
		<div class="navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.html">Inicio</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/TicketmasterEventsGet?citySearch=">Eventos</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="about.html">Sobre nosotros</a></li>
			</ul>
		</div>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>