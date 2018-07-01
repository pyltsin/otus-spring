package com.otus.spring.dao;

import com.otus.spring.model.Score;
import com.otus.spring.model.User;

public interface MessageHolder {
    String hello();

    String buy(User user);

    String getAnswer(Score score);

    String getName();

    String exception(RuntimeException e);
}
