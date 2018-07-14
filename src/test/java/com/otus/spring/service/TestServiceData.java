package com.otus.spring.service;

import com.otus.spring.model.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@SpringBootTest(properties = {
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false",
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"
})
@RunWith(SpringRunner.class)
public class TestServiceData  {

    @Autowired
    private TestService testService;

    @Test
    public void getScore() {
        TestData test2 = new TestData(Arrays.asList("1", "2"), Arrays.asList("1", "2"));
        test2.setAnswer(0, "1");
        test2.setAnswer(1, "2");
        TestData test1 = new TestData(Arrays.asList("2", "2"), Arrays.asList("1", "2"));
        assertEquals(testService.getScore(test2).getScore(), "2");
        assertEquals(testService.getScore(test1).getScore(), "0");
    }
}