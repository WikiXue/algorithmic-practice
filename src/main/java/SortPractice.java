import java.util.Random;

/**
 * @author xueweijie
 * @date 19-11-7 下午4:08
 */
public class SortPractice {

    public static void main(String[] args) throws Exception {
        int SIZE = 10000;
        int[] a = new int[SIZE];
        int[] b = new int[SIZE];
        int[] c = new int[SIZE];
        int[] d = new int[SIZE];
        int[] e = new int[SIZE];
        Random random = new Random(1);
        for (int i = 0; i < SIZE; i++) {
            a[i] = random.nextInt(SIZE);
            b[i] = a[i];
            c[i] = a[i];
            d[i] = a[i];
            e[i] = a[i];
        }
        long start = System.currentTimeMillis();
        bubbleSort(a);
        long end = System.currentTimeMillis();
        insertSort(b);
        long end2 = System.currentTimeMillis();
        selectSort(c);
        long end3 = System.currentTimeMillis();
        mergeSort(d);
        long end4 = System.currentTimeMillis();
        quickSort(e);
        long end5 = System.currentTimeMillis();
        System.out.println(end - start);
        PracticeUtil.printArray(a);
        System.out.println(end2 - end);
        PracticeUtil.printArray(b);
        System.out.println(end3 - end2);
        PracticeUtil.printArray(c);
        System.out.println(end4 - end3);
        PracticeUtil.printArray(d);
        System.out.println(end5 - end4);
        PracticeUtil.printArray(e);
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = sort(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static int sort(int[] array, int left, int right) {
        if (left >= right) {
            return left;
        }
        int doneIndex = left;
        int pivot = array[right];
        int temp = 0;
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                temp = array[doneIndex];
                array[doneIndex] = array[i];
                array[i] = temp;
                doneIndex++;
            }
        }
        temp = array[doneIndex];
        array[doneIndex] = array[right];
        array[right] = temp;
        return doneIndex;
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        int[] tempArray = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        for (int i = 0; i <= right - left; i++) {
            if (array[leftIndex] >= array[rightIndex]) {
                tempArray[i] = array[rightIndex];
                rightIndex++;
                if (rightIndex > right) {
                    for (i++; i <= right - left; i++, leftIndex++) {
                        tempArray[i] = array[leftIndex];
                    }
                    break;
                }
            } else {
                tempArray[i] = array[leftIndex];
                leftIndex++;
                if (leftIndex > mid) {
                    for (i++; i <= right - left; i++, rightIndex++) {
                        tempArray[i] = array[rightIndex];
                    }
                    break;
                }
            }
        }
        int begin = left;
        for (int i = 0; begin <= right; begin++, i++) {
            array[begin] = tempArray[i];
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int temp = 0;
        boolean isExchange = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isExchange = true;
                }
            }
            if (!isExchange) {
                break;
            }
        }
    }

    public static void selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int temp;
        for (int i = 0, j; i < array.length; i++) {
            temp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

}
