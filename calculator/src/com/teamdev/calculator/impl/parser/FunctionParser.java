package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.Function;
import com.teamdev.calculator.function.FunctionFactory;
import com.teamdev.calculator.impl.MathExpressionReader;
import com.teamdev.calculator.impl.command.EvaluateFunctionCommand;
import com.teamdev.calculator.impl.command.EvaluationCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionParser implements MathExpressionParser {

    final Pattern pattern = Pattern.compile("[a-zA-Z]*[a-zA-Z0-9]");
    private final FunctionFactory factory = new FunctionFactory();
    StringBuilder functionNameBuilder = new StringBuilder();

    private boolean doMatch(String charToMatch) {
        Matcher matcher = pattern.matcher(charToMatch);
        if (matcher.matches()) {
            return true;
        } else
            return false;
    }

    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {
        if (reader.endOfExpression()) {
            return null;
        }

        String current = String.valueOf(reader.getCurrentChar());

        while (doMatch(current)) {
            functionNameBuilder.append(current);
            System.out.print(current);
            reader.incReadPosition();
            current = String.valueOf(reader.getCurrentChar());
        }

        if (factory.functionNames().contains(functionNameBuilder.toString())){
            final Function function = factory.createFunction(functionNameBuilder.toString());
            if (function != null) {
                return new EvaluateFunctionCommand(function);
            }

        } return null;
    }
}


