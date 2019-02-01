package com.zkyf.invoking.service;

import com.zkyf.invoking.dao.ProjectMapper;
import com.zkyf.invoking.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;


    public Project get(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }


}
