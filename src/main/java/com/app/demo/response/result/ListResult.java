package com.app.demo.response.result;

import lombok.Getter;

import java.util.List;

@Getter
public class ListResult<T> extends Result<T>{
    private final int size;

    public ListResult(List<T> result, int size) {
        super(result);
        this.size = size;
    }
}
