//package Controller;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/employees")
//public class AppController {
//    @GET
//    @Path("/getRole")
//    public Response getEmployeesByRole(){
//        return Response.ok(empByRoleQuery.getResultList()).build();
//    }
//
//    @GET
//    @Path("/get")
//    public Response getEmployees(){
//        return Response.ok(empByProjQuery.getResultList()).build();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response addEmpToProj(){
//        return Response.ok(query3).build();
//    }
//}
