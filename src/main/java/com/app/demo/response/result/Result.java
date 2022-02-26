package com.app.demo.response.result;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class
Result<T> {
    private final List<T> data;

    /**
     * Single Result:: minimal result
     *
     * @param data - single data
     */
    public Result(T data) {
        // create this.data to arrayList
        this.data = new ArrayList<>();

        if (data == null) throw new IllegalArgumentException("Result data can not be null.");
        this.data.add(data);
    }

    /**
     * List Result:: list result
     *
     * @param data - list data
     */
    public Result(List<T> data) {
        this.data = data;
    }
}
