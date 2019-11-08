import java.util.Random;

/**
 * @program: algorithmicpractice
 * @description: 有关于堆应用的练习
 * @author: WeijieXue
 * @create: 2019-11-05 23:04
 **/
public class HeapPractice {

    public static void main(String[] args) {
        HeapPractice heapPractice = new HeapPractice();
        int[][] arrays = {{1, 3, 4, 6, 7, 8, 15}
                , {2, 5, 6, 7, 9, 10, 23}
                , {0, 2, 5, 7, 9, 11, 14, 23, 27}
                , {2, 3, 4, 5, 6, 7, 8, 10}};
        heapPractice.mergeSmallFile(arrays);
        int[] timers = {6, 4, 1, 13, 30, 23, 8, 15, 27};
        highPerformanceTimer(timers);
        int[] dataFlow = new int[10000];
        Random random = new Random(1);
        for (int i = 0; i < 10000; i++) {
            dataFlow[i] = random.nextInt(10000);
            System.out.print(dataFlow[i] + " ");
        }
        System.out.println();
        int[] topK = topK(dataFlow, 10);
        PracticeUtil.printArray(topK);
        Integer num = heapPractice.middleNumInStream(dataFlow, 0.5);
        System.out.println(num);
        heapSort(dataFlow);
        PracticeUtil.printTree(dataFlow);
        SortPractice.quickSort(dataFlow);
        PracticeUtil.printArray(dataFlow);
    }

    private class SmallFileNode {
        int num;
        int fileNo;
        int currentIndex;

        SmallFileNode(int num, int fileNo, int currentIndex) {
            this.num = num;
            this.fileNo = fileNo;
            this.currentIndex = currentIndex;
        }
    }

    public void mergeSmallFile(int[][] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return;
        }
        SmallFileNode[] nodes = new SmallFileNode[arrays.length];
        int num = 0;
        for (int i = 0; i < arrays.length; i++) {
            SmallFileNode node = new SmallFileNode(arrays[i][0], i, 0);
            nodes[i] = node;
            num += arrays[i].length;
        }
        int left;
        int right;
        SmallFileNode temp;
        int min;
        int curIndex;
        int length = nodes.length;
        for (int i = 0; i < num; i++) {
            curIndex = 0;
            left = 0;
            while (left < length) {
                left = curIndex * 2 + 1;
                right = curIndex * 2 + 2;
                min = curIndex;
                if (left < length && nodes[left].num < nodes[curIndex].num) {
                    min = left;
                }
                if (right < length && nodes[right].num < nodes[min].num) {
                    min = right;
                }
                if (min == curIndex) {
                    break;
                }
                temp = nodes[curIndex];
                nodes[curIndex] = nodes[min];
                nodes[min] = temp;
                curIndex = min;
            }
            System.out.print(nodes[0].num + " ");
            if (nodes[0].currentIndex != arrays[nodes[0].fileNo].length) {
                nodes[0].num = arrays[nodes[0].fileNo][nodes[0].currentIndex];
                nodes[0].currentIndex++;
            } else {
                nodes[0] = nodes[length - 1];
                length--;
            }

        }
    }

    public static void highPerformanceTimer(int[] timers) {
        buildHeap(timers);
        int passTime = 0;
        int length = timers.length;
        while (length > 0) {
            while (true) {
                if (passTime == timers[0]) {
                    break;
                }
                passTime++;
            }
            System.out.print(timers[0] + " ");
            length--;
            if (length > 0) {
                timers[0] = timers[length];
                smallTopToDown(timers, length);
            } else {
                break;
            }
        }
    }

    public static int[] topK(int[] dataFlow, int k) {
        if (dataFlow == null || dataFlow.length < 1 || dataFlow.length < k) {
            return null;
        }
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = dataFlow[i];
        }
        buildHeap(topK);
        for (int i = k; i < dataFlow.length; i++) {
            if (dataFlow[i] > topK[0]) {
                topK[0] = dataFlow[i];
                smallTopToDown(topK, k);
            }
        }
        return topK;
    }

    public Integer middleNumInStream(int[] dataFlow, double rate) {
        if (dataFlow == null || dataFlow.length < 1 || dataFlow.length * rate < 1 || rate > 1) {
            return null;
        }
        if (dataFlow.length == 1 || dataFlow.length * rate == 1) {
            return dataFlow[0];
        }
        int[] left = new int[dataFlow.length];
        int[] right = new int[dataFlow.length];
        left[0] = dataFlow[0];
        right[0] = dataFlow[1];
        int leftLength = 1;
        int rightLength = 1;
        for (int i = 2; i < dataFlow.length; i++) {
            if (dataFlow[i] > left[0]) {
                right[rightLength] = dataFlow[i];
                smallDownToTop(right, rightLength);
                rightLength++;
            } else {
                left[leftLength] = dataFlow[i];
                bigDownToTop(left, leftLength);
                leftLength++;
            }
            while ((leftLength + rightLength) * rate < leftLength) {
                right[rightLength] = left[0];
                left[0] = left[leftLength - 1];
                leftLength--;
                bigTopToDown(left, leftLength);
                smallDownToTop(right, rightLength);
                rightLength++;
            }
            while ((leftLength + rightLength) * rate > leftLength) {
                left[leftLength] = right[0];
                right[0] = right[rightLength - 1];
                rightLength--;
                smallTopToDown(right, rightLength);
                bigDownToTop(left, leftLength);
                leftLength++;
            }
        }
//        PracticeUtil.printTree(left,leftLength);
//        PracticeUtil.printTree(right,rightLength);
        return right[0];
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
                if (left < array.length && array[i] > array[left]) {
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
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[0];
            array[0] = array[length];
            smallTopToDown(array, length);
            length--;
        }
        return newArray;
    }

    private static void smallTopToDown(int[] array, int length) {
        if (array == null || length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        int curIndex = 0;
        int min = 0;
        int temp = 0;
        while (left < length) {
            left = curIndex * 2 + 1;
            right = curIndex * 2 + 2;
            min = curIndex;
            if (left < length && array[left] < array[curIndex]) {
                min = left;
            }
            if (right < length && array[right] < array[min]) {
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

    private static void bigTopToDown(int[] array, int length) {
        if (array == null || length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        int curIndex = 0;
        int max = 0;
        int temp = 0;
        while (left < length) {
            left = curIndex * 2 + 1;
            right = curIndex * 2 + 2;
            max = curIndex;
            if (left < length && array[left] > array[curIndex]) {
                max = left;
            }
            if (right < length && array[right] > array[max]) {
                max = right;
            }
            if (max == curIndex) {
                break;
            }
            temp = array[curIndex];
            array[curIndex] = array[max];
            array[max] = temp;
            curIndex = max;
        }
    }

    private static void smallDownToTop(int[] array, int index) {
        if (array == null || array.length < 1 || array.length <= index) {
            return;
        }
        int father = (index - 1) / 2;
        int temp;
        while (true) {
            if (array[index] < array[father]) {
                temp = array[index];
                array[index] = array[father];
                array[father] = temp;
                index = father;
                father = (father - 1) / 2;
            } else {
                return;
            }
        }
    }

    private static void bigDownToTop(int[] array, int index) {
        if (array == null || array.length < 1 || array.length <= index) {
            return;
        }
        int father = (index - 1) / 2;
        int temp;
        while (true) {
            if (array[index] > array[father]) {
                temp = array[index];
                array[index] = array[father];
                array[father] = temp;
                index = father;
                father = (father - 1) / 2;
            } else {
                return;
            }
        }
    }

}
