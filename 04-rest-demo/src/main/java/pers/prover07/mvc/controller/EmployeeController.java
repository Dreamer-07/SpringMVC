package pers.prover07.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.prover07.mvc.bean.Employee;
import pers.prover07.mvc.dao.EmployeeDao;

import java.util.Collection;

/**
 * @author by Prover07
 * @classname EmployeeController
 * @description TODO
 * @date 2022/1/18 16:43
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public String getAllEmployee(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeDao.delete(id);
        // 重定向到请求所有员工信息的接口
        return "redirect:/employees";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeDao.saveOrUpdate(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeDetail(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        employeeDao.saveOrUpdate(employee);
        return "redirect:/employees";
    }

}
