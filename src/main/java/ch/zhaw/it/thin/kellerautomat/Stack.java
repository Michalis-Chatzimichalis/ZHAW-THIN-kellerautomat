package ch.zhaw.it.thin.kellerautomat;

public class Stack {
    private String[] stack;

    public Stack(String[] stack) {
        this.stack = stack;
    }

    public void push(String value) {
        if (stack == null || stack.length == 0) {
            stack = new String[1];
            stack[0] = value;
        } else {
            String[] newStack = new String[stack.length + 1];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            newStack[stack.length] = value;
            stack = newStack;
        }
    }

    public String pop() {
        if (stack == null || stack.length == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        String value = stack[stack.length - 1];
        String[] newStack = new String[stack.length - 1];
        System.arraycopy(stack, 0, newStack, 0, stack.length - 1);
        stack = newStack;
        return value;
    }

    public String peek() {
        if (stack == null || stack.length == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[stack.length - 1];
    }
    public boolean isEmpty() {
        return stack == null || stack.length == 0;
    }
}
