package aiss.model.resource;

import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.googlePlaces.PlaceSearch.GoogleMapsResponse;
import aiss.model.googlePlaces.PlaceSearch.Result;

public class GoogleMapsResource {
	private static final Logger log = Logger.getLogger(GoogleMapsResource.class.getName());
	private final String api_key = "AIzaSyB8b77a1_Vpcyg77ZbL-jdRjqvqXQ4fHRA";
	private final String baseUrl = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
	
	public GoogleMapsResource() {
	}
	
	
	public List<Result> getLugares(String q){
		String url = baseUrl + q + "&key=" + api_key;
		ClientResource cr = new ClientResource(url);
		try {
			GoogleMapsResponse lista = cr.get(GoogleMapsResponse.class);
			return lista.getResults();
		} catch(ResourceException e) {
			log.warning("Error al tratar de acceder a los eventos: " + e.getMessage());
			return null;
		}
	}

}
