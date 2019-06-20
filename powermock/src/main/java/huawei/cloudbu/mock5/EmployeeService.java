package huawei.cloudbu.mock5;

import huawei.cloudbu.mock1to4.entity.Employee;


public class EmployeeService {

    public void saveOrUpdate(Employee employee){
        final EmployeeDao employeeDao = new EmployeeDao();
        long count = employeeDao.getCount(employee);
        if (count > 0){
            employeeDao.updateEmployee(employee);
        }else {
            employeeDao.saveEmployee(employee);
        }

    }
}
