package mockito_sky.mockito_sky.service;

import jakarta.annotation.PostConstruct;
import mockito_sky.mockito_sky.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    private void addEmployee() {
        addEmployee(1,"Виталий","Давыдов",34_003.28);
        addEmployee(2,"Феоктинья","Загагулько",67_432.12);
        addEmployee(3,"Федор","Некрасов",12_098.78);
    }

    @Override
    public Employee addEmployee(int departmentEmployee,
                                String nameEmployee,
                                String surnameEmployee,
                                double salaryEmployee) {
        Employee employee = new Employee(departmentEmployee, nameEmployee, surnameEmployee,salaryEmployee);
        if (employees.containsKey(employee.getFullName())) {
            throw new RuntimeException(employee.getFullName() + " - есть в базе сотрудников. Проверьте корректность данных. ");
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(int departmentEmployee,
                                   String nameEmployee,
                                   String surnameEmployee,
                                   double salaryEmployee) {
        Employee employee = new Employee(departmentEmployee, nameEmployee, surnameEmployee,salaryEmployee);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new RuntimeException(employee.getFullName() + " - данного сотрудника нет в базе сотрудников. Проверьте корректность данных");
    }

    @Override
    public Employee findEmployee(int departmentEmployee,
                                 String nameEmployee,
                                 String surnameEmployee,
                                 double salaryEmployee) {
        Employee employee = new Employee(departmentEmployee, nameEmployee, surnameEmployee,salaryEmployee);
        if (!employees.containsKey(employee.getFullName())) {
            throw new RuntimeException(employee.getFullName() + " - данного сотрудника нет в базе сотрудников. Проверьте корректность данных");
        }
        return employees.remove(employee.getFullName());
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public boolean equals(Object obj, String nameEmployee,
                          String surnameEmployee) {
        if (this == obj) return true;
        if( obj == null || getClass() != obj.getClass() ) return false;
        Employee other = (Employee) obj;
        return nameEmployee.equals(other.getNameEmployee()) && surnameEmployee.equals(other.getSurnameEmployee());
    }

}
