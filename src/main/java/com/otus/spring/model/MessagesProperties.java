package com.otus.spring.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "messages")
@Getter
@Setter
public class MessagesProperties {
    private String path;
    private String locale;
}
