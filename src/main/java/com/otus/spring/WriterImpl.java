package com.otus.spring;

public class WriterImpl implements Writer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
