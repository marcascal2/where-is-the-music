package aiss.model.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
			List<aiss.model.openWeather.List> l = owr.getList();
			return l;
		}catch (ResourceException e){
			log.warning("Error al tratar de acceder a la búsqueda: " + e.getMessage());
			return null;
		}
	}
	
	public List<aiss.model.openWeather.List> getPrediccionesPorDía(List<aiss.model.openWeather.List> lista, String day){	
		List<aiss.model.openWeather.List> res = new ArrayList<aiss.model.openWeather.List>();
		res = lista.stream().filter(l -> l.getDtTxt().split(" ")[0].equals(day)).collect(Collectors.toList());
		return res;
	}
	
	public List<Integer> getNumeroPredicciones(List<aiss.model.openWeather.List> lista){
		List<Integer> res = new ArrayList<Integer>();
		if(lista.size()>1) {
			IntStream.range(1, lista.size()+1).forEach(i -> res.add(i));
		}
		return res;
	}
}

