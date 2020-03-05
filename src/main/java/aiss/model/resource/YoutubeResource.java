package aiss.model.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.Id;
import aiss.model.youtube.Item;
import aiss.model.youtube.YoutubeResponse;

public class YoutubeResource {

	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());

	private static final String API_KEY_YOUTUBE = "AIzaSyD0V9ubgMOcyxTNrgTbleEEUAlQJSd2MFU";
	private static final String URI = "https://www.googleapis.com/youtube/v3/search";

	public List<Id> getVideos(String q) {
		if (q.contains(" ")) {
			String[] array = q.split(" ");
			q = array[0].trim() + "%20" + array[1].trim();
		}
		String url = URI + "?key=" + API_KEY_YOUTUBE + "&part=snippet&maxResults=6&q=" + q + "20%canciones";
		log.warning(url);
		ClientResource cr = new ClientResource(url);
		try {
			YoutubeResponse yr = cr.get(YoutubeResponse.class);
			List<Id> res = new ArrayList<Id>();
			for (Item i : yr.getItems()) {
				if(i.getId().getVideoId() != null) {
					res.add(i.getId());
				}
				
			}
			return res;
		} catch (ResourceException e) {
			log.warning("Error al tratar de acceder a la búsqueda: " + e.getMessage());
			return null;
		}

	}
	
}
