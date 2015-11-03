package org.rage.swarm.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.rage.swam.delegate.TrikitruDelegate;

@Path("/v1/")
public class SimpleRest {
	
	@Inject
	private TrikitruDelegate delegate;

	@Path("test")
	@GET
	@Produces("text/html")
	public String testi(){
		return delegate.giveMeTheString();
	}
}
