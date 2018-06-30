package com.otus.spring;

public interface TestService {
    Test createTest(int count);

    Score getScore(Test test);
}
