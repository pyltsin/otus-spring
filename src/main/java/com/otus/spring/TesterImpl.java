package com.otus.spring;

public class TesterImpl implements Tester {
    private final Reader reader;
    private final Writer writer;
    private final TestService testService;
    private final MessageHolder messageHolder;
    private int count = 5;

    public void setCount(int count) {
        this.count = count;
    }

    public TesterImpl(Reader reader, Writer writer, TestService testService, MessageHolder messageHolder) {
        this.reader = reader;
        this.writer = writer;
        this.testService = testService;
        this.messageHolder = messageHolder;
    }

    public void start() {
        Test test = testService.createTest(count);
        for (int i = 0; i < count; i++) {
            writer.print(test.getQuestion(i));
            String answer = reader.read();
            test.setAnswer(i, answer);
        }
        writer.print(messageHolder.getAnswer(testService.getScore(test)));
    }
}
