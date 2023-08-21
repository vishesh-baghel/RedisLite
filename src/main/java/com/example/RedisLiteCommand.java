package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "RedisLite", description = "...",
        mixinStandardHelpOptions = true)
public class RedisLiteCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(RedisLiteCommand.class, args);
    }

    public void run() {
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
