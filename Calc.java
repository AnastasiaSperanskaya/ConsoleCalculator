package calc;

import java.util.ArrayList;
import java.util.Arrays;

public class Calc {
    private String[] operatorList = {"+", "-", "*", "/", "^"};
    private String input;
    private ArrayList<String> formattedInput = new ArrayList<String>();

    public void setInput(String inp){
        this.input = inp;
    }

    public String getInput()
    {
        return this.input;
    }

    public ArrayList<String> formatUserInput(){
        input = input.replace(" ", "");
        for (String j : this.operatorList){
            input = input.replace(j, " " + j + " ");
        }

        if(input.charAt(0) == ' ') {
            input = input.substring(3);
            input = "-"+input;
        }

        formattedInput = new ArrayList<String>(Arrays.asList(input.split(" ")));

        for(int i = 0; i < formattedInput.size(); i++){
            if (formattedInput.get(i).equals("-")){
                formattedInput.set(i,"+");
                formattedInput.set(i+1, "-" + formattedInput.get(i+1));
            }
        }

        return formattedInput;
    }

    public double condenseExpression(String operator, int index){
        double output = 0;

        double x = Double.parseDouble(formattedInput.get(index - 1));
        double y = Double.parseDouble(formattedInput.get(index + 1));

        switch (operator){
            case "^":
                output = Math.pow(x, y);
                break;
            case "*":
                output = x * y;
                break;
            case "/":
                output = x / y;
                break;
            case "+":
                output = x + y;
                break;
            case "-":
                output = x - y;
                break;
        }

        return output;
    }

    public String solveExpression(){
        formatUserInput();
        formattedInput = new ConvertConstants(formattedInput).convert();

        if(formattedInput.size() == 1){
            return (Double.parseDouble(formattedInput.get(0)) + "");
        }
        else {

            String[] prioritizedOperations = {"*", "/", "^"};
            double condense;
            //Salvation by condensation the ArrayList first by solving "*" "/" "^" expressions
            for (int i = 1; i <= formattedInput.size() - 2; i++)
                if (formattedInput.get(i).equals("*") || formattedInput.get(i).equals("/") || formattedInput.get(i).equals("^")) {
                    condense = condenseExpression(formattedInput.get(i), i);

                    formattedInput.remove(i + 1);
                    formattedInput.remove(i);
                    formattedInput.set(i - 1, condense + "");

                    i = 0;
                }

            //Salvation by condensation the ArrayList first by solving other expressions
            for (int i = 1; i <= formattedInput.size() - 2; i++)
                if (formattedInput.get(i).equals("+") || formattedInput.get(i).equals("-")) {
                    condense = condenseExpression(formattedInput.get(i), i);

                    formattedInput.remove(i + 1);
                    formattedInput.remove(i);
                    formattedInput.set(i - 1, condense + "");

                    i = 0;
                }


            if (formattedInput.size() == 1)
                return (Double.parseDouble(formattedInput.get(0)) + "");
            else
                return "Error";
        }
    }

    public String toString(){
        return solveExpression() + "";
    }
}

