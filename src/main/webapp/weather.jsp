<%@include file="includes/header.jsp"%>
<%@ page language="java"%>
<%@page import="aiss.controller.WeatherPageController"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WhereIsTheMusic</title>
<link rel="icon" type="image/vnd.microsoft.icon"
	href="assets/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- Canonical SEO -->
<link rel="canonical"
	href="https://www.creative-tim.com/product/material-kit-pro">

</head>
<body>
	<div class="page-header header-filter"
		data-parallax="true"></div>

	<div>
		<div id="carouselExampleCaptions" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleCaptions" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" style="padding: 5%">
				<c:forEach items="${predicciones1}" var="prediccion1">
					<div class="carousel-item active">
						<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
						<div class="carousel-caption d-none d-md-block"
							id="event-prediction">
							<h5>${prediccion1.dtTxt}</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
				</c:forEach>
			</div>

			<a class="carousel-control-prev" href="#carouselExampleCaptions"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
</body>