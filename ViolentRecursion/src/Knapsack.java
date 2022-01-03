public class Knapsack {
    public int knapsack(int[] w, int[] v, int totalWeight) {
        return calCurMaxValue(w, v, 0, 0, totalWeight);
    }

    public int calCurMaxValue(int[] w, int[] v, int index, int curWeight, int totalWeight) {
        if (curWeight > totalWeight) {
            return -1;
        }

        if (index >= w.length) {
            return 0;
        }

        int curValue = calCurMaxValue(w, v, index + 1, curWeight + w[index], totalWeight);
        int curNextValue = calCurMaxValue(w, v, index + 1, curWeight, totalWeight);

        if (curValue != -1) {
            curValue = curValue + v[index];

        }
        return Math.max(curValue, curNextValue);
    }
}
