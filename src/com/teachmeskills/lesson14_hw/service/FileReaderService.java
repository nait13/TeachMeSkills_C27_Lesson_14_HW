package com.teachmeskills.lesson14_hw.service;

import com.teachmeskills.lesson14_hw.consts.ConstPath;
import com.teachmeskills.lesson14_hw.consts.Consts;
import com.teachmeskills.lesson14_hw.custom_exception.WrongDocumentFormatException;
import com.teachmeskills.lesson14_hw.util.LogMaster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.teachmeskills.lesson14_hw.validator.DocumentValidator.checkDocumentNumberAndContract;

/**
 * This class reads a file containing document and contract numbers, writes valid documents to one file, valid contracts to another, and throws exceptions
 */
public class FileReaderService {
    public static void readInformationFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ConstPath.FILE_DOCUMENT))) {
            LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Начало работы программы");
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                try {
                    if (checkDocumentNumberAndContract(line)) {
                        if (line.startsWith(Consts.CONTRACT_START_NAME_REGEXP)) {
                            LogMaster.addLog(ConstPath.PATH_VALID_CONTRACT, line);

                        } else if (line.startsWith(Consts.DOC_START_NAME_REGEXP)) {
                            LogMaster.addLog(ConstPath.PATH_VALID_DOCUMENT, line);
                        }
                    }
                } catch (WrongDocumentFormatException e) {
                    LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Ошибка: " + e.getMessage() + "\n");
                    LogMaster.addLog(ConstPath.INVALID_DOCUMENT, e.getMessage());
                }
                line = reader.readLine();
            }
            LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Сканирования документа окончено!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка! файл " + e.getMessage() + " не найден.");
        } catch (Exception e) {
            System.out.println("Какая-та другая ошибка!");
        }
    }
}
