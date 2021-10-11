
import entities.EmployeesEntity;

import javax.persistence.*;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Query#1
            TypedQuery<EmployeesEntity> empByRoleQuery = entityManager.createNamedQuery("Employee.byRole", EmployeesEntity.class);
            empByRoleQuery.setParameter(1, "SE");
            for (EmployeesEntity employee : empByRoleQuery.getResultList()){
                System.out.println(employee);
            }

//          Query#2
            TypedQuery<EmployeesEntity> empByProjQuery = entityManager.createNamedQuery("Employee.byProj", EmployeesEntity.class);
            empByProjQuery.setParameter(1, "B");
            for (EmployeesEntity employee : empByProjQuery.getResultList()){
                System.out.println(employee);
            }


//          Query#3
            entityManager.createNativeQuery("insert into project_employee (employee_id, project_id)\n" +
                    "values (4, 4)");

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
