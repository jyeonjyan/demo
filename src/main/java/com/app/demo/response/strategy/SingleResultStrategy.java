package com.app.demo.response.strategy;

import com.app.demo.response.result.Result;

public class SingleResultStrategy implements ResultStrategy{

    private final Object data;

    public SingleResultStrategy(Object data) {
        this.data = data;
    }

    @Override
    public Result<Object> createResult() {
        return new Result<>(data);
    }
}
