package com.app.demo.response;

import com.app.demo.response.result.Result;
import com.app.demo.response.strategy.ResultStrategy;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    /**
     * 원하는 전략으로 result를 생성해주는 메소드
     *
     * @param strategy 원하는 Result 생성 전략
     * @return Result - 원하는 전략 알고리즘으로 얻은 결과
     */
    public void createResult(ResultStrategy strategy){
        strategy.createResult();
    }
}
