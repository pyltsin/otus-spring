package com.otus.spring;

import java.io.Console;
import java.util.Scanner;

public class ReaderImpl implements Reader {
    private final Writer writer;
    private Scanner scanner;
    private final MessageHolder messageHolder;

    public ReaderImpl(Writer writer, MessageHolder messageHolder) {
        this.writer = writer;
        this.messageHolder = messageHolder;
        this.scanner = new Scanner(System.in);
    }

    public String read() {
        String out = null;
        try {
            out = scanner.nextLine();
        } catch (RuntimeException e) {
            writer.print(messageHolder.exception(e));
        }

        return out;
    }
}
