package com.teamdev.calculator.impl;

import com.teamdev.calculator.statemachine.TransitionMatrix;

import java.util.EnumSet;
import java.util.Set;

import static com.teamdev.calculator.impl.EvaluationState.*;

public class EvaluationMatrix implements
        TransitionMatrix<EvaluationState> {

    @Override
    public EvaluationState getStartState() {
        return EvaluationState.START;
    }

    @Override
    public boolean isFinishState(EvaluationState evaluationState) {
        return FINISH == evaluationState;
    }

    @Override
    public Set<EvaluationState> getPossibleStates(EvaluationState currentState) {

        switch (currentState) {
            case START:
                return EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION);
            case NUMBER:
                return EnumSet.of(BINARY_OPERATOR, CLOSING_BRACKET, FUNCTION_SEPARATOR, FINISH);
            case BINARY_OPERATOR:
                return EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION);
            case OPENING_BRACKET:
                return EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION);
            case CLOSING_BRACKET:
                return EnumSet.of(CLOSING_BRACKET, BINARY_OPERATOR, FUNCTION_SEPARATOR, FINISH);
            case FUNCTION:
                return EnumSet.of(OPENING_BRACKET);
            case FUNCTION_SEPARATOR:
                return EnumSet.of(OPENING_BRACKET, NUMBER, FUNCTION);
        }


        return EnumSet.noneOf(EvaluationState.class);
    }
}
