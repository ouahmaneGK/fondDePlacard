package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebControllerTest {
 
	private Client client;
	
	@Before
	public void init() {
		client = Client.create();

	}
	
	@Test
	public void testFindIngredientByMcXML() {
		WebResource webResourceXml = client
				.resource("http://localhost:8080/fondDePlacard/webService/findIngr/te");  //[{ \"name\": \"tomate\" },{\"name\": \"patate\"}]"
		
		ClientResponse response = webResourceXml.accept("application/xml")
				.get(ClientResponse.class);
		
		assertTrue(response.getEntity(String.class)
				.contains("<ingredient>" 
						+"<name>tomate</name>" 
						+"</ingredient>"  
						+"<ingredient>"  
						+"<name>patate</name>"  
						+"</ingredient>"));
				
	}
	/*
	@Test
	public void testFindIngredientByMcJson() {
		WebResource webResourceJson = client
				.resource("http://localhost:8080/fondDePlacard/webService/findIngr/te");  
		
		ClientResponse response = webResourceJson.accept("application/json")
				.get(ClientResponse.class);
		
		assertTrue(response.getEntity(String.class)
				.contains("{\"name\": \"tomate\"},{\"name\": \"patate\"}"));
		
		
				
	}
	*/
}
