package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.MathExpressionReader;
import com.teamdev.calculator.impl.command.EvaluationCommand;
import com.teamdev.calculator.impl.command.FunctionSeparatorCommand;

public class FunctionSeparatorParser implements MathExpressionParser {


    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {
        if (reader.endOfExpression()) {
            return null;
        }
        if (reader.getCurrentChar() == ';') {
            reader.incReadPosition();
            return new FunctionSeparatorCommand();
        }
        return null;
    }
}
