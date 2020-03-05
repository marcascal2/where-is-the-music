<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="includes/header.jsp"%>
<div class=container>
	<p class="message">${message}</p>
	<table id="top-tracks">
		<tr>
			<td rowspan="4"><img src="<c:out value="${image.url}" />" width="75%" height="75%"/></td>
			<td colspan="2">
				<ul>Name:<c:out value="${item.name}" /></ul>
				<ul>Genres:<c:out value="${item.genres}" /></ul>
				<ul>Popularity:<c:out value="${item.popularity}" /></ul>
			</td>
		</tr>
		<tr>
			<c:forEach items="${tracks}" var="track" begin="0" end="1">
				<td><iframe
						src="https://open.spotify.com/embed/track/<c:out value="${track.id}" />"
						width="230" height="80"></iframe></td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${tracks}" var="track" begin="2" end="3">
				<td><iframe
						src="https://open.spotify.com/embed/track/<c:out value="${track.id}" />"
						width="230" height="80"></iframe></td>
			</c:forEach>
		</tr>
	</table>
</div>
<%@include file="includes/footer.jsp"%>