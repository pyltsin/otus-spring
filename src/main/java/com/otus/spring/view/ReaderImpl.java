package com.otus.spring.view;

import com.otus.spring.dao.MessageHolder;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ReaderImpl implements Reader {
    private final Writer writer;
    private final MessageHolder messageHolder;

    public ReaderImpl(Writer writer, MessageHolder messageHolder) {
        this.writer = writer;
        this.messageHolder = messageHolder;
    }

    public String read() {
        String out = null;
        try {
            Scanner scanner = new Scanner(System.in);
            out = scanner.nextLine();
        } catch (RuntimeException e) {
            writer.print(messageHolder.exception(e));
        }

        return out;
    }
}
