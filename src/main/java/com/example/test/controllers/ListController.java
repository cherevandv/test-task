package com.example.test.controllers;

import com.example.test.models.Employee;
import com.example.test.models.Position;
import com.example.test.repos.EmployeeRepo;
import com.example.test.repos.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PositionRepo positionRepo;

    @GetMapping("/")
    public String getList(Model model) {
        Iterable<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model){
        if(filter == null || filter.isEmpty()){
            return "list";
        }
        Iterable<Employee> filterEmployees=employeeRepo.findById(Integer.valueOf(filter));
        Iterable<Position> filterPositions=positionRepo.findByEmployeeId(Integer.valueOf(filter));
        model.addAttribute("employees", filterEmployees);
        model.addAttribute("positions", filterPositions );
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String employeeAdd(@RequestParam String name, @RequestParam String surname,@RequestParam String position, Model model) {
        if(name.trim().isEmpty()||surname.trim().isEmpty()||position.trim().isEmpty()){
            return "redirect:/";
        }
        Employee employee = new Employee(name, surname);
        employeeRepo.save(employee);
        Integer employeeId = employee.getId();
        Position newPosition = new Position(position, employeeId);
        positionRepo.save(newPosition);
        return "redirect:/";
    }

}
