package Controller;

import service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees")
public class EmployeeResources {
    Service service = new Service();

    @GET
    @Path("/getRole")
    public Response getEmployeesByRole(){
        return Response.ok(service.getEmployeesByRole()).build();
    }

    @GET
    @Path("/get")
    public Response getEmployees(){
        return Response.ok(service.getEmpByProj()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post")
    public Response addEmpToProj(){
        service.addEmpToProj();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/postpage")
    public Response getEmpWithPage(){
        Paginator page = new Paginator(1, 1);
        return Response.ok(service.getEmployeesByRolePage(page.getIndex(), page.getSize())).build();
    }

}
