package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googlePlaces.PlaceDetails.Review;
import aiss.model.googlePlaces.PlaceSearch.Result;
import aiss.model.resource.GoogleMapsResource;
import aiss.model.resource.PlaceDetailsResource;


@SuppressWarnings("serial")
public class GoogleMapsGetPlacesController extends HttpServlet {
	private static final Logger log = Logger.getLogger(GoogleMapsGetPlacesController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GoogleMapsResource res = new GoogleMapsResource();
		List<Result> results = res.getLugares("Sala%20CUSTOM");
		String photo = results.get(0).getIcon();
		String placeId = results.get(0).getPlaceId();
		
		PlaceDetailsResource res2 = new PlaceDetailsResource();
		List<Review> reviews = res2.getDetails(placeId);
		List<String> autores = new ArrayList<>();
		List<String> texto = new ArrayList<>();
		List<Integer> valoraciones = new ArrayList<>();
		List<String> photos = new ArrayList<String>();
		
		for(Review r : reviews) {
			autores.add(r.getAuthorName());
			texto.add(r.getText());
			valoraciones.add(r.getRating());
			photos.add(r.getProfilePhotoUrl());
		}
			
			request.setAttribute("rating", valoraciones);
			request.setAttribute("photo", photo);
			request.setAttribute("autores", autores);
			request.setAttribute("texto", texto);
			
		
			request.getRequestDispatcher("/lugares.jsp").forward(request, response);
		 if(results.size()==0) {
			log.warning("No places available for this search");
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doGet(req, resp);
	}
	

}
