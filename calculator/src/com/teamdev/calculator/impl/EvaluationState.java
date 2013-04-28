package com.teamdev.calculator.impl;

public enum EvaluationState {
    START,
    NUMBER,
    BINARY_OPERATOR,
    OPENING_BRACKET,
    CLOSING_BRACKET,
    FUNCTION,
    FUNCTION_SEPARATOR,
    FINISH
}
