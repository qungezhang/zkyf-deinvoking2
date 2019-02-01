package com.zkyf.invoking.service;

import com.zkyf.invoking.dao.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseService {
    @Autowired
    private BaseMapper baseMapper;


    public Map<String, Object> acquit(String function,List paramList) {

        return baseMapper.acquit(function,paramList);
    }

    public List<Map<String, Object>> loadby(String function, List paramList) {

        return baseMapper.loadby(function, paramList);
    }




}
