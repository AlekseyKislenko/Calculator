package com.teamdev.calculator.function;

import java.math.BigDecimal;

public class MinFunction extends AbstractFunction {

    @Override
    public BigDecimal evaluate(BigDecimal... argument) {
        checkArguments(2, Integer.MAX_VALUE, argument);
        if (argument.length != 0) {
            BigDecimal minValue = argument[0];
            for (BigDecimal value : argument) {
                if (value.doubleValue() < minValue.doubleValue()) {
                    minValue = value;
                }
            }
            return minValue;
        } else {
            throw new IllegalArgumentException("No arguments");
        }
    }
}
