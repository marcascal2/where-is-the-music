<%@include file="includes/header.jsp"%>
<%@ page language="java" %>
<%@page import="aiss.controller.YoutubeVideosGetController"%> 
<%@page import="java.util.ArrayList"%> 

<h1>Artist's Top Videos</h1>
<div class=container>
	<table id="top-videos">
	            <tr>
	            	<td><iframe width="600" height="500"
						src="https://www.youtube.com/embed/<c:out value="${id1}" />" 
						frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen>
						</iframe>
						</td>
	                <td><iframe width="600" height="500"
						src="https://www.youtube.com/embed/<c:out value="${id2}" />" 
						frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen>
						</iframe>
						</td>										
	            </tr>
	</table>
</div>
<%@include file="includes/footer.jsp"%>