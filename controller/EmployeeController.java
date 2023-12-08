package pro.sky.Streams.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Streams.model.Employee;
import pro.sky.Streams.service.DepartmentService;
import pro.sky.Streams.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int salary,
                                @RequestParam int department) {
        return service.add(firstName, lastName, salary, department);
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int salary,
                                   @RequestParam int department) {
        return service.remove(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int salary,
                                 @RequestParam int department) {
        return service.find(firstName, lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> findAllEmployee(@RequestParam String firstName,
                                                @RequestParam String lastName,
                                                @RequestParam int salary,
                                                @RequestParam int department) {
        return service.findAll();
    }
}