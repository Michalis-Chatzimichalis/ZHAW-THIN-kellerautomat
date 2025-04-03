package ch.zhaw.it.thin.kellerautomat;

public class Stack {
    private String[] stack;

    public Stack() {
        stack = new String[]{};
    }

    public void push(String value) {
        // create a new stack with size+1 of the old array to add the new value
        String[] newStack = new String[stack.length + 1];
        // copy the old stack to the new stack
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        // add the new value to the end of the new stack
        newStack[stack.length] = value;
        stack = newStack;
    }

    public String pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        // get the top element, this value is returned but removed from the stack
        String value = stack[stack.length - 1];
        // create a new stack with size-1 of the old array to remove the last value
        String[] newStack = new String[stack.length - 1];
        // copy the stack to the new stack, excluding the last element
        for (int i = 0; i < newStack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        // return the value that was popped
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