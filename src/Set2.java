public class Set2 {

    private int[] set;
    private int size;

    /*The constructor is just allocating memory for the set array.*/
    public Set2(int capacity) {
        this.set = new int[capacity];
    }

    /*In this method you're doubling the capacity of the set array.*/
    private void increaseCapacity() {
        int[] y = new int[set.length * 2];
        System.arraycopy(set, 0, y, 0, set.length);
        set = y;/*In this line you're just pointing y and set to the same
        reference, therefore they have the same values. NOTE: you're not copying
        the elements of y into set you're just simply pointing set to the same
        address.*/
        //TODO; does this line also edit the length of set to be as big as y's?
    }

    /*In this method I used a while loop to be able to find if
    * the value stored in value was stored in the array. In the
    * while boolean expression I added && !x so that way if it found
    * the value in the middle the while loop would end there and
    * it would'nt have to search through the whole array. I also
    * added the y < size so that way the index would'nt go out of
    * bounds. REMEMBER: size is the # of elements in the array, and
    * set is the number of elements the array can store.*/
    public boolean contains(int value) {
        boolean x = false;
        int y = 0;
        while (y < size && !x) {//!x = x = false.
            if (set[y] == value) {
                x = true;
            }
        }
        return x;
    }

    /*In this method what I did is that I created a boolean expression x
    * and in it I called the contains(value) method with the variable
    * value stored in it so that way the method would check for me if
    * the variable value was in the set array, and it would store true or
    * false in the x variable depending if the value was in the array or not.
    * If x turned out to be false, and size == set.length then it would call the
    * increaseCapacity method so that way the array set would double in size. If not
    * the only ehing the program would execute is that it would store the variable
    * value in the set array at the size index, and size would increment by one.*/
    public void add(int value) {
        boolean x = contains(value);
        if (!x) {
            if (size == set.length) {
                increaseCapacity();
            }
            set[size] = value;
            size++;
        }
    }

}
