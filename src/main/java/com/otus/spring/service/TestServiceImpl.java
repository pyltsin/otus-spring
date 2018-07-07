package com.otus.spring.service;

import com.otus.spring.dao.TestDao;
import com.otus.spring.model.Score;
import com.otus.spring.model.TestData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

@Service
public class TestServiceImpl implements TestService {
    private final TestDao testDao;

    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public TestData createTest(int count) {
        List<Integer> keys = new Random().ints(count, 0, testDao.size() - 1).boxed().collect(toList());
        List<String> q = keys.stream().map(testDao::readQuestion).collect(toList());
        List<String> a = keys.stream().map(testDao::readAnswer).collect(toList());
        return new TestData(q, a);
    }

    @Override
    public Score getScore(TestData testData) {
        int score = 0;
        List<String> wrong = new ArrayList<>();
        for (int i = 0; i < testData.getAnswer().size(); i++) {
            if (testData.getAnswer().get(i).equals(testData.getAnswerFromUser().get(i))) {
                score++;
            } else {
                wrong.add(testData.getAnswerFromUser().get(i));
            }
        }
        return new Score(String.valueOf(score), wrong);
    }
}
