import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.youtube.Id;
import aiss.model.resource.YoutubeResource;

public class YoutubeResourcesTest {

	@Test
	public void testGetSearch() throws UnsupportedEncodingException {
		String q = "Malu"; 
		YoutubeResource consulta = new YoutubeResource();
		List<Id> videos = consulta.getVideos(q);
		
		for(Id id: videos) {
			System.out.println(id.getVideoId());
		}
		
		assertNotNull("The search returned null", videos);
		assertFalse("The number of videos is zero", videos.size() == 0);
		
		// Show result
		System.out.println("The search for " + videos + "'s videos returned " + videos.size() + " movies.");
	}
	
}
