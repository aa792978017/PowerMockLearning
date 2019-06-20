package huawei.cloudbu.mock1to4.service.mock8;


import huawei.cloudbu.mock8.EmployeeController;
import huawei.cloudbu.mock8.EmployeeService;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

public class EmployeeServiceTest {

    @Test
    public void testGetEmail() {
        EmployeeService employeeService = mock(EmployeeService.class);
        when(employeeService.findEmailByUserName(Mockito.argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object argument) {
                String arg = (String)argument;
                if (arg.startsWith("wangchang") || arg.startsWith("wc")){
                    return true;
                }else {
                    throw new RuntimeException();
                }
            }
        }))).thenReturn("wangchang@email.com");

        try{
            whenNew(EmployeeService.class).withAnyArguments().thenReturn(employeeService);
            EmployeeController controller = new EmployeeController();
            String email = controller.getEmail("wangchang");
            assertEquals("wangchang@email.com", email);
            controller.getEmail("liudehua");
            fail("should not process to here");
        }catch (Exception e){
            assertTrue((e instanceof RuntimeException));
        }
    }

}
