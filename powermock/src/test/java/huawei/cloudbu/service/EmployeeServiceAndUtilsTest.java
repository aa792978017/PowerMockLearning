package huawei.cloudbu.service;

import huawei.cloudbu.dao.EmployeeDao;
import huawei.cloudbu.entity.Employee;
import huawei.cloudbu.utils.EmployeeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeUtils.class)   //
public class EmployeeServiceAndUtilsTest {

    @Test
    public void testGetEmployeeCountWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
        final EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();
        assertEquals(10, count);
    }

    @Test
    public void testCreateEmployWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        Employee employee = new Employee();
        PowerMockito.doNothing().when(EmployeeUtils.class);
        final EmployeeService service = new EmployeeService();
        service.createEmployee(employee);
        PowerMockito.verifyStatic();
    }

}
