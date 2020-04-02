package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.SpotifyResource;
import aiss.model.resource.YoutubeResource;
import aiss.model.spotify.Artist;
import aiss.model.spotify.Image;
import aiss.model.spotify.Track;
import aiss.model.spotify.Tracks;
import aiss.model.youtube.Id;

public class ArtistPageController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SpotifyArtistsGetController.class.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
		String query = req.getParameter("nombreArtista");
		// Spotify
		SpotifyResource spotifyRes = new SpotifyResource();
		String id = spotifyRes.getIDArtist(query);
		Artist item = spotifyRes.getArtist(id);
		Image imageURL = spotifyRes.getArtist(id).getImages().get(0);
		Tracks tracks = spotifyRes.getTopTracks(id);
		List<Track> listTracks = tracks.getTracks();

		req.setAttribute("item", item);
		req.setAttribute("image", imageURL);
		req.setAttribute("tracks", listTracks);

		// Youtube
		YoutubeResource youtubeRes = new YoutubeResource();
		List<Id> ids = youtubeRes.getVideos(query);
		if(ids != null) {
			if (ids.size() > 1) {
				for (Id idY : ids) {
					if (idY.getVideoId() != null) {
						log.warning("Este es el video: " + idY.getVideoId());
					}
				}
			}
			String id1 = ids.get(0).getVideoId();
			String id2 = ids.get(1).getVideoId();
		
			req.setAttribute("id1", id1);
			req.setAttribute("id2", id2);
		}

		req.getRequestDispatcher("/ArtistPage.jsp").forward(req, resp);
		} catch (Exception e) {
			log.warning(e.getMessage());
			req.getRequestDispatcher("/error.html").forward(req, resp);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
	
}
