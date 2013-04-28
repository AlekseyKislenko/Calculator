package com.teamdev.calculator.impl.command;

import com.teamdev.calculator.impl.EvaluationContext;

public class FinishEvaluationCommand implements EvaluationCommand {

    @Override
    public void evaluate(EvaluationContext context) {
        context.popBinaryOperators();
    }
}
