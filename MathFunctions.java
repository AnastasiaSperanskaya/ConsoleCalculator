package calc;

import java.util.ArrayList;
import java.lang.Math;

public class MathFunctions {
    final private String[] advOperatorList = { "sqrt", "sin", "cos", "tan", "ln", "abs", "exp", "arcsin", "arccos", "arctan", "fact"};
    private ArrayList<String> formattedInput;

    public MathFunctions(ArrayList<String> formattedUserInput) {
        this.formattedInput = formattedUserInput;
    }

    public double factorialOf(double x) {
        double factorial = 1;

        for (int i = (int)x; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    public ArrayList<String> evaluateFunctions() {
        double x = 0.0;

        for (String operator : advOperatorList) {
            for (int i = 0; i < formattedInput.size(); i++) {
                if (formattedInput.get(i).equals(operator)) {

                    x = Double.parseDouble(formattedInput.get(i + 2));

                    switch (operator) {
                        case "sqrt":
                            formattedInput.set(i, Math.sqrt(x) + "");
                            break;
                        case "sin":
                            formattedInput.set(i, Math.sin(x) + "");
                            break;
                        case "cos":
                            formattedInput.set(i, Math.cos(x) + "");
                            break;
                        case "tan":
                            formattedInput.set(i, Math.tan(x) + "");
                            break;
                        case "ln":
                            formattedInput.set(i, Math.log(x) + "");
                            break;
                        case "abs":
                            formattedInput.set(i, Math.abs(x) + "");
                            break;
                        case "exp":
                            formattedInput.set(i, Math.exp(x) + "");
                            break;
                        case "arcsin":
                            formattedInput.set(i, Math.asin(x) + "");
                            break;
                        case "arccos":
                            formattedInput.set(i, Math.acos(x) + "");
                            break;
                        case "arctan":
                            formattedInput.set(i, Math.atan(x) + "");
                            break;
                        case "fact":
                            formattedInput.set(i, factorialOf(x) + "");
                            break;
                    }
                    formattedInput.remove(i + 3);
                    formattedInput.remove(i + 2);
                    formattedInput.remove(i + 1);
                }

            }
        }

        return formattedInput;
    }
}
