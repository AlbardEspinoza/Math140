public class EnhancedForLoops {

    public static void main(String[] args) {

        int[] a = {2, 10, 24};
        int total = 0;/*Remember you have to initialize int variables, otherwise they have
        value whatsoever. ONLY instance variables that are not initialized have a default
        value of 0.*/

        for (int x : a
                ) {
            System.out.println(x);
            total += x;

        }
        /*The way the for each(enhanced for loop) works is that first you create a variable
        * that is the same data type as the variable you want to loop through. Then you add
        * a colon and type in the name of the variable you want to loop through. When you
        * finish that you practically finished the for loop, whats left is to set inside the
        * for each loop the commands you want it to do. In the example above what i did is
        * that I wanted to know the total sum of the integers in the array "a", I created the
        * variable total beforehand so that it could store the address of the final value.
        * Thw variable "x" loops through the entire array storing one at a time a value of
        * the array, It can only have one value at a time so it gets the first value(IT
        * ALWAYS STARTS FROM THE FIRST VALUE) does the commands that are in the for each
        * loop, the variable "x" dumps its data "dumps" the reference(address from now on
        * equals address) and gets the reference from the second and index ans starts the
        * cycle all over again. This repeats until the for each loop runs through the whole
        * array.*/

        int x = 10;/*Remember this x is outside the for each loop that's why you don't get
        a compiler error. The x in the for each loop stays within the for each loop.*/

        System.out.println("Finish total: " + total);

    }
}
