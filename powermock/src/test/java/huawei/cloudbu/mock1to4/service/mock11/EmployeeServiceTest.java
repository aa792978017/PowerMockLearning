package huawei.cloudbu.mock1to4.service.mock11;



import huawei.cloudbu.mock11.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeService.class)   //
public class EmployeeServiceTest {
    @Test
    public void testExist()  {
        try{
            EmployeeService employeeService = PowerMockito.spy(new EmployeeService());
            PowerMockito.doNothing().when(employeeService, "checkExist", "wangchang");
            boolean result = employeeService.exist("wangchang");
            assertTrue(result);
            PowerMockito.verifyPrivate(employeeService).invoke("checkExist", "wangchang");
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

}
