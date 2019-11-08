/**
 * @program: algorithmicpractice
 * @description: 工具类
 * @author: WeijieXue
 * @create: 2019-11-07 23:06
 **/
public class PracticeUtil {

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        for (int a : array) {
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printArray(int[] array, int length) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printTree(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
            if (num * 2 - 2 == i) {
                System.out.println();
                num = num * 2;
            }
        }
        System.out.println();
    }

    public static void printTree(int[] array, int length) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        int num = 1;
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
            if (num * 2 - 2 == i) {
                System.out.println();
                num = num * 2;
            }
        }
        System.out.println();
    }

    public static void exchange(int[] array, int i, int j) {
        if (array == null || array.length <= 1 || array.length < i || array.length < j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
