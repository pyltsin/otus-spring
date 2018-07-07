package com.otus.spring.service;

import com.otus.spring.dao.MessageHolder;
import com.otus.spring.model.TestData;
import com.otus.spring.view.Reader;
import com.otus.spring.view.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TesterImpl implements Tester {
    private final Reader reader;
    private final Writer writer;
    private final TestService testService;
    private final MessageHolder messageHolder;
    private int count = 5;

    public int getCount() {
        return count;
    }

    @Autowired
    public void setCount(@Value("${task.count}") int count) {
        this.count = count;
    }

    public TesterImpl(Reader reader, Writer writer, TestService testService, MessageHolder messageHolder) {
        this.reader = reader;
        this.writer = writer;
        this.testService = testService;
        this.messageHolder = messageHolder;
    }

    public void start() {
        TestData testData = testService.createTest(count);
        for (int i = 0; i < count; i++) {
            writer.print(testData.getQuestion(i));
            String answer = reader.read();
            testData.setAnswer(i, answer);
        }
        writer.print(messageHolder.getAnswer(testService.getScore(testData)));
    }
}
