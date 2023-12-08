package pro.sky.Streams.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.Streams.service.EmployeeService;

@Component
public class FillEmployees implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeList;

    @Override
    public void run(String... args) throws Exception {
        employeeList.add("Иванова", "Мария", 1000, 1);
        employeeList.add("Петрова", "Татьяна", 1100, 2);
        employeeList.add("Морозов", "Павел", 1200, 2);
        employeeList.add("Кузнецов", "Андрей", 1300, 3);
        employeeList.add("Деревянко", "Наталья", 1400, 3);
        employeeList.add("Хлынов", "Михаил", 1500, 3);
    }
}