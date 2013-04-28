package com.teamdev.calculator.test;


import com.teamdev.calculator.impl.Calculator;
import com.teamdev.calculator.impl.EvaluationException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestFunctions {
    Calculator calculator;

    @Test
    public void testMinFunction() throws EvaluationException {
        calculator = new Calculator();
        assertEquals("Unexpected value for the operations of function \"min(2;3;5;1;7)\": ",
                new BigDecimal(1),
                calculator.evaluate("min(2+6*2;3;5;1;7)"));
    }

    @Test
    public void testMaxFunction() throws EvaluationException {
        calculator = new Calculator();
        assertEquals("Unexpected value for the operations of function \"max(5;8;7;15;10)\": ",
                new BigDecimal(15),
                calculator.evaluate("max(5;8;7;15;10)"));
    }


    @Test
    public void testSumFunction() throws EvaluationException {
        calculator = new Calculator();
        assertEquals("Unexpected value for the operations of function \"sum(2;3;4)\": ",
                new BigDecimal(9),
                calculator.evaluate("sum(2;3;4)"));
    }

    @Test
    public void testSqrtFunction() throws EvaluationException {
        calculator = new Calculator();
        assertEquals("Unexpected value for the operations of function \"sqrt(16)\": ",
                BigDecimal.valueOf(4d),
                calculator.evaluate("sqrt(16)"));
    }

    @Test
    public void testMultiFunction() throws EvaluationException {
        calculator = new Calculator();
        assertEquals("Unexpected value for the operations of function \"sum(sqrt(16);min(7;5;3;6);max(1;5;3;2))\": ",
                BigDecimal.valueOf(12),
                calculator.evaluate("sum(min(7;5;3;6);max(1;5;3;2)))"));
    }

}



