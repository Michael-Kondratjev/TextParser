package epam.textparser.arithmetic;

import java.util.ArrayList;

public class ArithmeticExpressionProcessing {


    public void process(ArrayList<String> strings) {
        VariableReplacement variableReplacement = new VariableReplacement();
        Gluing gluing = new Gluing();
        Calculation calculation = new Calculation();

        variableReplacement.replaceVariableI(strings);
        variableReplacement.replaceVariableJ(strings);
        gluing.glueArithmeticExpressions(strings);
        calculation.calculateArithmeticExpression(strings);
    }


}
