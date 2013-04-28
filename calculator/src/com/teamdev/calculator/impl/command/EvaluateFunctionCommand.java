package com.teamdev.calculator.impl.command;


import com.teamdev.calculator.Function;
import com.teamdev.calculator.impl.EvaluationContext;

public class EvaluateFunctionCommand implements EvaluationCommand {


    private final Function function;

    public EvaluateFunctionCommand(Function function) {
        this.function = function;
    }

    @Override
    public void evaluate(EvaluationContext context) {
        context.pushFunction(function);
    }
}
