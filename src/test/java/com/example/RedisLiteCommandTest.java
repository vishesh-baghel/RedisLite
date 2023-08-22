package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedisLiteCommandTest {

    @Test
    public void setCommandWithVerboseOption() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));

        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            String[] args = new String[] {"set", "--verbose" };
            PicocliRunner.run(RedisLiteCommand.class, ctx, args);
            out.println(baos);

            // RedisLite
            assertTrue(baos.toString().contains("verbose command running..."));
        }
    }

    @Test
    public void setCommandWithKeyAndValueOptions() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));

        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            String[] args = new String[] {"set", "-k", "toy" };
            PicocliRunner.run(RedisLiteCommand.class, ctx, args);
            out.println(baos);

            // RedisLite
            assertEquals("key command running...", baos.toString());
        }
    }
}
