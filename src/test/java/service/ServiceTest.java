package service;

import Controller.Paginator;
import entities.EmployeesEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class ServiceTest {

    @Test
    void getEmployeesByRole() {
        Service service = new Service();
        List<EmployeesEntity> list = new ArrayList<EmployeesEntity>();
        List<EmployeesEntity> spyList = Mockito.spy(list);

        list = service.getEmployeesByRole();
        int actual = list.size();

        Mockito.doReturn(2).when(spyList).size();
        assertEquals(actual, spyList.size());
    }

    @Test
    void getEmpByProj() {
        Service service = new Service();
        String actual = service.getEmpByProj().toString();
        String expected = "[EmployeesEntity{id=5, name='Ahmed', email='ahmed@gmail.com', phone='0100479524', age=27, nationalId=20147985258742, role='SE'}]";

        assertEquals(actual, expected);
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
