package com.zkyf.invoking.service;

import com.zkyf.invoking.dao.EmployeeMapper;
import com.zkyf.invoking.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public Map getOne(Integer id) {
        return employeeMapper.getOne(id);
    }
}
