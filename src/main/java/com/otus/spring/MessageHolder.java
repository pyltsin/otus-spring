package com.otus.spring;

public interface MessageHolder {
    String hello();

    String buy(User user);

    String getAnswer(Score score);

    String getName();

    String exception(RuntimeException e);
}
