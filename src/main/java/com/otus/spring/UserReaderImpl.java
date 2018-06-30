package com.otus.spring;

public class UserReaderImpl implements UserReader {
    private final Writer writer;
    private final Reader reader;
    private final MessageHolder messageHolder;

    public UserReaderImpl(Writer writer, Reader reader, MessageHolder messageHolder) {
        this.writer = writer;
        this.reader = reader;
        this.messageHolder = messageHolder;
    }

    @Override
    public User readUser() {
        writer.print(messageHolder.getName());
        return new User(reader.read());
    }
}
