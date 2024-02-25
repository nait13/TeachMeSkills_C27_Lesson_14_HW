package com.teachmeskills.lesson14_hw.validator;

import com.teachmeskills.lesson14_hw.consts.ConstPath;
import com.teachmeskills.lesson14_hw.consts.Consts;
import com.teachmeskills.lesson14_hw.custom_exception.WrongDocumentFormatException;
import com.teachmeskills.lesson14_hw.util.LogMaster;

import java.io.IOException;

/**
 * This class takes a string and checks it against the given format
 */
public class DocumentValidator {
    public static boolean checkDocumentNumberAndContract(String string) throws WrongDocumentFormatException, IOException {
        if (string.isEmpty()) return false;

        LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Проверка на валидность документа: " + string);
        LogMaster.addLog(ConstPath.PATH_LOG_TXT, "***Длинна строки: ***");

        if (string.length() != Consts.LENGTH_DOCUMENT_REGEXP) {
            throw new WrongDocumentFormatException(string + " Не валидная длинна договора!", 102);
        } else {
            LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Ок");
        }

        LogMaster.addLog(ConstPath.PATH_LOG_TXT, "***Документ начинается на " + Consts.DOC_START_NAME_REGEXP + " или " + Consts.CONTRACT_START_NAME_REGEXP + "***");

        if (!string.startsWith(Consts.CONTRACT_START_NAME_REGEXP) && !string.startsWith(Consts.DOC_START_NAME_REGEXP)) {
            throw new WrongDocumentFormatException(string + " Не валидное имя контракта ", 101);
        } else {
            LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Ок");
        }

        LogMaster.addLog(ConstPath.PATH_LOG_TXT, "***Проверка на служебные символы***");

        if (string.matches(Consts.rg)) {
            throw new WrongDocumentFormatException(string + " Документ содержит служебные символы!", 400);
        } else {
            LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Ок");
            LogMaster.addLog(ConstPath.PATH_LOG_TXT, "Документ валиден! \n");
            return true;
        }
    }
}
