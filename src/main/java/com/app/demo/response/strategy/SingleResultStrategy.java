package com.app.demo.response.strategy;

import com.app.demo.response.result.Result;

public class SingleResultStrategy implements ResultStrategy{

    private final Object data;

    public SingleResultStrategy(Object data) {
        this.data = data;
    }

    @Override
    public void createResult() {
        new Result<>(data);
    }
}
