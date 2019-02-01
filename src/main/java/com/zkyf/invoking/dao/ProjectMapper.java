package com.zkyf.invoking.dao;

import com.zkyf.invoking.model.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer prjNo);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer prjNo);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}