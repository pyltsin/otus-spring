package com.otus.spring.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestDaoImpl implements TestDao {
    private List<String> questions;
    private List<String> answer;

    public TestDaoImpl(@Value("${question}") String pathToQuestion,
                       @Value("${answer}") String pathToAnswer) {
        questions = new ArrayList<>();
        answer = new ArrayList<>();
        fillList(questions, pathToQuestion);
        fillList(answer, pathToAnswer);
    }

    private void fillList(List<String> list, String path) {
        if (list == null) {
            list = new ArrayList<>();
        } else {
            list.clear();
        }

        try (Reader in = new InputStreamReader(getClass().getResourceAsStream(path))) {
            List<CSVRecord> records = CSVFormat.DEFAULT.parse(in).getRecords();
            for (CSVRecord record : records) {
                list.add(record.get(0));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int size(){
        return questions.size();
    }

    @Override
    public String readQuestion(int key) {
        return questions.get(key);
    }

    @Override
    public String readAnswer(int key) {
        return answer.get(key);
    }
}
