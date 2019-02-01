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
public class WorkerController {


    @PostMapping("worker_acquit")
    public ParamResponse acquit(@RequestBody RequestEntity entity) {
        List<Object> params = new ArrayList<>();
        ParamResponse paramResponse = new ParamResponse();

        //验证参数
        boolean b = AssertUtil.isNotNull(entity)
                && AssertUtil.isNotNull(entity.getIntegerParam("oprno"))
                && AssertUtil.isNotNull(entity.getIntegerParam("no"));
        paramResponse.setValid(b);

        //组装参数
        params.add(entity.getIntegerParam("oprno"));
        params.add(entity.getIntegerParam("no"));
        paramResponse.setParams(params);

        return paramResponse;
    }
}
