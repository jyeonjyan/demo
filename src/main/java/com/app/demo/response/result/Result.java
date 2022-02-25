package com.app.demo.response.result;

import lombok.Data;

@Data
public class SingleResult<T> {
    private T data;

    public SingleResult(T data) {
        this.data = data;
    }

}
