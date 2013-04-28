package com.teamdev.calculator.function;

import java.math.BigDecimal;

public class MaxFunction extends AbstractFunction {

    @Override
    public BigDecimal evaluate(BigDecimal... argument) {
        checkArguments(2, Integer.MAX_VALUE, argument);
        if (argument.length != 0) {
            BigDecimal maxValue = argument[0];
            for (BigDecimal value : argument) {
                if (value.doubleValue() > maxValue.doubleValue()) {
                    maxValue = value;
                }
            }
            return maxValue;
        } else {
            throw new IllegalArgumentException("No arguments");
        }

    }
}
