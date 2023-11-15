package com.mikhail.spring.mvc_hibernate_aop.controller;

import com.mikhail.spring.mvc_hibernate_aop.entity.Employee;
import com.mikhail.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.*;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        //для view передаем в модель объект
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "employee-info";
        } else {
            employeeService.saveEmployee(employee);
            return "redirect:/"; // переадресация на /
        }
    }

    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestParam("empId") int empId, Model model) {

        Employee employee = employeeService.getEmployee(empId);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/delEmployee")
    public String delEmployee(@RequestParam("empId") int empId) {

        employeeService.delEmployee(empId);

        return "redirect:/";
    }
}
