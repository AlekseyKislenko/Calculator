package com.teamdev.calculator.function;

import java.math.BigDecimal;

public class SqrtFunction extends AbstractFunction {

    @Override
    public BigDecimal evaluate(BigDecimal... arguments) {
        checkArguments(1, 1, arguments);
        BigDecimal result = BigDecimal.valueOf(Math.sqrt(arguments[0].intValue()));
        return result;
    }
}
