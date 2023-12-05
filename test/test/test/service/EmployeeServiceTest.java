package pro.sky.Streams.test.test.test.service;

import io.micrometer.observation.Observation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.web.client.HttpClientErrorException;
import pro.sky.Streams.exception.EmployeeAlreadyAddedException;
import pro.sky.Streams.exception.EmployeeNotFoundException;
import pro.sky.Streams.model.Employee;
import pro.sky.Streams.service.EmployeeService;
import pro.sky.Streams.service.EmployeeServiceImpl;

import javax.swing.text.BadLocationException;
import javax.ws.rs.BadRequestException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeServiceTest {

    private EmployeeService out;
    private final Employee FIRST_EMPLOYEE = new Employee("Иванова", "Мария", 1000, 1);
    private final Employee SECOND_EMPLOYEE = new Employee("Иванова", "Мария", 1000, 1);
    private Employee add;

    @BeforeEach
    void setUp() {
        out = new EmployeeServiceImpl();
    }

    @Test
    void shouldAddCorrectlyEmployee() {
        out.add(FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment());
        assertEquals(FIRST_EMPLOYEE, add);
        assertEquals(1, out.list().size());
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedException() {
        out.add("Иванова", "Мария", 1000, 1);
        MockedStatic.Verification employeeThrowableCheckedCallable = () -> out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment());
    }

    @Test
    void shouldEmployeeStorageIsFullException() {
    out.add(
            FIRST_EMPLOYEE.getFirstName(),
            FIRST_EMPLOYEE.getLastName(),
            FIRST_EMPLOYEE.getSalary(),
            FIRST_EMPLOYEE.getDepartment());

        out.add(
                SECOND_EMPLOYEE.getFirstName(),
                SECOND_EMPLOYEE.getLastName(),
                SECOND_EMPLOYEE.getSalary(),
                SECOND_EMPLOYEE.getDepartment());
    }

    @Test
    void shouldThrowBadRequestException(){
        Assertions.assertThrows(BadRequestException.class, ()->out.add("1","2",1000,1));
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionOnRemove(){
        Assertions.assertThrows(EmployeeNotFoundException.class, ()-> out.remove(SECOND_EMPLOYEE.getFirstName(), SECOND_EMPLOYEE.getLastName()));
}

    @Test
    void shouldRemoveCorrectly(){
        out.add(FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment());
        assertEquals(1, out.list().size());
        out.remove(FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment());
        assertEquals(0, out.list().size());
}

    @Test
    void shouldThrowEmployeeNotFoundExceptionOnFind(){
        Assertions.assertThrows(EmployeeNotFoundException.class, ()-> out.find(FIRST_EMPLOYEE.getFirstName(), FIRST_EMPLOYEE.getLastName()));
}

    @Test
    void shouldFindCorrectly(){
        out.add(FIRST_EMPLOYEE.getFirstName(), FIRST_EMPLOYEE.getLastName(), FIRST_EMPLOYEE.getSalary(), FIRST_EMPLOYEE.getDepartment());
        Employee expected = new Employee("Иванова", "Мария", 1000,1);
        Employee result = out.find("Иванова", "Мария");
        assertEquals(expected,result);
    }

    @Test
    void list(){
        out.add("Иванова", "Мария", 1000, 1);
        out.add("Петрова", "Татьяна", 110, 2);
        List<Employee> expected = List.of(
                new Employee("Петрова", "Татьяна", 1100, 2),
                new Employee("Иванова", "Мария", 1000,1));
        List<Employee> result = out.list();
        assertEquals(expected.size(), result.size());
        assertEquals(expected.size(0), result.size(0));
        assertEquals(expected.size(1), result.size(1));

    }
}
