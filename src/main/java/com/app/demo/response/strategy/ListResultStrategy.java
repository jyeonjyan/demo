package com.app.demo.response.strategy;

import lombok.Data;

import java.util.List;

public class ListResultStrategy implements ResultStrategy {

    private final List<Object> data;

    public ListResultStrategy(List<Object> data) {
        this.data = data;
    }

    @Override
    public void createResult() {
        new ListResult<>(this.data);
    }

    @Data
    static class ListResult<T> {
        private T data;

        public ListResult(T data) {
            this.data = data;
        }
    }
}
