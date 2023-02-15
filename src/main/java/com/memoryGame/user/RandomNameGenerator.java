package com.memoryGame.user;

import com.github.javafaker.Faker;

public class RandomNameGenerator {
    Faker fk;
    RandomNameGenerator() {
        fk = new Faker();
    }

    public String randomName() {
        return fk.pokemon().name();
    }
}
