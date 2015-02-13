package hw3.services;

import hw3.store.AuthStore;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class Authenticator {
	private String authenticatedUser = "user";
	private String authenticatedPassword = "pass";
	
	@Path("/{username}/{password}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticate(@PathParam("username") String user, @PathParam("password") String password) {
		Random rand = new Random();
		String authToken = "";
		if(user.equals(authenticatedUser) && password.equals(authenticatedPassword)) {;
			authToken = "" + rand.nextInt(9999999);
			AuthStore.tokens.add(authToken);
		}
		return authToken;
	}
}
