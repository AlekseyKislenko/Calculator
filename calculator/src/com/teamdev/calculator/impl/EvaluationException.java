package com.teamdev.calculator.impl;

/**
 * This is sample implementation, do not use for production code!!!!!
 */
public class EvaluationException extends Exception {

    private int errorPosition;

    public EvaluationException(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }
}
