package aiss.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.OpenWeatherResource;

public class WeatherPageController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(WeatherPageController.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		//OpenWeather
		try {
			String lat = req.getParameter("latitud");
			String lon = req.getParameter("longitud");
			OpenWeatherResource weatherRes = new OpenWeatherResource();
			List<aiss.model.openWeather.List> res = weatherRes.getDatosMeteorolicos(lat, lon);
			LocalDate today = LocalDate.now();
						
			List<aiss.model.openWeather.List> p2 = weatherRes.getPrediccionesPorDía(res, today.plusDays(1).toString());
			List<aiss.model.openWeather.List> p3 = weatherRes.getPrediccionesPorDía(res, today.plusDays(2).toString());
			List<aiss.model.openWeather.List> p4 = weatherRes.getPrediccionesPorDía(res, today.plusDays(3).toString());
			List<aiss.model.openWeather.List> p5 = weatherRes.getPrediccionesPorDía(res, today.plusDays(4).toString());
						
			Boolean masDeUno2 = weatherRes.getNumeroPredicciones(p2).size() > 1;
			Boolean masDeUno3 = weatherRes.getNumeroPredicciones(p3).size() > 1;
			Boolean masDeUno4 = weatherRes.getNumeroPredicciones(p4).size() > 1;
			Boolean masDeUno5 = weatherRes.getNumeroPredicciones(p5).size() > 1;
			
			p2.forEach(x->x.setImage(getImagen(x.getWeather().get(0).getDescription())));
			req.setAttribute("prediccion2", p2.get(0));
			p2.remove(0);
			req.setAttribute("predicciones2", p2);
			req.setAttribute("size2", weatherRes.getNumeroPredicciones(p2));
			req.setAttribute("masDeUno2", masDeUno2);
			
			p3.forEach(x->x.setImage(getImagen(x.getWeather().get(0).getDescription())));
			req.setAttribute("prediccion3", p3.get(0));
			p3.remove(0);
			req.setAttribute("predicciones3", p3);
			req.setAttribute("size3", weatherRes.getNumeroPredicciones(p3));
			req.setAttribute("masDeUno3", masDeUno3);

			p4.forEach(x->x.setImage(getImagen(x.getWeather().get(0).getDescription())));
			req.setAttribute("prediccion4", p4.get(0));
			p4.remove(0);
			req.setAttribute("predicciones4", p4);
			req.setAttribute("size4", weatherRes.getNumeroPredicciones(p4));
			req.setAttribute("masDeUno4", masDeUno4);

			p5.forEach(x->x.setImage(getImagen(x.getWeather().get(0).getDescription())));
			req.setAttribute("prediccion5", p5.get(0));
			p5.remove(0);
			req.setAttribute("predicciones5", p5);
			req.setAttribute("size5", weatherRes.getNumeroPredicciones(p5));
			req.setAttribute("masDeUno5", masDeUno5);

			req.getRequestDispatcher("/weather.jsp").forward(req, resp);
		
		}catch (Exception e){
			log.warning(e.getMessage());
			req.getRequestDispatcher("/error.html").forward(req, resp);
		}
	}
	
	public String getImagen(String d) {
		String s= "assets/weather.jpg";
		if(d.contains("clouds")) {
			s= "assets/clouds.jpeg";
		}else if(d.contains("rain")) {
			s= "assets/rain.jpg";
		}else if(d.contains("sun")) {
			s= "assets/sunshine.jpg";
		}else if(d.contains("snow")) {
			s= "assets/snow.jpg";
		}
		return s;
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
