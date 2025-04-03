package ch.zhaw.it.thin.kellerautomat;

public class Stack {
    private String[] stack;

    public Stack() {
        this.stack = new String[]{};
    }

    public void push(String value) {
        if (isEmpty()) {
            stack = new String[1];
            // create a new stack and add the value to it if the stack is empty at the beginning
            stack[0] = value;
        } else {
            // create a new stack and add the value to it if the stack is not empty
            String[] newStack = new String[stack.length + 1];
            // copies the stack to the new stack, srcPos/destPos being the start index of the new/old array
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            newStack[stack.length] = value;
            stack = newStack;
        }
    }

    public String pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        // get the top element, this value is returned but removed from the stack
        String value = stack[stack.length - 1];
        // returns the new stack minus the last element of the stack and saves it to an array copy
        String[] newStack = new String[stack.length - 1];
        // copies the stack to the new stack, srcPos/destPos being the start index of the old/new array
        System.arraycopy(stack, 0, newStack, 0, stack.length - 1);
        stack = newStack;
        return value;
    }

    public String peek(int offset) {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack[stack.length - 1 - offset]; // returns the element at the specified offset from the top, but does not pop it
    }

    public boolean isEmpty() {
        return stack == null || stack.length == 0;
    }

    public boolean containsOnlyResult() {
        return stack.length == 1; // If only one element is left, it's the result
    }

    public String getCurrentToken() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack[stack.length - 1]; // returns the top element/current token
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = stack.length - 1; i >= 0; i--) {
            sb.append(stack[i]);
            if (i != 0) sb.append(", ");
        }
        return sb.toString();
    }

    public int getLength() {
        return stack.length;
    }
}