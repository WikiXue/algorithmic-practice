
/**
 * @program: algorithmicpractice
 * @description:
 * @author: WeijieXue
 * @create: 2019-11-04 22:39
 **/
public class Practice {

    private int[] array;
    private int count = 0;
    private int sum = 0;
    private int maxValue = 0;

    public static void main(String[] args) {
        Practice practice = new Practice();
//        int count = practice.JumpFloorII(3);
//        practice.eightQueen();
        int[] stone = {4, 7, 2, 9, 1, 7, 2, 8, 6, 3};
        int limit = 15;
        int[] stone2 = {2,8,6,3};
        int[][] metal = {{4, 3}, {7, 5}, {2, 2}, {9, 6}, {1, 2}, {7, 8}, {2, 1}, {8, 4}, {6, 5}, {3, 2}};
        practice.zeroOneBackpackOnRecall(stone2, limit);
//        practice.zeroOneBackpackValueRecall(metal, limit);
        System.out.println(practice.count);
//        System.out.println(practice.maxValue);
    }

    public int JumpFloorII(int target) {
        if (target < 1) {
            return 0;
        }
        Jump(target);
        return count;
    }

    private void Jump(int remain) {
        if (remain <= 0) {
            count++;
        }
        for (int i = 1; i <= remain; i++) {
            Jump(remain - i);
        }
    }

    class Piece {
        int x;
        int y;
    }

    public void eightQueen() {
        Piece[] pieces = new Piece[8];
        pickSpot(pieces, 0);
    }

    public void pickSpot(Piece[] pieces, int curIndex) {
        for (int i = 0; i < 8; i++) {
            if (checkIfRight(pieces, curIndex, i, curIndex)) {
                Piece piece = new Piece();
                piece.x = curIndex;
                piece.y = i;
                pieces[curIndex] = piece;
                pickSpot(pieces, curIndex + 1);
            }
        }
        if (curIndex == pieces.length - 1) {
            if (pieces[7] != null) {
                for (int i = 0; i < pieces.length; i++) {
                    System.out.print("[" + pieces[i].x + "," + pieces[i].y + "] ");
                }
                System.out.println();
                count++;
                pieces[7] = null;
            }
        }
    }

    public boolean checkIfRight(Piece[] pieces, int x, int y, int curSize) {
        for (int i = 0; i < curSize; i++) {
            if (pieces[i].y == y || (x - pieces[i].x) == (y - pieces[i].y) || (x - pieces[i].x) == (pieces[i].y - y)) {
                return false;
            }
        }
        return true;
    }

    //TODO 输出不完全
    public void zeroOneBackpackOnRecall(int[] array, int limit) {
        if (array == null || array.length < 1 || limit < 1) {
            return;
        }
        boolean[] select = new boolean[array.length];
        zOBRecall(array, 0, 0, limit, select);
    }

    public void zOBRecall(int[] array, int curIndex, int sum, int limit, boolean[] select) {
        if (curIndex == array.length || array[curIndex] + sum > limit) {
            if (sum > this.sum) {
                this.sum = sum;
            }
            for(int i = 0;i < curIndex;i++){
                if(select[i]){
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println("curSum:" + sum + " maxSum:" + this.sum);
            return;
        }
        select[curIndex] = false;
        zOBRecall(array, curIndex + 1, sum, limit, select);
        select[curIndex] = true;
        zOBRecall(array, curIndex + 1, sum + array[curIndex], limit, select);
    }

    //TODO 输出不完全
    public void zeroOneBackpackValueRecall(int[][] array, int limit) {
        if (array == null || array.length < 1 || limit < 1) {
            return;
        }
        boolean[] select = new boolean[array.length];
        zOBVRecall(array, 0, 0, limit, 0, select);
    }

    public void zOBVRecall(int[][] array, int curIndex, int sum, int limit, int totalValue, boolean[] select) {
        if (curIndex >= array.length || array[curIndex][0] + sum > limit) {
            if (totalValue > this.maxValue) {
                this.maxValue = totalValue;
            }
            for (int i = 0; i < curIndex; i++) {
                if (select[i]) {
                    System.out.print(array[i][0] + "-" + array[i][1] + " ");
                }
            }
            System.out.println("curSum:" + sum + " curValue:" + totalValue + " maxValue:" + maxValue);
            return;
        }
        select[curIndex] = false;
        zOBVRecall(array, curIndex + 1, sum, limit, totalValue, select);
        select[curIndex] = true;
        zOBVRecall(array, curIndex + 1, sum + array[curIndex][0], limit, totalValue + array[curIndex][1], select);
    }

    public void zeroOneBackPackOnDynamic() {

    }

    public void zeroOneBackpackValueOnDynamic() {

    }

    public void longestPathOnBinaryTree() {

    }

}