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

        int[] a = new int[50];
        /*One way to initialize an array. You can add the contents later
        * as shown below:*/

        a[0] = 2;
        a[1] = 3;
        a[2] = 4;
        //etc...

        /*You CAN'T do this:
        * int[] a = new int[50];
        * a = {2,3,4};
        * If you want to edit the contents of the array you just name the array and the
        * index in the array you want to change and set it's new content, as shown below:
        * a[0] = 4;*/

        int[] b = {4,5,6,7,8,9};
        /*This is a quicker way you can initialize an array bu initializing and
        * setting its values at the same time.*/

        int[] data;
        data = new int[30];
        data = new int[20];
        /*In the example above we initialize an array, but don't set it a length. Below it
        * we set the length once and then edit it, this is possible because REMEMBER the
        * variable "data" stores an address when you type the keyword "new" again you
        * store a different address in the "data" variable and you reset the length of the
        * array.*/

    }
}
