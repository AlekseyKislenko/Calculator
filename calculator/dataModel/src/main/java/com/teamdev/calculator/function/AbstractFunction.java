package com.teamdev.calculator.function;

import com.teamdev.calculator.Function;

import java.math.BigDecimal;

abstract class AbstractFunction implements Function {

    protected AbstractFunction() {
    }

    protected void checkArguments(int minCount, int maxCount,
                                  BigDecimal... arguments) {

        if (arguments.length < minCount) {
            throw new IllegalArgumentException("Not enough arguments for this function. " +
                    "Minimum argument count = " + minCount);
        } else {
            if (arguments.length > maxCount) {
                throw new IllegalArgumentException("Argument count for this function over the limit. " +
                        "Maximum argument count = " + maxCount);
            }
        }
    }
}



