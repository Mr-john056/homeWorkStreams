package pro.sky.Streams.service;

import pro.sky.Streams.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    public List<Employee> getAllByDepartment(int dep);

    public Map<Integer, List<Employee>> getAll(int dep);

    Map<Integer, List<Employee>> getAll();

    Employee getMaxSalary(int department);

    Employee getMinSalary(int department);

    List<Employee> getEmployees(int i);
}
