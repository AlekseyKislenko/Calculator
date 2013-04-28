package com.teamdev.calculator.impl.command;

import com.teamdev.calculator.impl.EvaluationContext;
import com.teamdev.calculator.impl.EvaluationException;

public interface EvaluationCommand {
    void evaluate(EvaluationContext context) throws EvaluationException;
}
