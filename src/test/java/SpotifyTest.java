import java.util.List;

import org.junit.Test;

import aiss.model.resource.SpotifyResource;
import aiss.model.spotify.Image;
import aiss.model.spotify.Artist;
import aiss.model.spotify.Track;

public class SpotifyTest {
	
	public void testSpotify() {
		SpotifyResource spotifyClient = new SpotifyResource();
		
		String id = spotifyClient.getIDArtist("eminem");
		List<Track> tracks = spotifyClient.getTopTracks(id).getTracks();
		Artist artist = spotifyClient.getArtist(id);
		Image image = artist.getImages().get(0);
		System.out.println("======= NOMBRE DEL ARTISTA =======");
		System.out.println(artist.getName());
		System.out.println("======= URL DE LA IMAGEN =======");
		System.out.println(image.getUrl());
		System.out.println("======= NOMBRE DE LOS TOP TRACKS =======");
		for (Track track : tracks) {
			System.out.println(track.getName());
		}
		
	}
}