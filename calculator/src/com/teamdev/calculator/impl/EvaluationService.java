package com.teamdev.calculator.impl;

import com.teamdev.calculator.impl.command.EvaluationCommand;
import com.teamdev.calculator.impl.parser.*;
import com.teamdev.calculator.statemachine.StateRecognizer;

import java.util.EnumMap;
import java.util.Map;

import static com.teamdev.calculator.impl.EvaluationState.*;

/**
 * This is sample implementation, do not use for production code!!!!!
 */
public class EvaluationService implements
        StateRecognizer<EvaluationState, EvaluationContext> {

    private Map<EvaluationState, MathExpressionParser> parserRegistry =
            new EnumMap<EvaluationState, MathExpressionParser>
                    (EvaluationState.class) {{
                    put(NUMBER, new NumberParser());
                    put(BINARY_OPERATOR, new BinaryOperatorParser());
                    put(OPENING_BRACKET, new OpeningBracketParser());
                    put(CLOSING_BRACKET, new ClosingBracketParser());
                    put(FUNCTION, new FunctionParser());
                    put(FUNCTION_SEPARATOR, new FunctionSeparatorParser());
                    put(FINISH, new EndOfExpressionParser());

                }};


    @Override
    public boolean accept(EvaluationState possibleState,
                          EvaluationContext context) {

        final MathExpressionParser parser =
                parserRegistry.get(possibleState);

        if (parser == null) {
            throw new IllegalStateException(
                    "Parser not found for state: " + possibleState);
        }

        final EvaluationCommand command =
                parser.parse(context.getExpressionReader());

        if (command == null) {
            return false;
        }

        try {
            command.evaluate(context);
        } catch (EvaluationException e) {

        }

        return true;
    }
}
