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
        boolean isChange = true;
        while (isChange) {
            isChange = false;
            for (int i = lastNotLeafIndex; i >= 0; i--) {
                left = i * 2 + 1;
                if (array[i] > array[left]) {
                    temp = array[i];
                    array[i] = array[left];
                    array[left] = temp;
                    isChange = true;
                }
                right = i * 2 + 2;
                if (right < array.length && array[i] > array[right]) {
                    temp = array[i];
                    array[i] = array[right];
                    array[right] = temp;
                    isChange = true;
                }
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
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[0];
            array[0] = array[length];
            length--;
            curIndex = 0;
            left = 0;
            while (left < length) {
                left = curIndex * 2 + 1;
                right = curIndex * 2 + 2;
                if (left < length && right < length) {

                }

            }
        }
        return newArray;
    }

}
