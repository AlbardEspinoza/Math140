public class Arrays {
    public static void main(String[] args) {

        System.out.println(25 + 75 + "cat");
        System.out.println(25 + "cat" + 75);

        double[] y = {2.3, 3.4, 5.6};
        double[] x = y;
        /*Remember you can pass the contents of an array variable to another as long
        * as they're the same array data type(double[], int[], etc...).*/
        System.out.println(x[0]);
        System.out.println(y[0]);

        char m = 's';
        int s = 98;
        String[] l = {"Vehicle", "Car", "Boat", "Jet"};
        System.out.println(l[0]);
        //Remember you can also have an array of Strings.

        int[] numbers = {2, 3, 4};
        numbers = new int[]{3, 4, 5};
        /*Remember that to change the contents in an array you must use the keyword
        * new and its data type on the right side, this way the contents of the array
        * are allocated to a new address, so the variable stores a new address.*/



    }
}
