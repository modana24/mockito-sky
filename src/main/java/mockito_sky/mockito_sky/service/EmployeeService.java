package mockito_sky.mockito_sky.service;

import mockito_sky.mockito_sky.Employee;

import java.util.Collection;

public interface EmployeeService {
    default Employee addEmployee(Employee employee){
        return addEmployee(employee.getDepartmentEmployee(),
                employee.getNameEmployee(),
                employee.getSurnameEmployee(),
                employee.getSalaryEmployee());
    };

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

    boolean equals(Object obj, String nameEmployee,
                   String surnameEmployee);
}
