package com.otus.spring.service;

import com.otus.spring.MainTestData;
import com.otus.spring.model.TestData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestServiceData extends MainTestData {

    @Autowired
    private TestService testService;

    @Test
    public void getScore() {
        TestData test2 = new TestData(Arrays.asList("1", "2"), Arrays.asList("1", "2"));
        test2.setAnswer(0, "1");
        test2.setAnswer(1, "2");
        TestData test1 = new TestData(Arrays.asList("2", "2"), Arrays.asList("1", "2"));
        assertEquals(testService.getScore(test2).getScore(),"2");
        assertEquals(testService.getScore(test1).getScore(),"0");
    }
}