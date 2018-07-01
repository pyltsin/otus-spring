package com.otus.spring.dao;

public interface TestDao {
    int size();

    String readQuestion(int key);

    String readAnswer(int key);
}
