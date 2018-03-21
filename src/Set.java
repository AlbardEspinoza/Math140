public class Set {
    /*This code was created by Albard Espinoza. This is just another version
    * of the ArrayList class, it has all the same methods and it performs almost the same
    * commands.
    * This code works with arrays with special methods to unite the contents of an array,
    * remove some of the contents of the array, etc...*/

    private int[] set;
    private int size;

    /*The constructor is just allocating memory for the set array.*/
    public Set(int capacity) {
        this.set = new int[capacity];
    }

    /*In this method you're doubling the capacity of the set array.*/
    private void increaseCapacity() {//TODO; how does it know which variable its increasing its capacity when its called from another method.
        int[] y = new int[set.length * 2];
        System.arraycopy(set, 0, y, 0, set.length);
        set = y;/*In this line you're just pointing y and set to the same
        reference, therefore they have the same values. NOTE: you're not copying
        the elements of y into set you're just simply pointing set to the same
        address.*/
        //TODO; does this line also edit the length of set to be as big as y's?
        /*It does'nt edit it it simply gives it the same reference as y, it
        * gives it a new address.*/
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
            y++;
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
    * the only thing the program would execute is that it would store the variable
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

    /*When this method is called it just returns the int  value stored in the
    address of size.*/
    public int size() {
        return this.size;
    }

    /*When this method id called it resets the set array and gives ir a capacity
    * of 10 integers and size gets set the value of 0.*/
    public void clear() {
        this.set = new int[10];
        this.size = 0;
    }

    /*In this method where removing a certain element of the set array(depends on what
    value is), if it's even there. First we create a boolean variable x and call the
    contains method from it, this way the contains method checks if the variable
    stored in value is even in the set array. If the variable is in the set array it
    will return true, if not it will return false, at the end the returned boolean value
    will be stored in the x variable. After that I placed an if statement so that if x
    turned out to be true it would follow the if statements commands, if x turned out
    false the whole method would just return false. I placed an a while loop within
    the if statement so it could check at what index in the set array the variable with
    the same contents as 'value' was stored. When the while loop ends the variable
     'y' will have store the index number value is stored in the set array. After that
     I used System.arraycopy() to shift all the elements from y + 1 to the right one
     position therefore eliminating y in the set array(you're basically copying over
     it). System.arraycopy(source, source position, destination, destination position,
     # of elements you're going to copy). At the end of the if statement we just
     decreased size by 1 and after the if statement we returned x.*/
    public boolean remove(int value) {
        boolean x = contains(value);
        if (x) {
            int y = 0;
            while (value != set[y]) {
                y++;
            }
            System.arraycopy(set, y + 1, set, y, size - y - 1);//TODO; Finish this.
            size--;
        }
        return x;
    }

    /*To make this method return the whole set enclosed in curly braces and separated by commas
    * I simply used a for loops and performed string concatenation in its body.*/
    public String toString() {
        String y = "{";
        for (int x = 0; x < size - 1; x++) {
            y += set[x] + ",";//TODO; you're close just correct this.
        }
        if (size != 0) {
            y += set[size - 1] + "}";
        } else if (size == 0) {
            y = "{}";
        }
        return y;

    }

    /*I created a new variable tmp to store all the items we would want to return at the end.
    * I used a for loop to "search" through the contents of the array, after that I set an if
    * statement and in the parameters I called the contains method, I added the "!" so
    * if the method returned false it meant it didn't contain it so the boolean would change to
    * true and it would run the code in its's body which would basically add the conntent
    * at set[x].*/
    public Set complement(Set s) {
        Set tmp = new Set(10);//TODO; Why are we setting the capacity to 10?
        for (int x = 0; x < size; x++) {
            if (!s.contains(set[x])) {//set[x] refers to the items in the array of the variable that called the method.
                tmp.add(set[x]);
            }
        }
        return tmp;
    }

    /*I created a new variable tmp to store all the items we would want to return at the end.
    * I used a for loop to go through the contents of the Set array of the variable that called
    * the method. I used a second for loop to go through the contents of the s Set array. In
    * both of the for loops body's I added the contents of Set arrays to tmp. At the end
    * it just returned the Set array tmp.*/
    public Set union(Set s) {//problem study this, s address.
        Set tmp = new Set(10);//TODO; why was p+ an error?
        for (int x = 0; x < size; x++) {
            tmp.add(set[x]);
        }
        for (int x = 0; x < s.size; x++) {
            tmp.add(s.set[x]);
        }
        return tmp;
    }

    /*This method is very simple, basically it removes the mutual contents form the arrays
    * that called the method and s method.*/
    public boolean removeAll(Set s) {
        boolean y = false;
        for (int x = 0; x < size; x++) {
            if (s.contains(set[x])) {
                remove(set[x]);
                y = true;
                x--;
            }
        }
        return y;
    }

    /*This method removes the contents of the original Set array(array of the variable
    * that called the method) that are not contained in the s array. It returns true
    * if at least one element is removed, if not it returns false.*/
    public boolean retainAll(Set s) {
        boolean y = false;
        int p = 0;
        int[] tmp = new int[size];
        for (int x = 0; x < size; x++) {
            if (s.contains(set[x])) {
                tmp[p] = set[x];
                y = true;
                p++;
            }
        }
        size = p;
        set = tmp;
        return y;
    }

}

//TODO; Review the whole code and redo it yourself.
//TODO; REVIEW REVIEW REVIEW
