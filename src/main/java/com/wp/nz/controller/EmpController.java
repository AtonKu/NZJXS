package com.wp.nz.controller;

import com.wp.nz.entity.Emp;
import com.wp.nz.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp/*")
public class EmpController {

    @Autowired
    private EmpService empService;

    @ResponseBody
    @RequestMapping("save")
    public void save(String name, int age, String weight){
        Emp emp = new Emp();
        emp.setUserName(name);
        emp.setAge(age);
        emp.setPassword(weight);
        empService.save(emp);
    }
}
