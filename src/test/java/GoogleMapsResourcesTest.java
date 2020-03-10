import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.googlePlaces.PlaceSearch.Result;
import aiss.model.resource.GoogleMapsResource;

public class GoogleMapsResourcesTest {
	
//	@Test
//	public void testGetPlaceSearch() throws UnsupportedEncodingException{
//		String q = "Sala%20CUSTOM";
//		GoogleMapsResource consulta = new GoogleMapsResource();
//		List<Result> lugares = consulta.getLugares(q);
//		for(Result r: lugares ) {
//			System.out.println(r.getFormattedAddress() + "--" + "Lat= " + r.getGeometry().getLocation().getLat()+ " Long= " + r.getGeometry().getLocation().getLng() + "--" + r.getRating() + " " + r.getPlaceId());
//		}
//		
//		
//		assertNotNull("The search returned null", lugares);
//		assertFalse("The number of places is zero", lugares.size() == 0);
//		
//		System.out.println("The search for " + lugares + " returned " + lugares.size() + " places.");
//	}
}
