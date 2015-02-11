package jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Path("/hello")
public class HelloResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		Client client = Client.create();
		WebResource r = client.resource("http://localhost:8080/Jersey/rest/world");
		String world = r.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		return "Hello! " + world;
	}
}
