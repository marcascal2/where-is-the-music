<%@include file="includes/header.jsp"%>
<%@ page language="java" %>
<%@page import="aiss.controller.ArtistPageController"%> 
<%@page import="java.util.ArrayList"%> 
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WhereIsTheMusic</title>
    <link rel="icon" type="image/vnd.microsoft.icon"
    href="assets/favicon.ico">  
            <meta charset="utf-8">
            <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <!-- Favicons -->
            <link rel="apple-touch-icon" href="../assets/img/kit/free/apple-icon.png">
            <link rel="icon" href="../assets/img/kit/free/favicon.png">
            <!-- Extra details for Live View on GitHub Pages -->
            <!-- Canonical SEO -->
            <link rel="canonical" href="https://www.creative-tim.com/product/material-kit-pro">
            <!--  Social tags      -->
            <meta name="keywords" content="creative tim, html kit, html css template, web template, bootstrap, css3 template, frontend, responsive bootstrap template, bootstrap 4 ui kit, premium bootstrap kit, responsive ui kit">
            <meta name="description" content="Start Your Development With A Badass Bootstrap 4 UI Kit inspired by Material Design.">
            <!-- Schema.org markup for Google+ -->
            <meta itemprop="name" content="Material Kit PRO by Creative Tim">
            <meta itemprop="description" content="Start Your Development With A Badass Bootstrap 4 UI Kit inspired by Material Design.">
            <meta itemprop="image" content="https://s3.amazonaws.com/creativetim_bucket/products/46/original/opt_mkp_thumbnail.jpg">
            <!-- Twitter Card data -->
            <meta name="twitter:card" content="product">
            <meta name="twitter:site" content="@creativetim">
            <meta name="twitter:title" content="Material Kit PRO by Creative Tim">
            <meta name="twitter:description" content="Start Your Development With A Badass Bootstrap 4 UI Kit inspired by Material Design.">
            <meta name="twitter:creator" content="@creativetim">
            <meta name="twitter:image" content="https://s3.amazonaws.com/creativetim_bucket/products/46/original/opt_mkp_thumbnail.jpg">
            <meta name="twitter:data1" content="Material Kit PRO by Creative Tim">
            <meta name="twitter:label1" content="Product Type">
            <meta name="twitter:data2" content="$79">
            <meta name="twitter:label2" content="Price">
            <!-- Open Graph data -->
            <meta property="fb:app_id" content="655968634437471">
            <meta property="og:title" content="Material Kit PRO by Creative Tim">
            <meta property="og:type" content="article">
            <meta property="og:url" content="https://demos.creative-tim.com/material-kit-pro/presentation.html">
            <meta property="og:image" content="https://s3.amazonaws.com/creativetim_bucket/products/46/original/opt_mkp_thumbnail.jpg">
            <meta property="og:description" content="Start Your Development With A Badass Bootstrap 4 UI Kit inspired by Material Design.">
            <meta property="og:site_name" content="Creative Tim">
            <!--     Fonts and icons     -->
            <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
            <link rel="stylesheet" href="../assets/css/material-kit.min.css?v=2.0.2">
            <!-- Documentation extras -->
            <!-- CSS Just for demo purpose, don't include it in your project -->
            <link href="../assets/assets-for-demo/demo.css" rel="stylesheet">
            <link href="../assets/assets-for-demo/vertical-nav.css" rel="stylesheet">
                  
</head>
<body>
<div class="page-header header-filter background-foto" data-parallax="true"></div>
<div class="main carta-artista">
        <div class="perfil">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 ml-auto mr-auto">
                        <div class="profile">
                            <div class="foto-artista">
                                <img src="<c:out value="${image.url}" />" alt="Circle Image" class="img-raised rounded-circle img-fluid">
                            </div>
                            <div class="name">
                                <h3 class="title"><c:out value="${item.name}" /></h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="descripcion-artista">
                    <h6><b>Genres: </b><c:out value="${item.genres}" /></h6>
                    <h6><b>Popularity: </b><c:out value="${item.popularity}" /></h6>
                </div>
                <div class="row">
                    <div class="col-md-6 ml-auto mr-auto">
                        <div class="top-videos">
                            <div class="d-flex justify-content-around video">
                                <iframe src="https://www.youtube.com/embed/<c:out value="${id1}" />" 
                                    frameborder="0"
                                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                    allowfullscreen>
                                </iframe>
                            </div>
                            <div class="d-flex justify-content-around video">
                                <iframe src="https://www.youtube.com/embed/<c:out value="${id2}" />" 
                                    frameborder="0"
                                    allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                    allowfullscreen>
                                </iframe>
                            </div>										
                        </div>
                    </div>
                </div>
                <div class="reproductores">
                    <div class="reproductores-fila">       
                        <c:forEach items="${tracks}" var="track" begin="0" end="1">
                            <div class="reproductor">
                                <iframe src="https://open.spotify.com/embed/track/<c:out value="${track.id}" />"></iframe></div>
                        </c:forEach>
                    </div>
                    <div class="reproductores-fila">
                        <c:forEach items="${tracks}" var="track" begin="2" end="3">
                            <div class="reproductor">
                            <iframe src="https://open.spotify.com/embed/track/<c:out value="${track.id}" />"></iframe></div>
                        </c:forEach>
                    </div>
                </div>
            </div>   
        </div>
    </div>
</div>
</body>
</html>