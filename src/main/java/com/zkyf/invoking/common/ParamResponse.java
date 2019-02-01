package com.zkyf.invoking.common;

import java.util.List;

public class ParamResponse {
    public boolean valid;
    public List<Object> params;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}
