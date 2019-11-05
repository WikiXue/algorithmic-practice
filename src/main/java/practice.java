/**
 * @program: algorithmicpractice
 * @description:
 * @author: WeijieXue
 * @create: 2019-11-04 22:39
 **/
public class practice {

    public static void main(String[] args) {
        int[] array = {4, 2, 5, 7, 2, 9, 15, 96, 26, 27, 36, 46, 73, 83};
        array = heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
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
