package com.otus.spring;

import com.otus.spring.engine.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final GameEngine game;

    @Autowired
    public AppRunner(GameEngine game) {
        this.game = game;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        game.start();
    }
}