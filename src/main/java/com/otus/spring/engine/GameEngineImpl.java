package com.otus.spring.engine;

import com.otus.spring.dao.MessageHolder;
import com.otus.spring.model.User;
import com.otus.spring.service.Tester;
import com.otus.spring.view.UserReader;
import com.otus.spring.view.Writer;
import org.springframework.stereotype.Service;

@Service
public class GameEngineImpl implements GameEngine {
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
