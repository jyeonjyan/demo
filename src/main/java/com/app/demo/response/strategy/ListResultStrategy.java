package com.app.demo.response.strategy;

import com.app.demo.response.result.Result;
import com.app.demo.response.result.ListResult;

import java.util.List;

public class ListResultStrategy implements ResultStrategy {

    private final List<Object> data;

    /**
     * ListResultStrategy constructor
     *
     * @param data responseDto list
     */
    public ListResultStrategy(List<Object> data) {
        this.data = data;
    }

    @Override
    public Result<Object> createResult() {
        return new ListResult<>(data, data.size());
    }
}
