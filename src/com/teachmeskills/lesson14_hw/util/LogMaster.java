package com.teachmeskills.lesson14_hw.util;

import com.teachmeskills.lesson14_hw.consts.ConstPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * A universal class with an "addLog" method that accepts a path and a message that should be written to this path
 */
public class LogMaster {
    public static void addLog(String path, String message) throws IOException {
        try {
            if(Files.exists(Paths.get(path))){
                Files.write(Paths.get(path), (message + "\n").getBytes(), StandardOpenOption.APPEND);
            }else {
                throw new FileNotFoundException(path);
            }
        } catch (IOException e) {
            Files.write(Paths.get(ConstPath.PATH_ERROR_LOG_TXT) , ("Ошибка, путь к файлу " + e.getMessage() + " не найден. \n").getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("ДРУГАЯ ОШИБКА");
        }
    }
}
