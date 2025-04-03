package ch.zhaw.it.thin.kellerautomat;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Iterator;
import java.util.List;

public class Kellerautomat {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final char PLUS_SIGN = '+';
    private static final char MULTIPLICATION_SIGN = '*';

    public void calculate(final boolean stepMode, final String input) throws InterruptedException {
        // Remove all spaces from the input string
        final String cleanedInput = input.replace(" ", "");
        final Stack stack = new Stack();
        // map every char from the cleaned input to a Character object and collect them into a list
        final List<Character> inputChars = cleanedInput.chars().mapToObj(c -> (char) c).toList();
        final StringBuilder remainingChars = new StringBuilder(cleanedInput);
        boolean isValid = true;
        int stepCount = 0;
        final Iterator<Character> iterator = inputChars.iterator();

        // iterate over the input string
        while (iterator.hasNext() && isValid) {
            stepCount++; // index to count the steps of the calculation
            final Character nextChar = iterator.next();
            if (isDigit(nextChar)) {
                stack.push(valueOf(nextChar));
                // if the next character is an operator (+ or *) and the stack contains at least two numbers, perform
                // the calculation with the 2 top numbers of the stack
            } else if (nextChar.equals(PLUS_SIGN) || nextChar.equals(MULTIPLICATION_SIGN)) {
                if (containsTwoPreviousNumbers(stack)) {
                    performCalculation(stack, nextChar);
                } else {
                    // if the stack does not contain two numbers, the input is invalid
                    isValid = false;
                }
                // if the next character is not a number or an operator, the input is invalid
            } else {
                isValid = false;
            }
            if (stepMode) {
                SECONDS.sleep(1);
                remainingChars.deleteCharAt(0);
                printCalculationStep(stepCount, stack, remainingChars);
            }
        }
        if (!stack.containsOnlyResult()) {
            isValid = false;
        }
        printResult(cleanedInput, stack, isValid);
    }

    // prints the current step of the calculation with some nicer-ish formatting
    private void printCalculationStep(int stepCount, Stack stack, StringBuilder remainingChars) {
        System.out.printf(stepCount + ".\t ( %-25s, ( %-25s)) %-5s |- \n", remainingChars, stack, " ");
    }

    // peeks the top two elements of the stack and checks if they are numbers
    private boolean containsTwoPreviousNumbers(Stack stack) {
        // Ensure that the stack has at least 2 elements
        if (stack.isEmpty() || stack.getLength() < 2) {
            return false;
        }
        try {
            parseInt(stack.peek(0));  // Access the top element
            parseInt(stack.peek(1));  // Access the second-to-top element
        } catch (NumberFormatException e) {
            // Return false if any of these values are not valid integers
            return false;
        }

        return true;  // Both values are integers
    }


    // removes the single numbers from the stack, performs the calculation and replaces the numbers with the result
    private void performCalculation(Stack stack, char currentChar) {
        final int num1 = parseInt(stack.pop());
        final int num2 = parseInt(stack.pop());
        if (currentChar == PLUS_SIGN) {
            stack.push(valueOf(num1 + num2));
        } else if (currentChar == MULTIPLICATION_SIGN) {
            stack.push(valueOf(num1 * num2));
        }
    }

    private void printResult(String input, Stack stack, boolean isValid) {
        System.out.println(isValid
                ? ANSI_GREEN+"Word accepted with result: " + stack.getCurrentToken() + ANSI_RESET + "\n______________________________\n"
                : format(ANSI_RED + "Word %s was discarded."+ANSI_RESET, input) + "\n______________________________\n");
    }
}