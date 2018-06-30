package com.otus.spring;

public class MessageHolderImpl implements MessageHolder {
    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public String buy(User user) {
        return "Buy " +user.getName();
    }

    @Override
    public String getAnswer(Score score) {
        return "Score: " +score.getScore();
    }

    @Override
    public String getName() {
        return "What is your name?";
    }

    @Override
    public String exception(RuntimeException e) {
        return "Exception: " + e.getMessage();
    }
}
