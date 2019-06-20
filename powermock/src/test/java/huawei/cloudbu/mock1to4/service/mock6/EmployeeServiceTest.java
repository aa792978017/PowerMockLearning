package huawei.cloudbu.mock1to4.service.mock6;


import huawei.cloudbu.mock1to4.entity.Employee;
import huawei.cloudbu.mock6.EmployeeDao;
import huawei.cloudbu.mock6.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeDao.class)   //
public class EmployeeServiceTest {
    /**
     * 功能描述：
     *  <测试是否能mock final 类型的class或者method>
     * @param  1
     * @return : void
     * @author : wangchang
     * @date : 2019-06-20 17:59
     */
    @Test
    public void test(){
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        Employee employee = new Employee();
        PowerMockito.when(employeeDao.insertEmployee(employee)).thenReturn(true);
        EmployeeService service = new EmployeeService(employeeDao);
        service.createEmployee(employee);
        Mockito.verify(employeeDao).insertEmployee(employee);
    }

}
