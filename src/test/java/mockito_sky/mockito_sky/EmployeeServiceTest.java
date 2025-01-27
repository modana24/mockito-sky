package mockito_sky.mockito_sky;

import mockito_sky.mockito_sky.service.EmployeeService;
import mockito_sky.mockito_sky.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @DisplayName("Добавление сотрудника")
    @Test
    void addEmployeeTest() {
        int sizeBeforeAdding = employeeService.findAll().size();
        int expectedSize = ++sizeBeforeAdding;
        Employee newEmployee = new Employee(0, "Тест", "Тестов", 00909.9);

        employeeService.addEmployee(newEmployee);

        int actualSize = employeeService.findAll().size();
        assertEquals(expectedSize, actualSize);

        boolean isAdded = employeeService.findAll()
                .stream()
                .anyMatch(newEmployee::equals);
        assertTrue(isAdded);
    }
}