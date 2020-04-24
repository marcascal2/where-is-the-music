package aiss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.SpotifyResource;
import aiss.model.spotify.Image;
import aiss.model.spotify.Artist;
import aiss.model.spotify.Track;
import aiss.model.spotify.Tracks;

public class SpotifyArtistsGetController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		SpotifyResource spotifyRes = new SpotifyResource();
		String id = spotifyRes.getIDArtist(req.getParameter("nombreArtista"));
		Artist item = spotifyRes.getArtist(id);
		Image imageURL = spotifyRes.getArtist(id).getImages().get(0);
		Tracks tracks = spotifyRes.getTopTracks(id);
		List<Track> listTracks = tracks.getTracks();
		req.setAttribute("item", item);
		req.setAttribute("image", imageURL);
		req.setAttribute("tracks", listTracks);
		req.getRequestDispatcher("/spotifyTopTracks.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}