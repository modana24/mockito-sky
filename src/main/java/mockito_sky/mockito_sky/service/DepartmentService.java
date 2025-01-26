package mockito_sky.mockito_sky.service;

import mockito_sky.mockito_sky.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> getEmployeesByDepartment(int departmentEmployee);

    double getSumSalaryByDepartment(int departmentEmployee);

    double getMaxSalaryByDepartment(int departmentEmployee);

    double getMinSalaryByDepartment(int departmentEmployee);

    Map<Integer, List<Employee>> getEmployeeGroupedByDepartment();
}
