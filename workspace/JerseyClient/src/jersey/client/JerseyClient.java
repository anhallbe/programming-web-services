package jersey.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource r = client.resource("http://localhost:8080/Jersey/rest/hello");
		
		String xmlRes = r.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		System.out.println(xmlRes);
	}
}
