public class Common {
    private static final int maxArraySize = 100;
    private static final int maxData = 100;

    public static void swap(int[] array, int first, int second) {
        array[first] = array[first] ^ array[second];
        array[second] = array[first] ^ array[second];
        array[first] = array[first] ^ array[second];
    }

    public static int[] randomArray() {
        int arraySize = (int) (Math.random() * maxArraySize);
        int[] array = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            int tmp1 = (int) (Math.random() * maxData);
            int tmp2 = (int) (Math.random() * maxData);
            array[index] = tmp1 - tmp2;
        }

        return array;
    }
}
