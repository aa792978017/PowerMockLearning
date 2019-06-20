package huawei.cloudbu.mock1to4.service.mock7;


import huawei.cloudbu.mock1to4.entity.Employee;
import huawei.cloudbu.mock7.EmployeeDao;
import huawei.cloudbu.mock7.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeService.class)   //
public class EmployeeServiceTest {

    @Test
    public void test(){
        EmployeeDao employeeDao = mock(EmployeeDao.class);   //mock一个实例
       try{
           whenNew(EmployeeDao.class).withArguments(false, EmployeeDao.Dialect.MYSQL)
                   .thenReturn(employeeDao); //用whenNew语法传参数，参数要一致，不一致会导致Sevice多创建一个实例
           EmployeeService employeeService = new EmployeeService();
           Employee employee = new Employee();
           employeeService.createEmployee(employee);
           Mockito.verify(employeeDao).insertEmployee(employee);  //验证方法调用
       }catch (Exception exception){
           fail();
       }
    }

}
