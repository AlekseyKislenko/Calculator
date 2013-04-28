package com.teamdev.calculator.impl.command;

import com.teamdev.calculator.impl.EvaluationContext;
import com.teamdev.calculator.impl.EvaluationException;

public class ClosingBracketCommand implements EvaluationCommand {

    @Override
    public void evaluate(EvaluationContext context) throws EvaluationException {
        context.pushClosingBracket();
    }
}
