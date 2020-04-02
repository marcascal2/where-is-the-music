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

	<div class="predicciones">
		<div class="predicciones-fila">

			<!-- PREDICCION DIA 1 -->

			<div id="carouselExampleCaptions" class="carousel slide prediccion"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<c:if test="${masDeUno1}">
						<c:forEach items="${size1}" var="s1">
							<li data-target="#carouselExampleCaptions" data-slide-to="${s1}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
						<div class="carousel-caption d-none d-md-block">
							<h5>${prediccion1.dtTxt}</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
					<c:if test="${masDeUno1}">
						<c:forEach items="${predicciones1}" var="pred1">
							<div class="carousel-item">
								<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
								<div class="carousel-caption d-none d-md-block">
									<h5>${pred1.dtTxt}</h5>
									<p>Nulla vitae elit libero, a pharetra augue mollis
										interdum.</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
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


			<!-- PREDICCION DIA 2 -->

			<div id="carouselExampleCaptions" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<c:if test="${masDeUno2}">
						<c:forEach items="${size2}" var="s2">
							<li data-target="#carouselExampleCaptions" data-slide-to="${s2}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
						<div class="carousel-caption d-none d-md-block">
							<h5>${prediccion2.dtTxt}</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
					<c:if test="${masDeUno2}">
						<c:forEach items="${predicciones2}" var="pred2">
							<div class="carousel-item">
								<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
								<div class="carousel-caption d-none d-md-block">
									<h5>${pred2.dtTxt}</h5>
									<p>Nulla vitae elit libero, a pharetra augue mollis
										interdum.</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
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

		<div class="predicciones-fila">

			<!-- PREDICCION DIA 3 -->

			<div id="carouselExampleCaptions" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<c:if test="${masDeUno3}">
						<c:forEach items="${size3}" var="s3">
							<li data-target="#carouselExampleCaptions" data-slide-to="${s3}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
						<div class="carousel-caption d-none d-md-block">
							<h5>${prediccion3.dtTxt}</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
					<c:if test="${masDeUno3}">
						<c:forEach items="${predicciones3}" var="pred3">
							<div class="carousel-item">
								<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
								<div class="carousel-caption d-none d-md-block">
									<h5>${pred3.dtTxt}</h5>
									<p>Nulla vitae elit libero, a pharetra augue mollis
										interdum.</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
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


			<!-- PREDICCION DIA 4 -->

			<div id="carouselExampleCaptions" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<c:if test="${masDeUno4}">
						<c:forEach items="${size4}" var="s4">
							<li data-target="#carouselExampleCaptions" data-slide-to="${s4}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
						<div class="carousel-caption d-none d-md-block">
							<h5>${prediccion4.dtTxt}</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
					<c:if test="${masDeUno4}">
						<c:forEach items="${predicciones4}" var="pred4">
							<div class="carousel-item">
								<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
								<div class="carousel-caption d-none d-md-block">
									<h5>${pred4.dtTxt}</h5>
									<p>Nulla vitae elit libero, a pharetra augue mollis
										interdum.</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
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


			<!-- PREDICCION DIA 5 -->

			<div id="carouselExampleCaptions" class="carousel slide prediccion"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleCaptions" data-slide-to="0"
						class="active"></li>
					<c:if test="${masDeUno5}">
						<c:forEach items="${size5}" var="s5">
							<li data-target="#carouselExampleCaptions" data-slide-to="${s5}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
						<div class="carousel-caption d-none d-md-block">
							<h5>${prediccion5.dtTxt}</h5>
							<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						</div>
					</div>
					<c:if test="${masDeUno5}">
						<c:forEach items="${predicciones5}" var="pred5">
							<div class="carousel-item">
								<img src="assets/fondo_tiempo.jpeg" class="d-block w-100" alt="">
								<div class="carousel-caption d-none d-md-block">
									<h5>${pred5.dtTxt}</h5>
									<p>Nulla vitae elit libero, a pharetra augue mollis
										interdum.</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
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
	</div>
</body>