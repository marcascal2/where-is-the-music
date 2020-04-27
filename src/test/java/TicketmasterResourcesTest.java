import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resource.TicketmasterResource;
import aiss.model.ticketmaster.Embedded;
import aiss.model.ticketmaster.Event;
import aiss.model.ticketmaster.Venue;

public class TicketmasterResourcesTest {

	@Test
	public void getMoviesTest() throws UnsupportedEncodingException {
		TicketmasterResource consulta = new TicketmasterResource();
		Embedded lista = consulta.getEvents();
		
		assertNotNull("The search returned null", lista);
		assertNotNull("The search returned null", lista.getEvents());
		assertFalse("The number of events of " + lista + " is zero", lista.getEvents().size()==0);
		
		System.out.println("The search for " + lista + "'s events returned " + lista.getEvents().size() + " events.");
		
		System.out.println("Mostrando los resultados de buscar eventos en Sevilla: \n");
		
		Embedded lista2 = consulta.getEventsOfCity("Sevilla");
				
		for(Event evento: lista2.getEvents()) {
			System.out.println(evento.getName()+ ": Localización: ");
			for(Venue venue: evento.getEmbedded().getVenues()) {
				System.out.println(venue.getName() + " " + venue.getLocation().getLatitude() + " " + venue.getLocation().getLongitude());
			}
			System.out.println("\n");
			
		}
			
	}

}
