package huawei.cloudbu.mock1to4.dao;

import huawei.cloudbu.mock1to4.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

    public int getTotal(){
        throw new UnsupportedOperationException();
    }

    public void addEmployee(Employee employee)
    {
        throw new UnsupportedOperationException();
    }

}
