/**
 * @program: algorithmicpractice
 * @description:
 * @author: WeijieXue
 * @create: 2019-11-04 22:39
 **/
public class Practice {

    private int[] array;

    public static void main(String[] args) {
        Practice practice = new Practice();
        int count = practice.JumpFloorII(3);
        System.out.println(count);
    }

    public int JumpFloorII(int target) {
        if (target < 1) {
            return 0;
        }
        array = new int[target + 1];
        return Jump(target) + 1;
    }

    private int Jump(int target) {
        if(target <= 0){
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        if (array[target] != 0) {
            return array[target];
        }
        int count = 0;
        for(int i = 1;i < target;i++){
            array[i] = Jump(i);
            array[target - i] = Jump(target - i);
            count += array[i] * array[target - i];
        }
        return count;
    }

}