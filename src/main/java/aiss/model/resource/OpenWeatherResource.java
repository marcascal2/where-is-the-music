package aiss.model.resource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.openWeather.OpenWeatherResponse;

public class OpenWeatherResource {

	private static final Logger log = Logger.getLogger(OpenWeatherResource.class.getName());

	private static final String API_KEY_OPENWEATHER = "052d59cfc337012130bbea4e45dacd8a";
	private static final String URI = "https://api.openweathermap.org/data/2.5/forecast?lat=";

	public OpenWeatherResource() {
		
	}
	
	public List<aiss.model.openWeather.List> getDatosMeteorolicos(String lat, String lon){
		String url = URI + lat + "&lon=" + lon + "&appid=" + API_KEY_OPENWEATHER;
		ClientResource cr = new ClientResource(url);
		try {
			OpenWeatherResponse owr = cr.get(OpenWeatherResponse.class);
			System.out.println(owr.getCnt());
			List<aiss.model.openWeather.List> l = owr.getList();
			return l;
		}catch (ResourceException e){
			log.warning("Error al tratar de acceder a la búsqueda: " + e.getMessage());
			return null;
		}
	}
	
	public Map<String, aiss.model.openWeather.List> getPrediccionesPorDía(List<aiss.model.openWeather.List> lista){	
		Map<String, aiss.model.openWeather.List> map = lista.stream().collect(Collectors.toMap(aiss.model.openWeather.List::getDtTxt, l -> l));
		
		Map<String, aiss.model.openWeather.List> m = new TreeMap<>();
		
		Set<String> fechas = map.keySet();
		
		for(String f: fechas) {
			String dia = f.split(" ")[0];
			m.put(dia, map.get(f));
		}
		
		return m;
	}
}

