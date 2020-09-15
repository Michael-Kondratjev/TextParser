package epam.textparser.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Gluing {

    void glueArithmeticExpressions(ArrayList<String> strings) {
        int size = strings.size();
        for (int i = 0; i < size-1; i++) {
            if (Validator.isArithmeticExpression(strings.get(i+1)) &&
                    Validator.isArithmeticExpression(strings.get(i))) {
                strings.set(i,strings.get(i) + strings.get(i+1));
                strings.remove(i+1);
                i--;
                size--;
            }
        }
    }
}
