package com.teamdev.calculator.test;


import com.teamdev.calculator.impl.Calculator;
import com.teamdev.calculator.impl.EvaluationException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBrackets {

    @Test
    public void testMinusPlusOperatorWithBracket()
            throws EvaluationException {
        assertEquals("Problem when performing operations sum and minus with bracket.",
                new BigDecimal(0), new Calculator().evaluate("2-(1+1)"));
    }

    @Test
    public void testDivideMultiplyOperatorWithBrackets()
            throws EvaluationException {
        assertEquals("Problem when performing operations divide and multiply with bracket.",
                new BigDecimal(3), new Calculator().evaluate("3*(2/2)"));
    }

    @Test
    public void testAllOperatorsWithBracket() throws EvaluationException {
        assertEquals("Unexpected value priority operations \"6*9-(36+48/8)\":",
                new BigDecimal(12), new Calculator().evaluate("6*9-(36+48/8)"));

        assertEquals("Unexpected value priority operations \"2^(4/2)+(3*3)^0,5\":",
                new BigDecimal(7), new Calculator().evaluate("2^(4/2)+(3*3)^0,5"));

        assertEquals("Unexpected value priority operations \"25-(3+6)*(20/10)\": ",
                new BigDecimal(7), new Calculator().evaluate("25-(3+6)*(20/10)"));
    }
}



