package com.teachmeskills.lesson14_hw.custom_exception;

/**
 * Custom exception if the document is not valid
 */
public class WrongDocumentFormatException extends Exception{
    private int validationErrorCode;

    public WrongDocumentFormatException(String message, int validationErrorCode) {
        super(message);
        this.validationErrorCode = validationErrorCode;
    }
}
