/**
 * @program: algorithmicpractice
 * @description:
 * @author: WeijieXue
 * @create: 2019-11-04 22:39
 **/
public class Practice {

    private int[] array;

    private static final int MAX = 2000000000;

    public static void main(String[] args) {
        Practice practice = new Practice();
//        int count = practice.JumpFloorII(3);
        practice.nextBig(115);
    }

    public int JumpFloorII(int target) {
        if (target < 1) {
            return 0;
        }
        array = new int[target + 1];
        return Jump(target) + 1;
    }

    private int Jump(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        if (array[target] != 0) {
            return array[target];
        }
        int count = 0;
        for (int i = 1; i < target; i++) {
            array[i] = Jump(i);
            array[target - i] = Jump(target - i);
            count += array[i] * array[target - i];
        }
        return count;
    }

    public void nextBig(int number) {
        int num = number;
        int count = 0;
        while ((num = num / 10) > 0) {
            count++;
        }
        if (count < 1) {
            return;
        }
        int[] arrays = new int[count + 1];
        num = number;
        for (int i = 0; i < count + 1; i++) {
            arrays[i] = num % 10;
            num = num / 10;
        }
        for (int i = 1; i < count + 1; i++) {
            int index;
            if ((index = findSmallestBigNum(arrays, i)) != -1) {
                PracticeUtil.exchange(arrays, index, i);
                PracticeUtil.printArrayWithDir(arrays, -1);
                return;
            }
        }
    }

    public int findSmallestBigNum(int[] array, int index) {
        int minIndex = index;
        int min = MAX;
        for (int i = 0; i < index; i++) {
            if (array[i] > array[index] && array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex == index ? -1 : minIndex;
    }

}