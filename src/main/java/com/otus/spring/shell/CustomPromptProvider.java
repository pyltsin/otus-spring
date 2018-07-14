package com.otus.spring.shell;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomPromptProvider implements PromptProvider {

    public static boolean start = true;

    @Override
    public AttributedString getPrompt() {
        return new AttributedString((start ? "Enter 'start'" : "Enter 'stop'") + ":>");
    }
}
