package entities;

import javax.persistence.*;

@Entity
@Table(name = "project_employee", schema = "employeedb")
//insert into project_employee (employee_id, project_id) values (4, 4)
@NamedQuery(name = "Employee.byProj", query = "select e from EmployeesEntity e,ProjectEmployeeEntity ep, ProjectsEntity p " +
        "where p.projectName= ?1 AND e.id=ep.employee_id AND ep.project_id=p.id")
//@NamedQuery(name = 'EmpToProj', query = "insert into project_employee(employee_id, project_id) values(4, 4)")
public class ProjectEmployeeEntity {
    private int id;
    private int employee_id;
    private int project_id;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEmployeeEntity that = (ProjectEmployeeEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
