public class ArrrayW2 {
    public static void main(String args[]) {

        int[] x = new int[50];
        for (int i = 0; i < x.length; i++) {
            x[i] = 3 * i;
        }
        int[] y = new int[50];

        System.arraycopy(x, 0, y, 0, x.length);
        System.arraycopy(x, 0, y, 1, 40);
        System.arraycopy(x, 10, x, 0, 10);
    }

    public static void moveSmallesttoPositionZero(int[] arr) {
        int smallestIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallestIndex]) ;
        }
    }

}

