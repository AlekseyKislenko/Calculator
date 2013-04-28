package com.teamdev.calculator.impl.parser;

import com.teamdev.calculator.impl.MathExpressionReader;
import com.teamdev.calculator.impl.command.EvaluateNumberCommand;
import com.teamdev.calculator.impl.command.EvaluationCommand;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class NumberParser implements MathExpressionParser {

    private static final NumberFormat NUMBER_FORMAT =
            new DecimalFormat("0.0");

    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {

        final ParsePosition position =
                new ParsePosition(reader.getReadPosition());

        final Number number =
                NUMBER_FORMAT.parse(reader.getExpression(), position);

        if (position.getErrorIndex() < 0) {

            final int readPosition = position.getIndex();
            reader.setReadPosition(readPosition);

            return new EvaluateNumberCommand(
                    new BigDecimal(number.doubleValue()));
        }

        return null;
    }
}
