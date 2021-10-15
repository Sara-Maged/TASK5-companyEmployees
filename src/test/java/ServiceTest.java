

import entities.EmployeesEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import service.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceTest {

    Service service = new Service();

    @Test
    void getEmpByProj() {

        String actual = service.getEmpByProj().toString();
        String expected = "[EmployeesEntity{id=5, name='Ahmed', email='ahmed@gmail.com', phone='0100479524', age=27, nationalId=20147985258742, role='SE'}]";

        assertEquals(actual, expected);
    }

    @Test
    void getEmployeesByRole() {
        List<EmployeesEntity> list = new ArrayList<EmployeesEntity>();
        List<EmployeesEntity> spyList = Mockito.spy(list);

        list = service.getEmployeesByRole();
        int actual = list.size();

        Mockito.doReturn(2).when(spyList).size();
        assertEquals(actual, spyList.size());
    }

    @Test
    void addEmpToProj() {

    }

    @Test
    void getEmployeesByRolePage() {
        Paginator page = new Paginator(1, 1);
        int actual = page.getIndex();
        assertEquals(actual, 1);
    }
}
