
package com.teamdev.calculator.impl;

import com.teamdev.calculator.BinaryOperator;
import com.teamdev.calculator.Function;
import com.teamdev.calculator.statemachine.StateMachineContext;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class EvaluationContext implements StateMachineContext<
        EvaluationState, BigDecimal> {

    private final MathExpressionReader expressionReader;
    private final Deque<BigDecimal> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<>();
    private final Deque<Integer> bracketStack = new ArrayDeque<>();
    private final Deque<Function> functionStack = new ArrayDeque<>();
    private final Deque<Integer> functionOperand = new ArrayDeque<>();
    private final Deque<Integer> functionOperator = new ArrayDeque<>();
    private final ArrayList<BigDecimal> arguments = new ArrayList<>();
    private EvaluationState state;
    private int operatorStackSize;

    public EvaluationContext(String expression) {
        expressionReader = new MathExpressionReader(expression);
    }

    public MathExpressionReader getExpressionReader() {
        return expressionReader;
    }

    @Override
    public EvaluationState getState() {
        return state;
    }

    @Override
    public void setState(EvaluationState state) {
        this.state = state;
    }

    public void pushOperand(BigDecimal operand) {
        operandStack.push(operand);
    }

    public void pushBinaryOperator(BinaryOperator binaryOperator) {
        BinaryOperator topOperator = null;
        do {
            if (!bracketStack.isEmpty()) {
                if (operatorStack.size() > bracketStack.peek()) {
                    topOperator = operatorStack.peek();
                }
            } else topOperator = operatorStack.peek();
            if (topOperator != null) {
                if (binaryOperator.compareTo(topOperator) < 1) {
                    executeBinaryOperator(topOperator);
                    operatorStack.pop();
                } else {
                    break;
                }
            }
        } while (topOperator != null);
        operatorStack.push(binaryOperator);
    }

    private void executeBinaryOperator(BinaryOperator topOperator) {
        final BigDecimal rightOperand = operandStack.pop();
        final BigDecimal leftOperand = operandStack.pop();
        final BigDecimal result = topOperator.evaluate(
                leftOperand, rightOperand);
        pushOperand(result);
    }

    public void popBinaryOperators() {
        while (!operatorStack.isEmpty()) {
            executeBinaryOperator(operatorStack.pop());
        }
    }

    public void pushOpeningBracket() {
        bracketStack.push(operatorStack.size());
    }

    public void pushClosingBracket() throws EvaluationException {
        if (bracketStack.isEmpty()) {
            throw new EvaluationException("Unexpected superfluous close brackets or missing open bracket",
                    expressionReader.getReadPosition());
        }
        if (!bracketStack.isEmpty()) {
            operatorStackSize = bracketStack.peek();
            while (operatorStack.size() > operatorStackSize) {
                executeBinaryOperator(operatorStack.pop());
            }
            if (!functionOperator.isEmpty()) {
                if (operatorStackSize == functionOperator.peek()) {
                    popFunction();
                }
            }
            bracketStack.pop();
        } else {
            while (operatorStack.size() > 0) {
                executeBinaryOperator(operatorStack.pop());
            }
        }
    }

    public void pushFunction(Function function) {
        functionStack.push(function);
        functionOperand.push(operandStack.size());
        functionOperator.push(operatorStack.size());
    }

    public void popFunction() {
        if (!functionStack.isEmpty()) {
            final Function function = functionStack.pop();
            while (operandStack.size() != functionOperand.peek()) {
                arguments.add(operandStack.pop());
            }
            pushOperand(function.evaluate(arguments.toArray(new BigDecimal[arguments.size()])));
            functionOperator.pop();
            functionOperand.pop();
        }
    }

    public void pushFunctionSeparator() {
        final int operatorStackSize = functionOperator.peek();
        while (operatorStack.size() > operatorStackSize) {
            executeBinaryOperator(operatorStack.pop());
        }
        arguments.add(operandStack.pop());
    }

    @Override
    public BigDecimal getResult() {
        BigDecimal result = operandStack.pop();
        return result;
    }
}
