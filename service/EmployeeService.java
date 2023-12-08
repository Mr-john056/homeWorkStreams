package pro.sky.Streams.service;

import pro.sky.Streams.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee maxSalary(String firstName, String lastName, int salary, int department);

    Employee minSalary(String firstName, String lastName, int salary, int department);

    Employee add(String firstName, String lastName, int salary, int department);

    Employee remove(String firstName, String lastName, int salary, int department);

    Employee find(String firstName, String lastName, int salary, int department);

    Collection<Employee> findAll();

    Collection<Employee> maxSalary();

    Collection<Employee> minSalary();

    List<Employee> list();

    void remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}