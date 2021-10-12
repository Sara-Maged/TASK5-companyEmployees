package Controllers;


import entities.EmployeesEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationPath("/api")
public class AppController {

//    @GET
//    @Path("/employees")
//    public List<EmployeesEntity> getEmployeeInformation() {
//        return ;
//    }

    @GET
    @Path("/info/{user}")
    @Produces("application/json")
    public Response getEmployeeInformation(@PathParam("user") String user) {
        //this method get the information of the employee
        return Response.ok("API for getting information for user " + user).build();
    }

    @PUT
    @Produces("application/json")
    public Response addNewEmployee() {
        return Response.ok("Added new Student").build();
    }
}
