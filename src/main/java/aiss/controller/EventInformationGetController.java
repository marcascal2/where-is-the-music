package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googlePlaces.PlaceDetails.Review;
import aiss.model.googlePlaces.PlaceSearch.Result;
import aiss.model.resource.GoogleMapsResource;
import aiss.model.resource.PlaceDetailsResource;
import aiss.model.resource.TicketmasterResource;
import aiss.model.ticketmaster.Event;

public class EventInformationGetController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoogleCalendarAddEventController.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//TicketMaster
		try {
			String nombreEvento = "";
			String urlImagen = "";
			String sala = "";
			String urlEvento = "";
			Boolean eventoAñadido = (Boolean) req.getAttribute("eventoAñadido");
			if (eventoAñadido == null) {
				eventoAñadido = false;
			}
			req.setAttribute("eventoAñadido", eventoAñadido);
			if (req.getAttribute("urlEvento") == null) {
				urlEvento = req.getParameter("urlEvento");
			} else {
				urlEvento = req.getAttribute("urlEvento").toString();
			}
			TicketmasterResource ticketmasterRes = new TicketmasterResource();
			Event evento = ticketmasterRes.getEventInformation(urlEvento);
			nombreEvento = evento.getName();
			urlImagen = evento.getImages().get(0).getUrl();
			sala = evento.getEmbedded().getVenues().get(0).getName();
			//GoogleMaps
			try {
				GoogleMapsResource googleRes = new GoogleMapsResource();
				List<Result> result = googleRes.getLugares(sala.replace(" ", "%20"));
				String placeId = result.get(0).getPlaceId();
				PlaceDetailsResource googleDetailsRes = new PlaceDetailsResource();
				List<Review> reviews = googleDetailsRes.getDetails(placeId);
				req.setAttribute("reviews", reviews);
			} catch (Exception e) {
				log.warning(e.getMessage());
			}

			req.setAttribute("imagen", urlImagen);
			req.setAttribute("nombre", nombreEvento);
			req.setAttribute("sala", sala);
			req.setAttribute("artistas", evento.getEmbedded().getAttractions());
			req.setAttribute("evento", evento);
			req.setAttribute("latitud", evento.getEmbedded().getVenues().get(0).getLocation().getLatitude());
			req.setAttribute("longitud", evento.getEmbedded().getVenues().get(0).getLocation().getLongitude());
			req.getRequestDispatcher("/event.jsp").forward(req, resp);
		} catch (Exception e) {
			log.warning(e.getMessage());
			req.getRequestDispatcher("/error.html").forward(req, resp);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}