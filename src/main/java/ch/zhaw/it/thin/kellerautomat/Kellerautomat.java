package ch.zhaw.it.thin.kellerautomat;

public class Kellerautomat {
    // TO DO: implement Kellerautomat class
    private static final Character[] VALID_OPERATORS = new Character[2];
    private static final char PLUS_SIGN = '+';
    private static final char MULTIPLICATION_SIGN = '*';

    public void stepMode(Stack stack){
        // Implement the step mode of the Kellerautomat
        // This method should simulate the step-by-step execution of the automaton
        // and print the current state and stack contents at each step
    }

    public void runMode(){
        // Implement the run mode of the Kellerautomat
        // This method should simulate the automatic execution of the automaton
        // until it reaches a final state or an error occurs
    }

    public void calculate(final boolean stepMode, final String input){
        // Implement the calculate method
        // This method should take an input string and process it according to the rules of the Kellerautomat
        // If stepMode is true, call the stepMode method
        // Otherwise, call the runMode method
    }

}
