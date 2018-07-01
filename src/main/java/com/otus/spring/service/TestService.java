package com.otus.spring.service;

import com.otus.spring.model.Score;
import com.otus.spring.model.Test;

public interface TestService {
    Test createTest(int count);

    Score getScore(Test test);
}
