package aiss.model.resource;

import java.util.logging.Logger;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.googleCalendar.GoogleCalendarEvent;
import aiss.model.googleCalendar.GoogleCalendarResponse;

public class GoogleCalendarResource {
	private static final Logger log = Logger.getLogger(GoogleCalendarResource.class.getName());
	private final String baseUrl = "https://www.googleapis.com/calendar/v3/calendars/";
    private final String access_token;
	
	public GoogleCalendarResource(String access_token) {
        this.access_token = access_token;
	}
	
	
	public GoogleCalendarResponse addEvent(GoogleCalendarEvent evento){
		String url = baseUrl + evento.getCalendarId() + "/events" + "?access_token=" + access_token;
		ClientResource cr = new ClientResource(url);
		try {
			cr.setEntityBuffering(true);
			GoogleCalendarResponse resp = cr.post(evento, GoogleCalendarResponse.class);
			return resp;
		} catch(ResourceException e) {
			log.warning("Error al tratar de añadir el evento: " + e.getMessage());
			return null;
		}
	}

}
