package mockito_sky.mockito_sky.service;

import mockito_sky.mockito_sky.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(int departmentEmployee,
                         String nameEmployee,
                         String surnameEmployee,
                         double salaryEmployee);

    Employee removeEmployee(int departmentEmployee,
                            String nameEmployee,
                            String surnameEmployee,
                            double salaryEmployee);

    Employee findEmployee(int departmentEmployee,
                          String nameEmployee,
                          String surnameEmployee,
                          double salaryEmployee);

    Collection<Employee> findAll();
}
