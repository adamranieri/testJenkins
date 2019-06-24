package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fakedb.FakeDB;
import model.Associate;
import problem.AssociateExceptionMapper;
import problem.AssociateNotFoundException;
import service.AssociateService;

@Path("associates")
public class AssociateResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response getAllAssociates() {
		
		List<Associate> associates = FakeDB.associates;
		
		return Response.ok(associates,MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public static Response getAssociate(@PathParam("name") String name, 
			@Context HttpHeaders headers )  {
		
		Associate a = AssociateService.getAssociate(name);
		
		if(a==null) {
			return new AssociateExceptionMapper().toResponse(new AssociateNotFoundException());
		}
		
		if(headers.getRequestHeader("Content-Type").get(0).equals("application/json")) {
			return Response.ok(a,MediaType.APPLICATION_JSON).build();
		}
		
		if(headers.getRequestHeader("Content-Type").get(0).equals("application/xml")) {
			return Response.ok(a,MediaType.APPLICATION_XML).build();
		}
		
		return Response.ok(a.toString(),MediaType.TEXT_PLAIN).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response createAssociate(Associate associate) {
		
		AssociateService.addAssociate(associate);
		
		return Response.status(451).build();
	}
	

}
