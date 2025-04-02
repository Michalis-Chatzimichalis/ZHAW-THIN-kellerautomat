package ch.zhaw.it.thin.kellerautomat;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;


public class Kellerautomat {
    private static final char PLUS_SIGN = '+';
    private static final char MULTIPLICATION_SIGN = '*';

    public void stepMode(Stack stack) throws InterruptedException {
        while (!stack.isEmpty()) {

        }
    }

    public void runMode(Stack stack) {
        while (!stack.isEmpty()) {
        }
    }

    public void calculate(final boolean stepMode, final String input) throws InterruptedException {
        Stack stack = new Stack(new String[0]);
        final List<Character> inputChars = input.chars().mapToObj(c -> (char) c).toList();

        for (char token : inputChars) {
            if (Character.isDigit(token)) { // Überprüfen, ob es sich um eine Zahl handelt
                stack.push(String.valueOf(token));
            } else {
                performCalculation(stack,token);
            }
        }

        if (stepMode) {
            Thread.sleep(1000);
            stepMode(stack);
        } else {
            runMode(stack);
        }
    }

    private void performCalculation(Stack stack, char currentChar) {
        final int num1 = parseInt(stack.pop());
        final int num2 = parseInt(stack.pop());

        if (currentChar == PLUS_SIGN) {
            stack.push(valueOf(num1 + num2));
        } else if (currentChar == MULTIPLICATION_SIGN) {
            stack.push(valueOf(num1 * num2));
        }
    }

}
