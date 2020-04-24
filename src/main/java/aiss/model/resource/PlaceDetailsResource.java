package aiss.model.resource;

import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.googlePlaces.PlaceDetails.PlaceDetailsResponse;
import aiss.model.googlePlaces.PlaceDetails.Review;

public class PlaceDetailsResource {
	
	private static final Logger log = Logger.getLogger(PlaceDetailsResource.class.getName());
	private final String api_key = "AIzaSyB8b77a1_Vpcyg77ZbL-jdRjqvqXQ4fHRA";
	private final String baseUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";
	
	public PlaceDetailsResource() {
		
	}
	
	public List<Review> getDetails(String placeId){
		String url = baseUrl + placeId + "&fields=reviews,name,rating,formatted_phone_number"+ "&key=" + api_key +"&language=es";
		ClientResource c = new ClientResource(url);
		try {
			PlaceDetailsResponse lista = c.get(PlaceDetailsResponse.class);
			return lista.getResultDetails().getReviews();
		} catch(ResourceException e) {
			log.warning("Error al tratar de acceder a los eventos: " + e.getMessage());
			return null;
		}
	}

}
