package huawei.cloudbu.mock11;

public class EmployeeService {

    public boolean exist(String userName) {
        checkExist(userName);
        return true;
    }
    private void checkExist(String userName) {
        throw new UnsupportedOperationException();
    }
}
