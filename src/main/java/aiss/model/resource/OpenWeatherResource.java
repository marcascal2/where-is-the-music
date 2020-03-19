package aiss.model.resource;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.openWeather.List;
import aiss.model.openWeather.OpenWeatherReponse;

public class OpenWeatherResource {

	private static final Logger log = Logger.getLogger(OpenWeatherResource.class.getName());

	private static final String API_KEY_OPENWEATHER = "052d59cfc337012130bbea4e45dacd8a";
	private static final String URI = "api.openweathermap.org/data/2.5/forecast";

	public List getDatosMeteorolicos(String lat, String lon){
		String url = URI + "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY_OPENWEATHER;
		log.warning(url);
		ClientResource cr = new ClientResource(url);
		try {
			OpenWeatherReponse owr = cr.get(OpenWeatherReponse.class);
			List l = owr.getList().get(0);
			return l;
		}catch (ResourceException e){
			log.warning("Error al tratar de acceder a la búsqueda: " + e.getMessage());
			return null;
		}
	}
}

