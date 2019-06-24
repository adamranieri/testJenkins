package resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("welcome")
public class HelloWorld {

	@GET
	public String hello() {
		
		return "Hello";
	}
	
	@POST
	public String helloPost() {
		
		return "Hello From a post request";
	}
}
