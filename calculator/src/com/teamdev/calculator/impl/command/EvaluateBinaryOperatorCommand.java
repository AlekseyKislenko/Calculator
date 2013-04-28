package com.teamdev.calculator.impl.command;

import com.teamdev.calculator.BinaryOperator;
import com.teamdev.calculator.impl.EvaluationContext;

public class EvaluateBinaryOperatorCommand implements EvaluationCommand {

    private final BinaryOperator operator;

    public EvaluateBinaryOperatorCommand(BinaryOperator operator) {

        if (operator == null) {
            throw new NullPointerException("Null operator passed.");
        }

        this.operator = operator;
    }

    @Override
    public void evaluate(EvaluationContext context) {
        context.pushBinaryOperator(operator);
    }
}
