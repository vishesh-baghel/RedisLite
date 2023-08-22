package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "RedisLite", description = "RedisLite is a simple redis cli tool implemented with java",
        mixinStandardHelpOptions = true, subcommands = {SetCommand.class})
public class RedisLiteCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "It shows the command details")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(RedisLiteCommand.class, args);
    }

    public void run() {
        if (verbose) {
            System.out.println("verbose command is running...");
        }
    }
}
