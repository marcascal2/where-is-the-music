package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.TicketmasterResource;
import aiss.model.ticketmaster.Embedded;
import aiss.model.ticketmaster.Event;

@SuppressWarnings("serial")
public class TicketmasterEventsGetController extends HttpServlet {

	private static final Logger log = Logger.getLogger(TicketmasterEventsGetController.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			TicketmasterResource tckResource = new TicketmasterResource();
			Embedded respuesta = new Embedded();
			String param = req.getParameter("citySearch");
			param = param.toLowerCase();
			if (param.isEmpty() || param == null) {
				respuesta = tckResource.getEvents();
			} else {
				log.warning(param);
				respuesta = tckResource.getEventsOfCity(param);
			}
			List<Event> eventos = new ArrayList<Event>();

			if (respuesta != null) {
				for (Event v : respuesta.getEvents()) {
					if (v.getEmbedded().getVenues().get(0).getLocation() != null && v.getName() != null) {
						log.warning("Este es el evento: " + v.getName());
						eventos.add(v);
					}
				}
			}

			req.setAttribute("events", eventos);
			req.getRequestDispatcher("/eventsMap.jsp").forward(req, resp);
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
