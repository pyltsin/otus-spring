package com.otus.spring;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl implements TestDao {
    private List<String> questions;
    private List<String> answer;

    public TestDaoImpl(String pathToQuestion, String pathToAnswer) {
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
    public String readQuestion(int key) {
        return questions.get(key);
    }

    @Override
    public String readAnswer(int key) {
        return answer.get(key);
    }
}
