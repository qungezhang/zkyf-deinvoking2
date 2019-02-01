package com.zkyf.invoking.dao;

import com.zkyf.invoking.model.Employee;

import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empNo);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empNo);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Map<String, Object> getOne(Integer empNo);
}