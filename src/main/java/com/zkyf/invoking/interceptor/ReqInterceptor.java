package com.zkyf.invoking.interceptor;


import com.zkyf.invoking.common.ApiCode;
import com.zkyf.invoking.common.AssertUtil;
import com.zkyf.invoking.common.FastJsonUtils;
import com.zkyf.invoking.common.MapFormat;
import com.zkyf.invoking.common.PageUtil;
import com.zkyf.invoking.common.ParamResponse;
import com.zkyf.invoking.common.RequestEntity;
import com.zkyf.invoking.common.ResponseUtil;
import com.zkyf.invoking.service.BaseService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ReqInterceptor implements HandlerInterceptor {
    @Autowired
    private BaseService baseService;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String requestUri = request.getRequestURI();
        if (StringUtils.equals("/", requestUri)) {
            if ("POST".equals(request.getMethod())) {
                try {
                    BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
                    StringBuilder responseBuilder = new StringBuilder();
                    String inputStr;
                    while ((inputStr = streamReader.readLine()) != null) {
                        responseBuilder.append(inputStr);
                    }
                    String requstString = responseBuilder.toString();
                    JSONObject jsonObject = JSONObject.fromObject(requstString);
                    String cmd = jsonObject.getString("cmd");
                    ResponseUtil responseUtil = new ResponseUtil();

                    if (!AssertUtil.isNull(cmd)) {
                        Map<String, Object> params = jsonObject.getJSONObject("params");

                        RequestEntity entity = FastJsonUtils.json2Bean(requstString, RequestEntity.class);

                        //根据cmd http调用去验证参数 如下测试会调用WorkerController中的worker_acquit地址
                        /**
                         *   {
                         *     "cmd":"worker_acquit",
                         * 	   "params":{"oprno":2,"no":57}
                         *
                         *   }
                         */
                        String url = "http://localhost:8080/" + cmd;
                        ParamResponse paramResponse = restTemplate.postForObject(url, entity, ParamResponse.class);
                        if (AssertUtil.isNotNull(paramResponse)) {
                            if (paramResponse.isValid()) {
                                if (cmd.endsWith("acquit")) {
                                    Map<String, Object> acquit = baseService.acquit(cmd, paramResponse.getParams());
                                    responseUtil.setErr(ApiCode.OK);
                                    responseUtil.setResults(MapFormat.formatHumpName(acquit));
                                }

                                if (cmd.endsWith("loadby")) {
                                    List<Map<String, Object>> loadby = baseService.loadby(cmd, paramResponse.getParams());

                                    if (AssertUtil.isNotNull(loadby)) {
                                        PageUtil page = new PageUtil();
                                        Integer rec_count = (Integer) loadby.get(0).get("rec_count");
                                        page.setReccount(rec_count);
                                        Integer ofpage = (Integer) entity.getParams().get("ofpage");
                                        page.setOfpage(ofpage);
                                        Integer page1 = (Integer) entity.getParams().get("page");
                                        page.setPage(page1);
                                        page.setAllpage((rec_count / ofpage));
                                        List<Object> reccount = new ArrayList<>();
                                        loadby.forEach(o ->{
                                            Object row =  o.get("row_data"); // TODO: 2019/2/1 decode

                                            Map object1 = JSONObject.fromObject(row);
                                            Map map = MapFormat.formatHumpName(object1);
                                            reccount.add(map);

                                        });

                                        responseUtil.setErr(ApiCode.OK);
                                        responseUtil.setResults(page);
                                        responseUtil.setRecords(reccount);
                                    }


                                }


                                // TODO: 2019/2/1  增删改待继续




                            } else {
                                responseUtil.setErr(9995);
                                responseUtil.setResults("缺少参数或参数的数据类型(内容)错误。");
                            }
                        }

                        // 返回客戶端
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("application/json; charset=utf-8");
                        PrintWriter writer = response.getWriter();
                        String resultJson = com.alibaba.fastjson.JSONObject.toJSONString(responseUtil);
                        writer.write(resultJson);
                        writer.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } else {

            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }


}