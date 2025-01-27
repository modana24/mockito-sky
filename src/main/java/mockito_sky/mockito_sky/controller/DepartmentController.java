package mockito_sky.mockito_sky.controller;

import mockito_sky.mockito_sky.Employee;
import mockito_sky.mockito_sky.service.DepartmentService;
import mockito_sky.mockito_sky.service.DepartmentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentService = departmentServiceImpl;
    }

    @GetMapping("/{id}/employee")
    public List<Employee> getEmployeesByDepartment(@PathVariable int departmentEmployee ){
        return departmentService.getEmployeesByDepartment(departmentEmployee);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSumSalaryByDepartment(@PathVariable int departmentEmployee) {
        return departmentService.getSumSalaryByDepartment(departmentEmployee);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartment(@PathVariable int departmentEmployee) {
        return departmentService.getMaxSalaryByDepartment(departmentEmployee);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartment(@PathVariable int departmentEmployee) {
        return departmentService.getMinSalaryByDepartment(departmentEmployee);
    }

    @GetMapping("/employees")
    public Map<Integer,List<Employee>> getEmployeeGroupedByDepartment() {
        return departmentService.getEmployeeGroupedByDepartment();
    }

}

