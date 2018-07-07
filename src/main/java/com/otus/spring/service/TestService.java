package com.otus.spring.service;

import com.otus.spring.model.Score;
import com.otus.spring.model.TestData;

public interface TestService {
    TestData createTest(int count);

    Score getScore(TestData testData);
}
