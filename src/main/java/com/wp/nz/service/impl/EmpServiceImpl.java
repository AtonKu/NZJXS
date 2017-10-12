package com.wp.nz.service.impl;

import com.wp.nz.dao.EmpDao;
import com.wp.nz.entity.Emp;
import com.wp.nz.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    public void save(Emp emp) {
        int a = empDao.insert(emp);
        System.out.println(a);
    }
}
