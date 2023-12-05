package pro.sky.Streams.service;

import org.springframework.stereotype.Service;
import pro.sky.Streams.exception.EmployeeAlreadyAddedException;
import pro.sky.Streams.exception.EmployeeNotFoundException;
import pro.sky.Streams.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public EmployeeServiceImpl(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public EmployeeServiceImpl(Map<String, Employee> employees, List<Employee> employeeList) {
        this.employees = employees;
        this.employeeList = employeeList;
    }

    @Override
    public Employee maxSalary(String firstName, String lastName, int salary, int department) {
        return null;
    }

    @Override
    public Employee minSalary(String firstName, String lastName, int salary, int department) {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Collection<Employee> maxSalary() {
        return null;
    }

    @Override
    public Collection<Employee> minSalary() {
        return null;
    }

    @Override
    public List<Employee> list() {
        return null;
    }

    @Override
    public void remove(String firstName, String lastName) {

    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }
}