package huawei.cloudbu.mock1to4.service;

import huawei.cloudbu.mock1to4.dao.EmployeeDao;
import huawei.cloudbu.mock1to4.entity.Employee;
import huawei.cloudbu.mock1to4.utils.EmployeeUtils;


public class EmployeeService {
//    private EmployeeDao employeeDao;

//    public EmployeeService(EmployeeDao employeeDao){
//        this.employeeDao = employeeDao;
//    }

    /**
     * 获取所有员工的数量
     * @return
     */
    public int getTotalEmployee(){
       EmployeeDao employeeDao = new EmployeeDao();
       return employeeDao.getTotal();
    }

//    public void createEmployee(Employee employee)
//    {
//        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.addEmployee(employee);
//    }

    public int getEmployeeCount() {
        return EmployeeUtils.getEmployeeCount();
    }

    public void createEmployee(Employee employee){
        EmployeeUtils.persistenceEmployee(employee);
    }
}
