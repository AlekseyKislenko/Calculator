package com.teamdev.calculator.function;

import com.teamdev.calculator.Function;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class FunctionFactory {

    private final Map<String, Function> functionMap = new HashMap();

    public FunctionFactory() {
        functionMap.put("min", new MinFunction());
        functionMap.put("max", new MaxFunction());
        functionMap.put("sum", new SumFunction());
        functionMap.put("sqrt", new SqrtFunction());
    }

    public Collection<String> functionNames() {
        return functionMap.keySet();
    }

    public Function createFunction(String function) {

        if ((function != null) && (functionMap.containsKey(function))) {
            return functionMap.get(function);
        } else
            throw new IllegalArgumentException(function + " - is nonexistent function");
    }
}

