package com.app.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Result<T> {
    private final T data;

    public Result(T data) {
        this.data = data;
    }

    @Getter
    static class ListResult extends Result{

        private final int size;

        public ListResult(Object data, int size) {
            super(data);
            this.size = size;
        }
    }
}
