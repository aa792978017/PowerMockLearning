package huawei.cloudbu.mock9;

public class EmployeeController {
    public String getEmail(final String userName) {
        EmployeeService service = new EmployeeService();
        String email = service.findEmailByUserName(userName);
        return email;
    }

}
