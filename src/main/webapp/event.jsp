<%@page import="aiss.model.ticketmaster.Attraction"%>
<%@page import="aiss.model.googlePlaces.PlaceDetails.Review"%>
<%@include file="includes/header.jsp"%>

<script>
var eventoAñadido = <%=request.getAttribute("eventoAñadido")%>;
if(eventoAñadido) {
	window.alert("El evento se ha añadido correctamente a tu calendario");
}
</script>

<div class="event-information">
	<h1 class="event-title-h1">
		<c:out value="${nombre}" />
	</h1>
	<img src='<c:out value="${imagen}"/>' class="event-information-cover">
	<h2 style="margin-bottom: 2%; margin-top: 2%; padding-left: 5%;">Artistas
		que participan en el evento</h2>
	<div class="event-information-content">
		<div class="event-information-left">
			<c:forEach items="${artistas}" var="artista">
				<div class="card artist-event-card" style="width: 18rem;">
					<img src="<c:out value="${artista.images.get(1).url}"/>"
						class="card-img-top" alt="...">
					<div class="artist-card-body">
						<h5 class="card-title">
							<c:out value="${artista.name}" />
						</h5>
						<label>Género: <c:out
								value="${artista.classifications.get(0).genre.name}" /></label> <label>Subgénero:
							<c:out value="${artista.classifications.get(0).subGenre.name}" />
						</label>

						<form method="GET" action="/ArtistPage">
							<input type="hidden" id="nombreArtista"
								name="nombreArtista" value="<c:out value="${artista.name}" />">
							<button class="btn btn-primary btn-information-artist"
								type="submit">Más información...</button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="event-information-right">
			<form action="/GoogleCalendarAddEvent" method="POST" class="card"
				style="width: 22rem;">
				<div class="card add-to-calendar-card" style="width: 22rem;">
					<div class="card-header">Añadir evento a mi calendario</div>
					<div class="add-to-calendar-card-content">
						<h5 class="card-title">
							<c:out value="${evento.name}" />
						</h5>
						<p>
							Fecha:
							<c:out value="${evento.dates.start.localDate}" />
						</p>
						<p>
							Hora:
							<c:out value="${evento.dates.start.localTime}" />
						</p>
						<input type="hidden" name="urlEvento" value="<c:out value="${evento.links.self.href}" />">
						<input type="text" name="calendarId"
							placeholder="Introduce tu correo de Google Calendar...">
						<input type="hidden" name="date"
							value="<c:out value="${evento.dates.start.localDate}" />">
						<input type="hidden" name="eventName"
							value="<c:out value="${evento.name}" />">
						<button class="btn btn-primary btn-add-calendar" type="submit">Añadir</button>
					</div>
			</form>
		</div>
	</div>
</div>
<div class="comment-card">
	<div class="card">
		<div class="card-header">
			Valoraciones de
			<c:out value="${sala}" />
		</div>
		<c:forEach items="${reviews}" var="review">
			<div class="card">
				<div class="comments-card-body">
					<div class="comment-image">
						<img src='<c:out value="${review.profilePhotoUrl}"/>'>
					</div>

					<div class="comment-content">
						<h5 class="card-title">
							<c:out value="${review.authorName}" />
						</h5>
						<p class="card-text">
							<c:out value="${review.text}" />
						</p>
						<label> Valoración: </label>
						<c:forEach begin="1" end="${review.rating}">
							<i class="fas fa-star"></i>
						</c:forEach>
						<label> Publicado: </label> <label><c:out
								value="${review.relativeTimeDescription}" /></label>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</div>
<%@include file="includes/footer.jsp"%>