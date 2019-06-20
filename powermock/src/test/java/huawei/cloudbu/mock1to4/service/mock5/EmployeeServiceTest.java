package huawei.cloudbu.mock1to4.service.mock5;


import huawei.cloudbu.mock1to4.entity.Employee;
import huawei.cloudbu.mock5.EmployeeDao;
import huawei.cloudbu.mock5.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)   //
@PrepareForTest(EmployeeService.class)   //
public class EmployeeServiceTest {
    @Test
    public void testSaveOrUpdateCountLessZero() {
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao).saveEmployee(employee);  //如果执行了这方法
            Mockito.verify(employeeDao, Mockito.never()).updateEmployee(employee); //没有调用这个方法，才算执行正确
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSaveOrUpdateCountMoreThanZero() {
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(1L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao).updateEmployee(employee);
            Mockito.verify(employeeDao, Mockito.never()).saveEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSaveOrUpdateCountAtLeastOnce() {
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao,Mockito.atLeastOnce()).saveEmployee(employee);  //至少调用一次这个方法
            Mockito.verify(employeeDao, Mockito.never()).updateEmployee(employee); //没有调用这个方法，才算执行正确
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSaveOrUpdateCountTimes() {
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao,Mockito.times(1)).saveEmployee(employee);  //调用一次这个方法
            Mockito.verify(employeeDao, Mockito.times(0)).updateEmployee(employee); //调用了一次这个方法
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSaveOrUpdateCountAtMost() {
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao,Mockito.atMost(1)).saveEmployee(employee);  //最多调用一次这个方法
            Mockito.verify(employeeDao, Mockito.times(0)).updateEmployee(employee); //调用了一次这个方法
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void testSaveOrUpdateCountAtLeast() {
        try{
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao,Mockito.atLeast(1)).saveEmployee(employee);  //最少调用一次这个方法
            Mockito.verify(employeeDao, Mockito.times(0)).updateEmployee(employee); //调用了一次这个方法
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
