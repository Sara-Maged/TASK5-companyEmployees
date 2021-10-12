package service;

import entities.EmployeesEntity;
import entities.ProjectEmployeeEntity;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeeResources {

    @GET
    @Path("/getRole")
    public List<EmployeesEntity> getEmployeesByRole() {
        //System.out.println("Query #1 Ran Successfully");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

//            query 1 -> display all employees with their respective role and information
            Query query1 = entityManager.createNativeQuery("select * from employees e where e.role = ?1",
                    EmployeesEntity.class);
            query1.setParameter(1,"SE");
            for(Object emp:query1.getResultList()){
                System.out.println(emp.toString());
            }

            transaction.commit();
            return query1.getResultList();

        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @GET
    @Path("/get")
    public List<EmployeesEntity> getEmployees() {
        //System.out.println("Query #1 Ran Successfully");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

//            query 2 -> all employees with a specific project name
            Query query2 = entityManager.createNativeQuery("select * from employees e ,project_employee ep, projects p where p.projectName= ?1 AND e.id=ep.employee_id AND ep.project_id=p.id",
                    EmployeesEntity.class);
            query2.setParameter(1,"B");
            for(Object emp:query2.getResultList()){
                System.out.println(emp.toString());
            }

            transaction.commit();

            return query2.getResultList();

        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @PUT
    @Produces("application/json")
    public Response addEmptoProj() {
//        return Response.ok("Added new Student").build();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

//            query 2 -> all employees with a specific project name
            Query query3 = entityManager.createNativeQuery("insert into project_employee (employee_id, project_id) values (4, 4)",
                    ProjectEmployeeEntity.class);

            for(Object emp:query3.getResultList()){
                System.out.println(emp.toString());
            }

            transaction.commit();

            return Response.ok("Added Employee to Project").build();

        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}
