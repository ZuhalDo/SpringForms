package com.example.SpringForms;

import com.example.SpringForms.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {

    private Map<Long, Employee> employeeMap=new HashMap<>();

    @GetMapping("/employeeform")
    public String empForm(){
        return "employeeform";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model){
        model.addAttribute("name",employee.getName());
        model.addAttribute("id",employee.getId());
        model.addAttribute("contactNumber",employee.getContactNumber());
        employeeMap.put(employee.getId(), employee);
        return "employeeView";
    }
}
