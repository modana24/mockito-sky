package mockito_sky.mockito_sky.service;

import mockito_sky.mockito_sky.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public List<Employee> getEmployeesByDepartment(int departmentEmployee) {
        return this.getEmployeeStreamByDepartment(departmentEmployee)
                .toList();
    }


    @Override
    public double getSumSalaryByDepartment(int departmentEmployee){
        return getEmployeesByDepartment(departmentEmployee)
                .stream()
                .mapToDouble(Employee::getSalaryEmployee)
                .sum();
    }

    @Override
    public double getMaxSalaryByDepartment(int departmentEmployee){
        return getEmployeesByDepartment(departmentEmployee)
                .stream()
                .mapToDouble(Employee::getSalaryEmployee)
                .max()
                .orElse(-1);
    }

    @Override
    public double getMinSalaryByDepartment(int departmentEmployee){
        return getEmployeesByDepartment(departmentEmployee)
                .stream()
                .mapToDouble(Employee::getSalaryEmployee)
                .min()
                .orElse(-1);
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeeGroupedByDepartment() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartmentEmployee
                        ));
    }

    private Stream<Employee> getEmployeeStreamByDepartment(int departmentEmployee) {
        return employeeService.findAll()
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartmentEmployee() == departmentEmployee);
    }

}
