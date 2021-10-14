package service;

import entities.EmployeesEntity;
import entities.ProjectEmployeeEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class Service {

    public List<EmployeesEntity> getEmployeesByRole(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<EmployeesEntity> empByRoleQuery = entityManager.createNamedQuery("Employee.byRole", EmployeesEntity.class);
        empByRoleQuery.setParameter(1, "SE");

        return empByRoleQuery.getResultList();
    }

    public List<EmployeesEntity> getEmpByProj(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<EmployeesEntity> empByProjQuery = entityManager.createNamedQuery("Employee.byProj", EmployeesEntity.class);
        empByProjQuery.setParameter(1, "A");

        return empByProjQuery.getResultList();
    }

    public void addEmpToProj(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createNativeQuery
                ("insert into project_employee (employee_id, project_id) values (1, 1)",
                ProjectEmployeeEntity.class);

        entityManager.getTransaction().commit();
    }

    public List<EmployeesEntity> getEmployeesByRolePage(int index, int size){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<EmployeesEntity> empByRoleQuery = entityManager.createNamedQuery("Employee.byRole", EmployeesEntity.class)
                .setMaxResults(2)
                .setFirstResult(5);
        empByRoleQuery.setParameter(1, "SE");

        return empByRoleQuery.getResultList();
    }

}

//        int pageNumber = 1;
//        int pageSize = 10;
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Long> countQuery = criteriaBuilder
//                .createQuery(Long.class);
//        countQuery.select(criteriaBuilder
//                .count(countQuery.from(EmployeesEntity.class)));
//        Long count = entityManager.createQuery(countQuery)
//                .getSingleResult();
//
//        CriteriaQuery<EmployeesEntity> criteriaQuery = criteriaBuilder
//                .createQuery(EmployeesEntity.class);
//        Root<EmployeesEntity> from = criteriaQuery.from(EmployeesEntity.class);
//        CriteriaQuery<EmployeesEntity> select = criteriaQuery.select(from);
//
//        TypedQuery<EmployeesEntity> typedQuery = entityManager.createQuery(select);
//        while (pageNumber < count.intValue()) {
//            typedQuery.setFirstResult(pageNumber - 1);
//            typedQuery.setMaxResults(pageSize);
//            System.out.println("Current page: " + typedQuery.getResultList());
//            pageNumber += pageSize;

//        }


