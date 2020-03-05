import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.junit.Test;

import aiss.model.googleCalendar.GoogleCalendarEvent;
import aiss.model.googleCalendar.GoogleCalendarResponse;
import aiss.model.resource.GoogleCalendarResource;

public class GoogleCalendarTest {
	
	
	public void testAddEvent() throws UnsupportedEncodingException {
		GoogleCalendarEvent evento = new GoogleCalendarEvent();
		evento.setCalendarId("moisescalzado1227@gmail.com");
		evento.setSummary("GUASA!");

				
		GoogleCalendarResource consulta = new GoogleCalendarResource(null);

		GoogleCalendarResponse resp = consulta.addEvent(evento);
		
		assertNotNull("The search returned null", evento);
		assertNotNull("The number of places is zero", resp.getStatus());
		
		System.out.println("El evento se añadió completamente" + evento);
	}
}
