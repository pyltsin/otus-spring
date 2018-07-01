package com.otus.spring.view;

import org.springframework.stereotype.Service;

@Service
public class WriterImpl implements Writer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
