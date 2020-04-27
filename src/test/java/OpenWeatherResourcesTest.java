import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import aiss.model.resource.OpenWeatherResource;

public class OpenWeatherResourcesTest {

	@Test
	public void testGetPredictions() throws UnsupportedEncodingException {
		OpenWeatherResource owr = new OpenWeatherResource();
		String lat = "37.40858";
		String lon = "-5.956843";
		LocalDate today = LocalDate.now();

		List<aiss.model.openWeather.List> res = owr.getDatosMeteorolicos(lat, lon);

		assertNotNull("The search returned null", res);
		assertFalse("The number of predictions is zero", res.size() == 0);

		List<aiss.model.openWeather.List> dia1 = owr.getPrediccionesPorDía(res, today.plusDays(1).toString());

		System.out.println("Las predicciones para el día " + today.plusDays(1).toString() + " son: \n");

		for (aiss.model.openWeather.List l : dia1) {
			System.out.println("Hora: " + l.getDtTxt() + "\n" + "Temp max: " + l.getMain().getTempMax()
					+ "ºC, Temp min: " + l.getMain().getTempMin() + "ºC" + "\n" + "Description: "
					+ l.getWeather().get(0).getDescription() + "\n");
			System.out.println("\n");
		}
	}
}
