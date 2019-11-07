import java.util.Random;

/**
 * @program: algorithmicpractice
 * @description: 有关于堆应用的练习
 * @author: WeijieXue
 * @create: 2019-11-05 23:04
 **/
public class heapPractice {

    public static void main(String[] args) {
        int[][] arrays = {{1, 3, 4, 6, 7, 8, 15}
                , {2, 5, 6, 7, 9, 10, 23}
                , {0, 2, 5, 7, 9, 11, 14, 23, 27}
                , {2, 3, 4, 5, 6, 7, 8, 10}};
        mergeSmallFile(arrays);
        int[] timers = {1,4,6,8,13,17,23,25,30};
        highPerformanceTimer(timers);
        int[] dataFlow = new int[10000];
        Random random = new Random(1);
        for(int i = 0;i < 10000;i++){
            dataFlow[i] = random.nextInt(10000);
        }
        topK(dataFlow,10);
        middleNumInStream(dataFlow);
    }

    public static void mergeSmallFile(int[][] arrays) {

    }

    public static void highPerformanceTimer(int[] timers) {

    }

    public static void topK(int[] dataFlow,int k) {

    }

    public static void middleNumInStream(int[] dataFlow) {

    }

    public static int[] heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        buildHeap(array);
        return heapSortWithArray(array);
    }

    private static void buildHeap(int[] array) {
        int lastNotLeafIndex = (array.length - 1) >>> 1;
        int left;
        int right;
        int temp;
        int min;
        boolean isChange = true;
        while (isChange) {
            isChange = false;
            for (int i = lastNotLeafIndex; i >= 0; i--) {
                left = i * 2 + 1;
                min = i;
                if (array[i] > array[left]) {
                    min = left;
                    isChange = true;
                }
                right = i * 2 + 2;
                if (right < array.length && array[i] > array[right]) {
                    min = right;
                    isChange = true;
                }
                if (min == i) {
                    continue;
                }
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    private static int[] heapSortWithArray(int[] array) {
        int[] newArray = new int[array.length];
        int length = array.length - 1;
        int curIndex;
        int left;
        int right;
        int temp;
        int min;
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[0];
            array[0] = array[length];
            length--;
            curIndex = 0;
            left = 0;
            while (left <= length) {
                min = curIndex;
                left = curIndex * 2 + 1;
                right = curIndex * 2 + 2;
                if (left <= length && array[left] < array[curIndex]) {
                    min = left;
                }
                if (right <= length && array[right] < array[min]) {
                    min = right;
                }
                if (min == curIndex) {
                    break;
                }
                temp = array[curIndex];
                array[curIndex] = array[min];
                array[min] = temp;
                curIndex = min;
            }
        }
        return newArray;
    }

}
