package epam.textparser.arithmetic;

import java.math.BigDecimal;
import java.util.*;

public class Calculator {

    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    public static final Map<String, Integer> MAIN_MATH_OPERATIONS;
    static {
        MAIN_MATH_OPERATIONS = new HashMap<>();
        MAIN_MATH_OPERATIONS.put("*", 1);
        MAIN_MATH_OPERATIONS.put("/", 1);
        MAIN_MATH_OPERATIONS.put("+", 2);
        MAIN_MATH_OPERATIONS.put("-", 2);
    }

    void calculateArithmeticExpression(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            if (Validator.isArithmeticExpression(strings.get(i))) {
                String result = calculateExpression(strings.get(i));
                strings.set(i,result);
            }
        }
    }

    public String calculateExpression(String expression) {
        String rpn = sortingStation(expression);
        StringTokenizer tokenizer = new StringTokenizer(rpn, " ");
        Stack<BigDecimal> stack = new Stack<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!MAIN_MATH_OPERATIONS.containsKey(token)) {
                stack.push(new BigDecimal(token));
            } else {
                BigDecimal operand2 = stack.pop();
                BigDecimal operand1 = stack.empty() ? BigDecimal.ZERO : stack.pop();
                switch (token) {
                    case "*":
                        stack.push(operand1.multiply(operand2));
                        break;
                    case "/":
                        stack.push(operand1.divide(operand2));
                        break;
                    case "+":
                        stack.push(operand1.add(operand2));
                        break;
                    case "-":
                        stack.push(operand1.subtract(operand2));
                        break;
                }
            }
        }
        if (stack.size() != 1)
            throw new IllegalArgumentException("Expression syntax error.");
        return stack.pop().toString();
    }


    public String sortingStation(String expression) {
        if (expression == null || expression.length() == 0)
            throw new IllegalStateException("Expression isn't specified.");
        if (Calculator.MAIN_MATH_OPERATIONS == null || Calculator.MAIN_MATH_OPERATIONS.isEmpty())
            throw new IllegalStateException("Operations aren't specified.");
        List<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        expression = expression.replace(" ", "");

        Set<String> operationSymbols = new HashSet<>(Calculator.MAIN_MATH_OPERATIONS.keySet());
        operationSymbols.add(LEFT_BRACKET);
        operationSymbols.add(RIGHT_BRACKET);

        int index = 0;
        boolean findNext = true;
        while (findNext) {
            int nextOperationIndex = expression.length();
            String nextOperation = "";
            for (String operation : operationSymbols) {
                int i = expression.indexOf(operation, index);
                if (i >= 0 && i < nextOperationIndex) {
                    nextOperation = operation;
                    nextOperationIndex = i;
                }
            }

            if (nextOperationIndex == expression.length()) {
                findNext = false;
            } else {
                if (index != nextOperationIndex) {
                    out.add(expression.substring(index, nextOperationIndex));
                }
                if (nextOperation.equals(LEFT_BRACKET)) {
                    stack.push(nextOperation);
                } else if (nextOperation.equals(RIGHT_BRACKET)) {
                    while (!stack.peek().equals(LEFT_BRACKET)) {
                        out.add(stack.pop());
                        if (stack.empty()) {
                            throw new IllegalArgumentException("Unmatched brackets");
                        }
                    }
                    stack.pop();
                } else {
                    while (!stack.empty() && !stack.peek().equals(LEFT_BRACKET) &&
                            (Calculator.MAIN_MATH_OPERATIONS.get(nextOperation) >= Calculator.MAIN_MATH_OPERATIONS.get(stack.peek()))) {
                        out.add(stack.pop());
                    }
                    stack.push(nextOperation);
                }
                index = nextOperationIndex + nextOperation.length();
            }
        }
        if (index != expression.length()) {
            out.add(expression.substring(index));
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        if (!out.isEmpty())
            result.append(out.remove(0));
        while (!out.isEmpty())
            result.append(" ").append(out.remove(0));

        return result.toString();
    }


}
