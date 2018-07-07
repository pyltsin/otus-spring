package com.otus.spring.model;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    private final List<String> question;
    private final List<String> answer;
    private final List<String> answerFromUser;

    public TestData(List<String> question, List<String> answer) {
        this.question = question;
        this.answer = answer;
        answerFromUser = new ArrayList<>(question.size());
        question.stream().map(s -> "").forEach(answerFromUser::add);
    }

    public String getQuestion(int i) {
        return question.get(i);
    }

    public void setAnswer(int i, String answer) {
        answerFromUser.set(i, answer);
    }

    public List<String> getAnswer() {
        return answer;
    }

    public List<String> getAnswerFromUser() {
        return answerFromUser;
    }
}
