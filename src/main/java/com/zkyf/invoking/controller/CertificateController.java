package com.zkyf.invoking.controller;

import com.zkyf.invoking.common.AssertUtil;
import com.zkyf.invoking.common.ParamResponse;
import com.zkyf.invoking.common.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CertificateController {


    @PostMapping("certificate_loadby")
    public ParamResponse loadby(@RequestBody RequestEntity entity) {
        List<Object> params = new ArrayList<>();
        ParamResponse paramResponse = new ParamResponse();

        //验证参数
        boolean b = AssertUtil.isNotNull(entity)
                && AssertUtil.isNotNull(entity.getIntegerParam("oprno"))
                && AssertUtil.isNotNull(entity.getIntegerParam("empno"));
        paramResponse.setValid(b);

        //组装参数
        params.add(entity.getIntegerParam("oprno"));
        params.add(entity.getIntegerParam("empno"));
        params.add(entity.getIntegerParam("page",1));
        params.add(entity.getIntegerParam("ofpage",10));
        paramResponse.setParams(params);

        return paramResponse;
    }
}
