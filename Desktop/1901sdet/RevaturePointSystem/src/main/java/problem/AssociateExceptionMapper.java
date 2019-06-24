package problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AssociateExceptionMapper implements ExceptionMapper<AssociateNotFoundException> {

	
	public Response toResponse(AssociateNotFoundException exception) {
		return Response.status(404).build();
	}


}
