package huawei.cloudbu.mock7;

import huawei.cloudbu.mock1to4.entity.Employee;

/**
 *
 */
public class EmployeeDao {

    public enum Dialect {
        MYSQL,
        ORAClE
    }

    public EmployeeDao(boolean lazy, Dialect dialect){
        throw new UnsupportedOperationException();
    }



    public boolean insertEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
