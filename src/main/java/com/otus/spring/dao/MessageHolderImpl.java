package com.otus.spring.dao;

import com.otus.spring.model.MessagesProperties;
import com.otus.spring.model.Score;
import com.otus.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageHolderImpl implements MessageHolder {

    private final Locale locale;
    private final MessageSource ms;

    @Autowired
    public MessageHolderImpl(MessageSource messageSource,
                             MessagesProperties messagesProperties) {
        this.ms = messageSource;
        this.locale = Locale.forLanguageTag(messagesProperties.getLocale());
    }


    @Override
    public String hello() {
        return ms.getMessage("hello", new String[]{}, locale);
    }

    @Override
    public String buy(User user) {
        return ms.getMessage("buy", new String[]{user.getName()}, locale);
    }

    @Override
    public String getAnswer(Score score) {
        return ms.getMessage("score", new String[]{score.getScore()}, locale);
    }

    @Override
    public String getName() {
        return ms.getMessage("name", new String[]{}, locale);
    }

    @Override
    public String exception(RuntimeException e) {
        return ms.getMessage("exception", new String[]{e.getMessage()}, locale);
    }
}
