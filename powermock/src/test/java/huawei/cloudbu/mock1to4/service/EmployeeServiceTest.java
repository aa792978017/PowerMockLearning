package huawei.cloudbu.mock1to4.service;

import huawei.cloudbu.mock1to4.dao.EmployeeDao;
import huawei.cloudbu.mock1to4.entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeService.class)   //
public class EmployeeServiceTest {

    /**
     * 没有powermock的时候
     */
//    @Test
//    public void testGetTotalEmployee() {
//        final EmployeeDao employeeDao = new EmployeeDao();
//        final EmployeeService employeeService = new EmployeeService(employeeDao);
//        int total = employeeService.getTotalEmployee();
//        assertEquals(10,total);
//    }
//
//
//    @Test
//    public void testGetTotalEmployeeWithMock() {
//        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
//        PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
//        EmployeeService service = new EmployeeService(employeeDao);
//        int total = service.getTotalEmployee();
//        assertEquals(10, total);
//    }

//    @Test
//    public void testCreateEmployee() {
//        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
//        Employee employee = new Employee();
//        PowerMockito.doNothing().when(employeeDao).addEmployee(employee);
//        EmployeeService service = new EmployeeService(employeeDao);
//        service.createEmployee(employee);
//
//        Mockito.verify(employeeDao).addEmployee(employee);
//    }

    @Test
    public void testGetTotalEmployee() {
        EmployeeService service = new EmployeeService();
        int total = service.getTotalEmployee();
        assertEquals(10, total);
    }

    @Test
    public void testGetTotalEmployeeWithMock() {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        try{
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
            EmployeeService service = new EmployeeService();
            int total = service.getTotalEmployee();
            assertEquals(11, total);
        }catch (Exception e){
            fail("测试失败");
        }
    }

    @Test
    public void testCreateTmployeeWithMock() {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        try{
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            EmployeeService service = new EmployeeService();
            service.createEmployee(employee);
            Mockito.verify(employeeDao).addEmployee(employee);
        }catch (Exception e){
            fail("test fail");
        }

    }

}
