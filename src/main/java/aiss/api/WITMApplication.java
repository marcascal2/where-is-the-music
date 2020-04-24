package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.ArtistaResource;
import aiss.api.resources.CancionResource;
import aiss.api.resources.EventoResource;
import aiss.api.resources.LugarResource;
import aiss.api.resources.PrediccionResource;

public class WITMApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public WITMApplication() {
		singletons.add(ArtistaResource.getInstance());
		singletons.add(LugarResource.getInstance());
		singletons.add(EventoResource.getInstance());
		singletons.add(CancionResource.getInstance());
		singletons.add(PrediccionResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
