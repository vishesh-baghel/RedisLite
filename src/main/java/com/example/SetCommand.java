package com.example;

import jakarta.inject.Inject;
import picocli.CommandLine.*;

@Command(name = "set", description = "Set the key value pair for the storage", mixinStandardHelpOptions = true)
public class SetCommand implements Runnable{

    @Option(names = {"-k", "--key"}, description = "Set the key for the value you want to store")
    String key = "";

    @Option(names = {"-val", "--value"}, description = "Set the value for the given key")
    String value = "";

    @Option(names = {"-v", "--verbose"}, description = "Details for the command")
    boolean verbose;

    @Inject
    Storage storage;

    @Override
    public void run() {
       storage.saveKeyValuePair();
    }
}
