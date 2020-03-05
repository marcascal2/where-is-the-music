package aiss.model.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.ticketmaster.Embedded;
import aiss.model.ticketmaster.Event;
import aiss.model.ticketmaster.TicketmasterResponse;

public class TicketmasterResource {

	private static final Logger log = Logger.getLogger(TicketmasterResource.class.getName());

	private static final String API_KEY_TICKETMASTER = "i3NeHI5O2pTPh3XoV3m1JmhANkedap21";
	private static final String URL_BASE = "https://app.ticketmaster.com/discovery/v2/";

	public Embedded getEvents() {
		String url = URL_BASE + "events.json?size=150&apikey=" + API_KEY_TICKETMASTER
				+ "&countryCode=es&segmentId=KZFzniwnSyZfZ7v7nJ";
		ClientResource cr = new ClientResource(url);
		try {
			TicketmasterResponse lista = cr.get(TicketmasterResponse.class);
			return lista.getEmbedded();
		} catch (ResourceException e) {
			log.warning("Error al tratar de acceder a los eventos: " + e.getMessage());
			return null;
		}

	}

	public Embedded getEventsOfCity(String ciudad) {
		String url = URL_BASE + "events.json?size=150&apikey=" + API_KEY_TICKETMASTER
				+ "&countryCode=es&segmentId=KZFzniwnSyZfZ7v7nJ" + "&city=" + ciudad;
		ClientResource cr = new ClientResource(url);
		try {
			TicketmasterResponse lista = cr.get(TicketmasterResponse.class);
			ajustaLocalizacion(lista.getEmbedded());
			return lista.getEmbedded();
		} catch (ResourceException e) {
			log.warning("Error al tratar de acceder a los eventos: " + e.getMessage());
			return null;
		}
	}

	public void ajustaLocalizacion(Embedded eventos) {
		Map<String, List<Double>> localizaciones = new HashMap<String, List<Double>>();
		Random r = new Random();
		for (Event v : eventos.getEvents()) {
				String lugar = v.getEmbedded().getVenues().get(0).getName();
				if (localizaciones.containsKey(lugar)) {
					Double randomValue = 0.0000 + (0.0005 - 0.0000) * r.nextDouble();
					Double nuevaLat = localizaciones.get(lugar).get(0) + randomValue;
					randomValue = 0.0000 + (0.0005 - 0.0000) * r.nextDouble();
					Double nuevaLong = localizaciones.get(lugar).get(1) + randomValue;
					List<Double> nuevasLocalizaciones = new ArrayList<Double>();
					nuevasLocalizaciones.add(nuevaLat);
					nuevasLocalizaciones.add(nuevaLong);
					localizaciones.replace(lugar, nuevasLocalizaciones);
					v.getEmbedded().getVenues().get(0).getLocation().setLatitude(nuevaLat.toString());
					v.getEmbedded().getVenues().get(0).getLocation().setLongitude(nuevaLong.toString());
				} else {
					Double lat = Double.parseDouble(v.getEmbedded().getVenues().get(0).getLocation().getLatitude());
					Double Long = Double.parseDouble(v.getEmbedded().getVenues().get(0).getLocation().getLongitude());
					Double randomValue = 0.0000 + (0.0005 - 0.0000) * r.nextDouble();
					Double nuevaLat = lat + randomValue;
					randomValue = 0.0000 + (0.0005 - 0.0000) * r.nextDouble();
					Double nuevaLong = Long + randomValue;
					List<Double> nuevasLocalizaciones = new ArrayList<Double>();
					nuevasLocalizaciones.add(nuevaLat);
					nuevasLocalizaciones.add(nuevaLong);
					localizaciones.put(lugar, nuevasLocalizaciones);
					v.getEmbedded().getVenues().get(0).getLocation().setLatitude(nuevaLat.toString());
					v.getEmbedded().getVenues().get(0).getLocation().setLongitude(nuevaLong.toString());
				}
			}
		}

	public Event getEventInformation(String urlEvento) {
		String url = "https://app.ticketmaster.com" + urlEvento + "&apikey=" + API_KEY_TICKETMASTER;
		log.warning(url);
		ClientResource cr = new ClientResource(url);
		try {
			Event res = cr.get(Event.class);
			return res;
		} catch (ResourceException e) {
			log.warning("Error al obtener información del evento con url " + urlEvento);
			return null;
		}
	}

}
