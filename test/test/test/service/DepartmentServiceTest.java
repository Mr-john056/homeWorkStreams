package pro.sky.Streams.test.test.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Streams.model.Employee;
import pro.sky.Streams.service.DepartmentService;
import pro.sky.Streams.service.DepartmentServiceImpl;
import pro.sky.Streams.service.EmployeeService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    private static final List<Employee> LIST = List.of(
            new Employee("Иванова", "Мария", 1000, 1),
            new Employee("Петрова", "Татьяна", 1100, 2),
            new Employee("Морозов", "Павел", 1200, 2));
    @Mock
    private EmployeeService serviceMock;

    private DepartmentService out;

    @BeforeEach
    void setUp() {
        when(serviceMock.list()).thenReturn(LIST);
        out = new DepartmentServiceImpl(serviceMock);
    }

    @Test
    void getEmployees() {
        when(serviceMock.list()).thenReturn(LIST);

        List<Employee> expected = List.of(
                new Employee("Иванова", "Мария", 1000, 1),
                new Employee("Петрова", "Татьяна", 1100, 2));
        List<Employee> result = out.getEmployees(1);
        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertEquals(expected.get(0), result.get(0));
        Assertions.assertEquals(expected.get(1), result.get(1));
    }
}
