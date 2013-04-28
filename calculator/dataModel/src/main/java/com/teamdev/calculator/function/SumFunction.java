package com.teamdev.calculator.function;

import java.math.BigDecimal;

public class SumFunction extends AbstractFunction {

    @Override
    public BigDecimal evaluate(BigDecimal... arguments) {
        checkArguments(2, Integer.MAX_VALUE, arguments);
        BigDecimal result = new BigDecimal(0);
        for (BigDecimal value : arguments) {
            result = result.add(value);
        }
        return result;
    }
}
