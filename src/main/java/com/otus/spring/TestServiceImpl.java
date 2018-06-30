package com.otus.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class TestServiceImpl implements TestService {
    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test createTest(int count) {
        List<Integer> keys = new Random().ints(count, 0, 9).boxed().collect(toList());
        List<String> q = keys.stream().map(testDao::readQuestion).collect(toList());
        List<String> a = keys.stream().map(testDao::readAnswer).collect(toList());
        return new Test(q, a);
    }

    @Override
    public Score getScore(Test test) {
        int score = 0;
        List<String> wrong = new ArrayList<>();
        for (int i = 0; i < test.getAnswer().size(); i++) {
            if (test.getAnswer().get(i).equals(test.getAnswerFromUser().get(i))) {
                score++;
            } else {
                wrong.add(test.getAnswerFromUser().get(i));
            }
        }
        return new Score(String.valueOf(score), wrong);
    }
}