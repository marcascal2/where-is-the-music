package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.api.repository.MapWITMRepository;

@Path("/predictions")
public class PrediccionResource {
	private static PrediccionResource _instance = null;
	MapWITMRepository repository;
	
	private PrediccionResource() {
		repository = MapWITMRepository.getInstance();
	}

	public static PrediccionResource getInstance() {
		if (_instance == null) {
			_instance = new PrediccionResource();
		}
		return _instance;
	}
}
