package jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/world")
public class WorldResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayWorld() {
		return "World!";
	}
}
