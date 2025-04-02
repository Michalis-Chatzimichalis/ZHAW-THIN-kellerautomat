package ch.zhaw.it.thin.kellerautomat;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<String> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(String element) {
        stack.add(element);
    }

    public String pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean containsOnlyResult() {
        return stack.size() == 1;
    }

    public String getElementAtCurrentPosition() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public String spyPeekWithOffset(int offset) {
        int position = stack.size() - 1 - offset;
        if (position < 0 || position >= stack.size()) {
            throw new IllegalStateException("Invalid offset: " + offset);
        }
        return stack.get(position);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
