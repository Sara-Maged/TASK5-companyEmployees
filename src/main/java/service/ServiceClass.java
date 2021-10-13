package service;

import entities.EmployeesEntity;
import entities.ProjectEmployeeEntity;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees")
public class ServiceClass {

    @GET
    @Path("/getRole")
    public Response getEmployeesByRole() {
        //System.out.println("Query #1 Ran Successfully");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<EmployeesEntity> empByRoleQuery = entityManager.createNamedQuery("Employee.byRole", EmployeesEntity.class);
        empByRoleQuery.setParameter(1, "SE");
        return Response.ok(empByRoleQuery.getResultList()).build();
    }

    @GET
    @Path("/get")
    public Response getEmployees() {
        //System.out.println("Query #2 Ran Successfully");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<EmployeesEntity> empByProjQuery = entityManager.createNamedQuery("Employee.byProj", EmployeesEntity.class);
        empByProjQuery.setParameter(1, "B");
        return Response.ok(empByProjQuery.getResultList()).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmpToProj() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query3 = entityManager.createNativeQuery("insert into project_employee (employee_id, project_id) values (4, 4)",
                ProjectEmployeeEntity.class);

        return Response.ok(query3).build();

    }


}
