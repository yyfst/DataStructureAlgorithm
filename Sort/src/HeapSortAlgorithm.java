import java.util.Arrays;

public class HeapSortAlgorithm {
    private static int testTimes = 1000000;

    public static void main(String[] args) {
        heapSortTest();
    }

    private static void heapSortTest() {
        for (int index = 1; index <= testTimes; index++) {
            int[] test = Common.randomArray();
            int[] array1 = Arrays.copyOf(test, test.length);
            int[] array2 = Arrays.copyOf(test, test.length);
            process(array1, 0, array1.length - 1);
           Arrays.sort(array2);

            if (index % 100000 == 0) {
                System.out.println("times: " + index + "  size: " + test.length);
            }

            if (index % testTimes == 0) {
                System.out.println("test case:   " + Arrays.toString(test));
                System.out.println("array1 case: " + Arrays.toString(array1));
                System.out.println("array2 case: " + Arrays.toString(array2));
            }

            for (int i = 0; i < test.length; i++) {
                if (array1[i] == array2[i]) {
                    continue;
                }
                System.out.println("result error!");
                System.out.println("test case: " + Arrays.toString(array1));
                System.out.println("array1 case: " + Arrays.toString(array1));
                System.out.println("array2 case: " + Arrays.toString(array2));
                return;
            }
        }
    }

    public static void process(int[] data, int begin, int end) {
        buildHeap(data, begin, end);
        for (int i = end; i >= begin; i--) {
            swap(data, begin, i);
            buildHeap(data, begin, i - 1);
        }
    }


    public static void buildHeap(int[] data, int begin, int end) {
        if (data == null || (end - begin) < 1) {
            return;
        }

        for (int index = begin + 1; index <= (end - begin); index++) {
            heapAdjustment(data, index);
        }
    }

    // 从上往下调整堆结构，保证父节点大于左右子节点
    private static void heapAdjustment(int[] array, int curDataIndex) {
        while (curDataIndex > 0) {
            int parentDataIndex = (curDataIndex - 1) / 2;
            if (array[parentDataIndex] >= array[curDataIndex]) {
                return;
            }

            Common.swap(array, curDataIndex, parentDataIndex);
            curDataIndex = parentDataIndex;
        }
    }

    /***************************对比代码，用于测试用**********************************/
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void heapAdjust(int[] array) {
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
    }

}
