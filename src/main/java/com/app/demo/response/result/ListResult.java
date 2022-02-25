package com.app.demo.response.result;

import lombok.Data;

import java.util.List;

@Data
public class ListResult<T> {
    private final Result<List<T>> result;
    private final int size;

    public ListResult(Result<List<T>> result, int size) {
        this.result = result;
        this.size = size;
    }
}
