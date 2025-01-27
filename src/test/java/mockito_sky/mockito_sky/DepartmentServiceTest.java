package mockito_sky.mockito_sky;

import mockito_sky.mockito_sky.service.DepartmentServiceImpl;
import mockito_sky.mockito_sky.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    private static final RandomGenerator RANDOM = new Random();

    private static final Collection<Employee>employeeList = List.of(
            new Employee(0, "Тест", "Тестов", 0.0),
            new Employee(1,"Виталий","Давыдов",15_000.00),
            new Employee(1,"Феоктинья","Загагулько",15_000.00),
            new Employee(3,"Федор","Некрасов",15_000.00)
   );

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;


    @DisplayName("Получение сотрудников по департаменту")
    @Test
    void addEmployeeByDepartment() {

        int requestDepartment = 1;
        Collection<Employee> expected = employeeList.stream()
                .filter(employee -> employee.getDepartmentEmployee() == requestDepartment)
                .toList();

        when(employeeService.findAll())
                .thenReturn(employeeList);

        Collection<Employee> actual = departmentService.getEmployeesByDepartment(requestDepartment);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @DisplayName("Негативный тест")
    @Test
    void addEmployeeByDepartment2() {
      int requestDepartment = 100;

        when(employeeService.findAll())
                .thenReturn(employeeList);

        Collection<Employee> actual = departmentService.getEmployeesByDepartment(requestDepartment);

        verify(employeeService, times(1)).findAll();
        assertTrue(actual.isEmpty());

    }


    @DisplayName("Пустоу хранилище")
    @Test
    void addEmployeeByDepartment3() {
        int requestDepartment = 1;

        when(employeeService.findAll())
                .thenReturn(Collections.EMPTY_LIST);

        Collection<Employee> actual = departmentService.getEmployeesByDepartment(requestDepartment);

        verify(employeeService, times(1)).findAll();
        assertTrue(actual.isEmpty());

    }

    @DisplayName("Положительный тест сумма зарплат")
    @ParameterizedTest
    @MethodSource("provideDataForSum")
    void getSalarySumByDepartment(int departmentEmployee, double expected) {

        when(employeeService.findAll())
                .thenReturn(employeeList);

        double actual = departmentService.getSumSalaryByDepartment(departmentEmployee);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @DisplayName("Положительный тест максимальная зарплата")
    @ParameterizedTest
    @MethodSource("provideDataForMax")
    void getSalaryMaxByDepartment(int departmentEmployee, double expected) {

        when(employeeService.findAll())
                .thenReturn(employeeList);

        double actual = departmentService.getMaxSalaryByDepartment(departmentEmployee);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @DisplayName("Положительный тест минимальная зарплата")
    @ParameterizedTest
    @MethodSource("provideDataForMax")
    void getSalaryMinByDepartment(int departmentEmployee, double expected) {

        when(employeeService.findAll())
                .thenReturn(employeeList);

        double actual = departmentService.getMinSalaryByDepartment(departmentEmployee);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDataForSum() {
        return Stream.of(
                Arguments.arguments(1,15_000.00),
                Arguments.arguments(0,0.0)
        );
    }

    private static Stream<Arguments> provideDataForMax() {
        return Stream.of(
                Arguments.arguments(1,15_000.00),
                Arguments.arguments(0,0.0),
                Arguments.arguments(3,15_000.00)
        );
    }

    private static Stream<Arguments> provideDataForMin() {
        return Stream.of(
                Arguments.arguments(1,15_000.00),
                Arguments.arguments(0,0.0),
                Arguments.arguments(3,15_000.00)
        );
    }

}
