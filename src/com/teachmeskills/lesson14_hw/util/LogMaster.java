package com.teachmeskills.lesson14_hw.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * A universal class with an "addLog" method that accepts a path and a message that should be written to this path
 */
public class LogMaster {
    public static void addLog(String path, String message){
        try {
            Files.write(Paths.get(path), (message + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("FHIJFHISH!!!!");
        }
    }
}
