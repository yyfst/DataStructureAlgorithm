import java.util.Stack;

public class StackReverse {
    public void stackReverse(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return;
        }

        int last = process(stack);
        stackReverse(stack);
        stack.push(last);
    }

    private int process(Stack<Integer> stack) {
        int pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int res = process(stack);
            stack.push(pop);
            return res;
        }
    }
}
