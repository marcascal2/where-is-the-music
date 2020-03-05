package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.youtube.Id;
import aiss.model.resource.YoutubeResource;

public class YoutubeVideosGetController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(YoutubeVideosGetController.class.getName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = "Man%20down"; 
		YoutubeResource youtubeRes = new YoutubeResource();
		List<Id> ids = youtubeRes.getVideos(q);
		
		if(ids != null) {
	    	for(Id id: ids) {
	    		if(id.getVideoId()!=null) {
	    			log.warning("Este es el video: "+id.getVideoId());
	    		}
	    	}
    	}
		
		String id1 = ids.get(0).getVideoId();
		String id2 = ids.get(1).getVideoId();
		request.setAttribute("id1", id1);
		request.setAttribute("id2", id2);
    	request.getRequestDispatcher("/videoPlayer.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
	

}
