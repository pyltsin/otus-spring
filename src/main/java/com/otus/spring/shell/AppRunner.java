package com.otus.spring.shell;

import com.otus.spring.engine.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AppRunner {

    private final GameEngine game;

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    public AppRunner(GameEngine game) {
        this.game = game;
    }

    @ShellMethod("Start test with number questions")
    public void start(@ShellOption(defaultValue = "5") int countQuestion) {
        CustomPromptProvider.start = false;
        game.start(countQuestion);
    }

    @ShellMethod("End test")
    public void stop() {
        int exitCode = SpringApplication.exit(ctx, (ExitCodeGenerator) () -> {
            // return the error code
            return 0;
        });

        System.exit(exitCode);
    }
}
