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

}
