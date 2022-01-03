import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        testStackReverse();

        testSubString();
    }

    private static void testSubString() {
        String str = "abc";
        SubString subString = new SubString();
        List<String> res = subString.findSubString1(str);
        for (String s : res) {
            System.out.println(s);
        }
        System.out.println("str size: " + str.length() + "  res size: " + res.size());
    }

    private static void testStackReverse() {
        StackReverse stackReverse = new StackReverse();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stackReverse.stackReverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testHanoi() {
        Hanoi hanoi = new Hanoi();
//        hanoi.hanoi2(3);
        hanoi.hanoi2(30);

    }

    private static void testKnapsack() {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsack(weights, values, bag));
//        System.out.println(dp(weights, values, bag));
    }
}