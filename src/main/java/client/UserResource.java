/**
 * Created by Apache CXF WadlToJava code generator
**/
package client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user")
public interface UserResource {

    @GET
    @Produces({"application/xml", "application/json;charset=utf-8" })
    @Path("/query/{id}")
    Response getQueryid(@PathParam("id") int id);

}