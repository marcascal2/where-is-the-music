package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googleCalendar.EventDateTime;
import aiss.model.googleCalendar.GoogleCalendarEvent;
import aiss.model.resource.GoogleCalendarResource;

public class GoogleCalendarAddEventController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoogleCalendarAddEventController.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
		EventDateTime start = new EventDateTime(req.getParameter("date")+"T21:00:00-00:00");
		EventDateTime end = new EventDateTime(req.getParameter("date")+"T23:00:00-00:00");
		String name = req.getParameter("eventName");
		String calendarId = req.getParameter("calendarId");
		String urlEvento = req.getParameter("urlEvento");
		
		log.info(start.toString());

		if (accessToken != null && !"".equals(accessToken)) {
				GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
				GoogleCalendarEvent evento = new GoogleCalendarEvent(calendarId, start, end, name);
				gcResource.addEvent(evento);
				req.setAttribute("urlEvento", urlEvento);
				req.setAttribute("eventoAñadido", true);
				req.getRequestDispatcher("/EventInformationGet").forward(req, resp);
		} else {
			log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
