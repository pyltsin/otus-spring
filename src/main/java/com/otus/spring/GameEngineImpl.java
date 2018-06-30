package com.otus.spring;

public class GameEngineImpl implements  GameEngine{
    private final Writer writer;
    private final Tester tester;
    private final UserReader userReader;
    private final MessageHolder messageHolder;

    public GameEngineImpl(Writer writer, Tester tester, UserReader userReader, MessageHolder messageHolder) {
        this.writer = writer;
        this.tester = tester;
        this.userReader = userReader;
        this.messageHolder = messageHolder;
    }

    public void start() {
        writer.print(messageHolder.hello());
        User user = userReader.readUser();
        tester.start();
        writer.print(messageHolder.buy(user));
    }
}
