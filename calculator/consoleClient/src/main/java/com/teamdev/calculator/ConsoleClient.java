package com.teamdev.calculator;

import com.teamdev.calculator.impl.Calculator;
import com.teamdev.calculator.impl.EvaluationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import static java.lang.System.in;
import static java.lang.System.out;

public class ConsoleClient {

    public static void run() throws IOException {

        String expression = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            for (; ; ) {
                out.println("Input empty expression for exit");
                out.println("Input expression: ");

                expression = reader.readLine();

                if (expression.equals("")) break;
                final BigDecimal result = new Calculator().evaluate(expression);
                out.println("result = " + result);

            }
        } catch (EvaluationException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        if ((args.length == 1) && (args[0].equals("/console"))) {
            run();
        }
    }
}
