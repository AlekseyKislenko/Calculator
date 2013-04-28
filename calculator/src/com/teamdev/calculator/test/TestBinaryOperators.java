package com.teamdev.calculator.test;


import com.teamdev.calculator.impl.Calculator;
import com.teamdev.calculator.impl.EvaluationException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestBinaryOperators {

    private static Calculator calculator = new Calculator();

    @BeforeClass()
    public static void testInit() throws EvaluationException {
        calculator.evaluate("2+2");
    }

    @Test
    public void testPlusOperator() throws EvaluationException {
        assertEquals("Unexpected value for the operations of addition \"2+8\": ",
                new BigDecimal(10), calculator.evaluate("2+8"));
    }

    @Test
    public void testMinusOperator() throws EvaluationException {
        assertEquals("Unexpected value for the operations of subtraction \"10-7\": ",
                new BigDecimal(3), calculator.evaluate("10-7"));
    }

    @Test
    public void testMultiplyOperator() throws EvaluationException {
        assertEquals("Unexpected value for the operations of multiplication \"6*7\": ",
                new BigDecimal(42), calculator.evaluate("6*7"));
    }

    @Test
    public void testDivisionOperator() throws EvaluationException {
        assertEquals("Unexpected value for the operations of division \"40/5\": ",
                new BigDecimal(8), calculator.evaluate("40/5"));
    }

    @Test
    public void testFractionalDivision () throws EvaluationException {
        assertEquals("Unexpected value for the operations of division \"99,99/3\": ",
                new BigDecimal(33.33), calculator.evaluate("99,99/3"));
    }

    @Test
    public void testPowerOperator () throws EvaluationException {
        assertEquals("Unexpected value for the operations of exponentiation \"2^8\": ",
                new BigDecimal(256), calculator.evaluate("2^8"));
    }

    @Test
     public void testPriorityOperators () throws EvaluationException {
        assertEquals("Unexpected value priority operations \"25-3+6*20/10\": ",
                new BigDecimal(34), calculator.evaluate("25-3+6*20/10"));
    }

}



