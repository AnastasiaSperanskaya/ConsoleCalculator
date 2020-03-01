package calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calc calc = new Calc();

        Scanner keyboard = new Scanner(System.in);
        String userInput = "";
        int cnt = 0;

        System.out.print("<< ");
        userInput = keyboard.nextLine();
        userInput = userInput.toLowerCase();

        while (!userInput.equals("exit") && !userInput.equals("quit")) {
            calc.setInput(userInput);
            String answer = calc + "";
            System.out.println(">> " + answer + "\n");

            cnt++;

            System.out.print("<< ");
            userInput = keyboard.next();
        }
        keyboard.close();
    }
}