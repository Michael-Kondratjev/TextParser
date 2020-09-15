package epam.textparser.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticExpressionProcessing {


    public void process(ArrayList<String> strings) {
        VariableReplacement variableReplacement = new VariableReplacement();
        Gluing gluing = new Gluing();
        Calculator calculator = new Calculator();

        variableReplacement.replaceVariableI(strings);
        variableReplacement.replaceVariableJ(strings);
        gluing.glueArithmeticExpressions(strings);
        calculator.calculateArithmeticExpression(strings);
    }


}
