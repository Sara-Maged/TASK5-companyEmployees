package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "projects", schema = "employeedb", catalog = "")
public class ProjectsEntity {
    private int id;
    private String projectName;
    private Date startDate;
    private String appointedManger;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "projectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "appointedManger")
    public String getAppointedManger() {
        return appointedManger;
    }

    public void setAppointedManger(String appointedManger) {
        this.appointedManger = appointedManger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsEntity that = (ProjectsEntity) o;

        if (id != that.id) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (appointedManger != null ? !appointedManger.equals(that.appointedManger) : that.appointedManger != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (appointedManger != null ? appointedManger.hashCode() : 0);
        return result;
    }
}
