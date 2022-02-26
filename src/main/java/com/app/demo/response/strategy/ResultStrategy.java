package com.app.demo.response.strategy;

import com.app.demo.response.result.Result;

public interface ResultStrategy {
    Result<Object> createResult();
}
