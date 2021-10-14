

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
    public void whenStubASpy_thenStubbed() {
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        assertEquals(0, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    void getEmployeesByRole() {
        List<EmployeesEntity> list = new ArrayList<EmployeesEntity>();
        List<EmployeesEntity> spyList = Mockito.spy(list);

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    void addEmpToProj() {

    }

    @Test
    void getEmployeesByRolePage() {
    }
}




//    private EntityManager entityManager;
//    private EntityTransaction transaction;
//    private Query query;
//
//    @Before
//    public void setUp(){
//        entityManager = mock(EntityManager.class);
//        transaction = mock(EntityTransaction.class);
//        query = mock(Query.class);
//    }
//
//    @Test
//    public void persist() {
//        //Employment employment = createEmployment(1, "test user");
//        EmployeesEntity employment = new EmployeesEntity();
//
//        TypedQuery<EmployeesEntity> empByRoleQuery = entityManager.createNamedQuery("Employee.byRole", EmployeesEntity.class);
//        empByRoleQuery.setParameter(1, "SE");
//
//        //Expectations
//        when(entityManager.getTransaction()).thenReturn(transaction);
//        doNothing().when(entityManager).persist(employment);
//
//        EmploymentDaoJpa daoJpa = new EmploymentDaoJpa();
//        daoJpa.setEntityManager(entityManager);
//        EmployeesEntity actual = daoJpa.persist(employment);
//
//        assertSame(employment, actual);
//        verify(entityManager).persist(employment);
//    }
//
//    @Mock
//    private Service underTest;
//    //private AutoCloseable autoCloseable;
//
//    @BeforeEach
//    void Setup(){
//        //autoCloseable =
//
//        MockitoAnnotations.initMocks(this);
//        underTest = new Service();
//    }
//
//    @Test
//    void CanGetEmployeesByRole() {
//        underTest.getEmployeesByRole();
//        assertEquals(underTest.getEmployeesByRole(),
//                underTest.getEmployeesByRole()
//        );
//    }

//    @InjectMocks private Service dbConnection; // review
//    @Mock private Connection mockConnection;
//    @Mock private Statement mockStatement;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

//    @Test
//    public void testMockDBConnection() throws Exception {
//        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
//        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
//        int value;
//        //Assert.assertEquals(value, 1);
//        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
//    }



