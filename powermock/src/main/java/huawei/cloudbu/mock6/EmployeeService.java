package huawei.cloudbu.mock6;

import huawei.cloudbu.mock1to4.entity.Employee;


final public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    public void createEmployee(Employee employee){
        employeeDao.insertEmployee(employee);
    }
}
