package com.zkyf.invoking.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseMapper {

    Map<String, Object> acquit(@Param("function") String function, @Param("paramList") List paramList);

    Integer append(@Param("sqlmap") Map sqlmap);

    List<Map<String, Object>> loadby(@Param("function") String function, @Param("paramList") List paramList);




}
