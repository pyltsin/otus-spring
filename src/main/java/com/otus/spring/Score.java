package com.otus.spring;

import lombok.Data;

import java.util.List;

@Data
public class Score {
    private final String score;

    private final List<String> wrongAnswer;
}
