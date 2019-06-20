package huawei.cloudbu.mock1to4.service;

import huawei.cloudbu.mock1to4.entity.Employee;
import huawei.cloudbu.mock1to4.utils.EmployeeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeUtils.class)   //
public class EmployeeServiceAndUtilsTest {

    /**
     * 测试有返回值的类静态类方法
     */
    @Test
    public void testGetEmployeeCountWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
        final EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();
        assertEquals(10, count);
    }

    /**
     * 测试无返回值的类静态方法
     */
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
