package huawei.cloudbu.mock1to4.service.mock9;


import huawei.cloudbu.mock8.EmployeeController;
import huawei.cloudbu.mock8.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeController.class)
public class EmployeeServiceTest {

    @Test
    public void testGetEmail() {
        EmployeeService employeeService = mock(EmployeeService.class);
        PowerMockito.when(employeeService.findEmailByUserName(Mockito.anyString())).then(new Answer<String>(){

            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                String arugment = (String)invocation.getArguments()[0];
                if ("wangchang".equals(arugment)){
                    return "wangchang@email.com";
                } else if("liudeihua".equals(arugment)){
                    return "andy@email.com";
                }else {
                    throw new NullPointerException();
                }
            }
        });
        try{
            PowerMockito.whenNew(EmployeeService.class).withNoArguments().thenReturn(employeeService);
            EmployeeController controller = new EmployeeController();
            String email = controller.getEmail("wangchang");
            assertEquals("wangchang@email.com", email);
            email = controller.getEmail("liudeihua");
            assertEquals("andy@email.com", email);
            email = controller.getEmail("JackChen");
            fail();
        }catch (Exception e){
            assertTrue(e instanceof NullPointerException);
        }
    }

}
