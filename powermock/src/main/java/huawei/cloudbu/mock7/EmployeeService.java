package huawei.cloudbu.mock7;

import huawei.cloudbu.mock1to4.entity.Employee;

import static huawei.cloudbu.mock7.EmployeeDao.Dialect.*;


final public class EmployeeService {




    public void createEmployee(final Employee employee){
        EmployeeDao employeeDao = new EmployeeDao(false, MYSQL);
        employeeDao.insertEmployee(employee);
    }
}
