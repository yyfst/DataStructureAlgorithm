public class Test {
    public static void main(String[] args) {

        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsack(weights, values, bag));
//        System.out.println(dp(weights, values, bag));
    }
}
