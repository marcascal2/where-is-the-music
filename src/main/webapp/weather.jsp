<%@include file="includes/header.jsp"%>
<%@ page language="java"%>
<%@page import="aiss.model.openWeather.List"%>
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
	<div class="predicciones" >
	<h1>¡Predicción para tu evento!</h1>
		<div class="predicciones-fila">

			<!-- PREDICCION DIA 2 -->

			<div id="carousel2" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carousel2" data-slide-to="0" class="active"></li>
					<c:if test="${masDeUno2}">
						<c:forEach items="${size2}" var="s2">
							<li data-target="#carousel2" data-slide-to="${s2}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${prediccion2.image}" class="d-block w-100 prediccion-img"
							alt="">
						<div class="carousel-caption d-none d-md-block prediccion-datos">
							<h4>${prediccion2.dtTxt}</h4>
							<h5>${prediccion2.weather[0].description}</h5>
							<p>Temp max: ${prediccion2.main.tempMax} ºC</p>
							<p>Temp min: ${prediccion2.main.tempMin} ºC</p>
							<p>Humidity: ${prediccion2.main.humidity}% , pressure:
								${prediccion2.main.pressure}hpa</p>
							<p>Wind: ${prediccion2.wind.speed}m/h</p>
						</div>
					</div>
					<c:if test="${masDeUno2}">
						<c:forEach items="${predicciones2}" var="pred2">
							<div class="carousel-item">
								<img src="${pred2.image}"
									class="d-block w-100 prediccion-img" alt="">
								<div class="carousel-caption d-none d-md-block prediccion-datos">
									<h4>${pred2.dtTxt}</h4>
									<h5>${pred2.weather[0].description}</h5>
									<p>Temp max: ${pred2.main.tempMax} ºC</p>
									<p>Temp min: ${pred2.main.tempMin} ºC</p>
									<p>Humidity: ${pred2.main.humidity}% , pressure:
										${pred2.main.pressure}hpa</p>
									<p>Wind: ${pred2.wind.speed}m/h</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>

				<a class="carousel-control-prev" href="#carousel2" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel2" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>


			<!-- PREDICCION DIA 3 -->

			<div id="carousel3" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carousel3" data-slide-to="0" class="active"></li>
					<c:if test="${masDeUno3}">
						<c:forEach items="${size3}" var="s3">
							<li data-target="#carousel3" data-slide-to="${s3}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${prediccion3.image}" class="d-block w-100 prediccion-img"
							alt="">
						<div class="carousel-caption d-none d-md-block prediccion-datos">
							<h4>${prediccion3.dtTxt}</h4>
							<h5>${prediccion3.weather[0].description}</h5>
							<p>Temp max: ${prediccion3.main.tempMax} ºC</p>
							<p>Temp min: ${prediccion3.main.tempMin} ºC</p>
							<p>Humidity: ${prediccion3.main.humidity}% , pressure:
								${prediccion3.main.pressure}hpa</p>
							<p>Wind: ${prediccion3.wind.speed}m/h</p>
						</div>
					</div>
					<c:if test="${masDeUno3}">
						<c:forEach items="${predicciones3}" var="pred3">
								<div class="carousel-item">
									<img src="${pred3.image}" class="d-block w-100 prediccion-img"
										alt="">
									<div
										class="carousel-caption d-none d-md-block prediccion-datos">
										<h4>${pred3.dtTxt}</h4>
										<h5>${pred3.weather[0].description}</h5>
										<p>Temp max: ${pred3.main.tempMax} ºC</p>
										<p>Temp min: ${pred3.main.tempMin} ºC</p>
										<p>Humidity: ${pred3.main.humidity}% , pressure:
											${pred3.main.pressure}hpa</p>
										<p>Wind: ${pred3.wind.speed}m/h</p>
									</div>
								</div>
						</c:forEach>
					</c:if>
				</div>

				<a class="carousel-control-prev" href="#carousel3" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel3" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>


		</div>

		<div class="predicciones-fila">


			<!-- PREDICCION DIA 4 -->

			<div id="carousel4" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carousel4" data-slide-to="0" class="active"></li>
					<c:if test="${masDeUno4}">
						<c:forEach items="${size4}" var="s4">
							<li data-target="#carousel4" data-slide-to="${s4}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${prediccion4.image}" class="d-block w-100 prediccion-img"
							alt="">
						<div class="carousel-caption d-none d-md-block prediccion-datos">
							<h4>${prediccion4.dtTxt}</h4>
							<h5>${prediccion4.weather[0].description}</h5>
							<p>Temp max: ${prediccion4.main.tempMax} ºC</p>
							<p>Temp min: ${prediccion4.main.tempMin} ºC</p>
							<p>Humidity: ${prediccion4.main.humidity}% , pressure:
								${prediccion4.main.pressure}hpa</p>
							<p>Wind: ${prediccion4.wind.speed}m/h</p>
						</div>
					</div>
					<c:if test="${masDeUno4}">
						<c:forEach items="${predicciones4}" var="pred4">
								<div class="carousel-item">
									<img src="${pred4.image}" class="d-block w-100 prediccion-img"
										alt="">
									<div
										class="carousel-caption d-none d-md-block prediccion-datos">
										<h4>${pred4.dtTxt}</h4>
										<h5>${pred4.weather[0].description}</h5>
										<p>Temp max: ${pred4.main.tempMax} ºC</p>
										<p>Temp min: ${pred4.main.tempMin} ºC</p>
										<p>Humidity: ${pred4.main.humidity}% , pressure:
											${pred4.main.pressure}hpa</p>
										<p>Wind: ${pred4.wind.speed}m/h</p>
									</div>
								</div>
						</c:forEach>
					</c:if>
				</div>

				<a class="carousel-control-prev" href="#carousel4" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel4" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>


			<!-- PREDICCION DIA 5 -->

			<div id="carousel5" class="carousel slide prediccion"
				data-ride="carousel" data-type="multi" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carousel5" data-slide-to="0" class="active"></li>
					<c:if test="${masDeUno5}">
						<c:forEach items="${size5}" var="s5">
							<li data-target="#carousel5" data-slide-to="${s5}"></li>
						</c:forEach>
					</c:if>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${prediccion5.image}" class="d-block w-100 prediccion-img"
							alt="">
						<div class="carousel-caption d-none d-md-block prediccion-datos">
							<h4>${prediccion5.dtTxt}</h4>
							<h5>${prediccion5.weather[0].description}</h5>
							<p>Temp max: ${prediccion5.main.tempMax} ºC</p>
							<p>Temp min: ${prediccion5.main.tempMin} ºC</p>
							<p>Humidity: ${prediccion5.main.humidity}% , pressure:
								${prediccion5.main.pressure}hpa</p>
							<p>Wind: ${prediccion5.wind.speed}m/h</p>
						</div>
					</div>
					<c:if test="${masDeUno5}">
						<c:forEach items="${predicciones5}" var="pred5">
								<div class="carousel-item">
									<img src="${pred5.image}" class="d-block w-100 prediccion-img"
										alt="">
									<div
										class="carousel-caption d-none d-md-block prediccion-datos">
										<h4>${pred5.dtTxt}</h4>
										<h5>${pred5.weather[0].description}</h5>
										<p>Temp max: ${pred5.main.tempMax} ºC</p>
										<p>Temp min: ${pred5.main.tempMin} ºC</p>
										<p>Humidity: ${pred5.main.humidity}% , pressure:
											${pred5.main.pressure}hpa</p>
										<p>Wind: ${pred5.wind.speed}m/h</p>
									</div>
								</div>
						</c:forEach>
					</c:if>
				</div>

				<a class="carousel-control-prev" href="#carousel5" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel5" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</body>