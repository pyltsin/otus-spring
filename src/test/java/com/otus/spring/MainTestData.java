package com.otus.spring;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Main.class)
@RunWith(SpringRunner.class)
public class MainTestData {
    @MockBean
    private AppRunner appRunner;
}