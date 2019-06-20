package huawei.cloudbu.service;

import huawei.cloudbu.dao.EmployeeDao;
import huawei.cloudbu.entity.Employee;
import huawei.cloudbu.utils.EmployeeUtils;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
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
