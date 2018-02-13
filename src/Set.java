public class Set { //TODO; Write name and a brief description of the assignment.

    private int[] set;
    private int size;//Remember uninitialized instance variables always have the default value of 0.


    public Set(int capacity) {/*Remember the name of the class and the name of the constructor have to be identical.
    because ex: Circle2 x = new Circle2(2,3); the first Circle2 means the object is a Circle2 object,
    the second Circle2 is calling the constructor to allocate new memory for that object in that class.*/
        set = new int[capacity];//In this line you're allocating memory to the set array.
    }

    private void increaseCapacity() {
        int[] x = new int[set.length * 2];
        System.arraycopy(set, 0, x, 0, set.length);
        set = x;/* In this line you're assigning the same reference to both of them so it basically
        points to the same address therefore set and x have the same data.*/
    }
    /*Use system array copy to copy data in the array into a new variable with the right size,
     because once you create an array you cant edit its length, unless you point to a new
     reference.*/

    public boolean contains(int value) {
        boolean x = false;
        int y = 0;
        while (y < size && !x) {
            if (set[y] == value) {
                x = true;
            }
            y++;
        }
        return x;
    }

    public void add(int value) {
        boolean x = contains(value);
        if (!x) {//!x is equal to x == false.
            if (size == set.length) {
                increaseCapacity();
            }
            set[size] = value;
            size += 1;

        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.set = new int[10];
        this.size = 0;
    }

    public boolean remove(int value) {
        boolean x = contains(value);
        if (x) {
            int y = 0;
            while (set[y] != value) {
                y++;
            }
            System.arraycopy(set, y + 1, set, y, size - y - 1);
            size--;
        }
        return x;
    }
}


