<%@include file="includes/header.jsp"%>
<%@ page language="java" %>
<%@page import="aiss.controller.ArtistPageController"%> 
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
     <link rel="canonical" href="https://www.creative-tim.com/product/material-kit-pro">     
        
</head>
<body>
        <div class="page-header header-filter background-foto" data-parallax="true"></div>
        <div class="main carta-artista">
            <!-- PERFIL DEL ARTISTA -->
                <div class="perfil">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6 ml-auto mr-auto">
                                <div class="profile">
                                    <div class="foto-artista">
                                        <img src="<c:out value="${image.url}" />" alt="Responsive image" alt="Circle Image" class="img-raised rounded-circle img-fluid">
                                    </div>
                                    <div class="name">
                                        <h1 class="title"><c:out value="${item.name}" /></h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="descripcion-artista">
                            <h4><b>G&eacuteneros: </b><c:out value="${item.genres}" /></h4>
                            <h4><b>Popularidad: </b><c:out value="${item.popularity}" /></h4>
                        </div>
                        <!-- VIDEOS DEL ARTISTA -->
                        <nav class="d-flex align-items-center shadow p-3 rounded" id="nav1" style=" border-radius: 4px;">
                                <img src="assets/youtube2.png" width="30" height="30" class="d-inline-block align-top nav-image" alt="">
                                <p class="nav-tittle">
                                V&iacutedeos
                            </p>
                        </nav>
                        <div class="row">
                                <div class="top-videos" >
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <iframe class="embed-responsive-item video" src="https://www.youtube.com/embed/<c:out value="${id1}" />" 
                                            frameborder="0"
                                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                            allowfullscreen>
                                        </iframe>
                                    </div>
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <iframe class="embed-responsive-item video" src="https://www.youtube.com/embed/<c:out value="${id2}" />" 
                                            frameborder="0"
                                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                            allowfullscreen>
                                        </iframe>
                                    </div>										
                            </div>
                        </div>
                        <!-- CANCIONES DEL ARTISTA -->
                        <nav class="d-flex align-items-center shadow p-3 rounded" id="nav2" style=" border-radius: 4px;">
                                    <img src="assets/spotify.png" width="30" height="30" class="d-inline-block align-top nav-image" alt="">
                                    <p class="nav-tittle">
                                    Canciones
                                </p>
                        </nav>
                        <div class="row">
                            <div class="reproductores embed-responsive"> 
                                 
                                <c:forEach items="${tracks}" var="track" begin="0" end="3">
                                    <div class="embed-responsive" style="height: 100%;">
                                        <iframe class="embed-responsive-item reproductor" src="https://open.spotify.com/embed/track/<c:out value="${track.id}" />"
                                                width="300px" height="350px"></iframe></div>
                                </c:forEach>
                        </div>
                    </div>
                    </div>
                </div>
        </div>    
</body>
<%@include file="includes/footer.jsp"%>
</html>