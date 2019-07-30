package huawei.cloudbu.mock1to4;

import huawei.cloudbu.mock1to4.service.mock8.EmployeeServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@Suite.SuiteClasses({
        EmployeeServiceTest.class,
        EmployeeServiceTest.class})
public class ALLTest {
}
