package com.example;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Configuration;
import io.micronaut.context.annotation.ConfigurationInject;

public class Storage {
    String key = "";
    String value = "";
    public Storage(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Bean
    void saveKeyValuePair() {
        System.out.println("saved the pair");
    }
}
