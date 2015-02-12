package hw3.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClient {
	public static void main(String[] args) {
		System.out.println("Testing authenticator service");
		Client client = Client.create();
		WebResource authenticator = client.resource("http://localhost:8080/HW3/rest/auth/user/pass");
		String authToken = authenticator.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		System.out.println("Received auth token: " + authToken);
	}
}
