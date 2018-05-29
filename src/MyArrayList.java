
//This code was created by Albard Espinoza.
/*This assignment was basically finalizing the MyArrayList class. We added a few methods that could receive
* lambda expressions in there parameters*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyArrayList<E> implements Iterable<E> {

    private E[] list;
    private int size;

    public MyArrayList() {
        list = (E[]) new Object[10];
    }

    /*The statement Consumer<? super E> means you don't know what kind of datatype
    * it's going to be in the Collection received so you make it generic so it can
    * receive any type of datatype Collection, ex: Consumer<String>, Consumer<Integer>,
    * Consumer<Car>, etc... I made a for loop so it could go through everything in
    * list. The consumer interface has a method called accept which
    * basically does whatever function its stored in c.*/
    public void forEach(Consumer<? super E> c) {
        for (int i = 0; i < size; i++) {
            c.accept(list[i]);
        }
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == list.length) {
            increaseCapacity();
        }
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = e;
        size++;
    }

    private void increaseCapacity() {
        E[] newList = (E[]) new Object[2 * list.length];
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        if (size == list.length) {
            increaseCapacity();
        }
        list[size++] = e;
        return true;
    }

    public boolean contains(Object o) {
        boolean flag = false; // assume object is not in the list
        int index = 0;
        while (index < size && !flag) {
            flag = equals(o, list[index++]);  // o = target, list[index] = element
        }
        return flag;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = list[index];
        list[index] = e;
        return tmp;
    }

    public E remove(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E temp = list[index];
        System.arraycopy(list, index + 1, list, index, size - index - 1);
        size--;
        return temp;

    }

    // returns true if target equals element
    private boolean equals(Object target, Object element) {
        boolean flag = false;
        if (target == null) {
            flag = element == null;
        } else {  // target isn't null
            flag = target.equals(element); // element.equals(target) can lead to runtime error
        }
        return flag;
    }

    // Code for the iterator
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {

        private int index = 0;

        public boolean hasNext() {
            return index < size;   // stop iterating when index = size
        }

        public E next() {
            return list[index++];  // return current item; advance index
        }

    }

    /*This method receives a parameter of type Predicate which is an interface so it can receive any object as long as its
    underlying class implements the Predicate interface. First I initialized a boolean variable and set it to false. after
    that i crated a for loop that loops through list. The Predicate interface has a method called test which basically tests
    the variable it's on and see if satisfies the given condition(filter), if it does it return true if not it returns false.
    In the parameters of the if statement I just set it so that if the test method returned true the boolean expression
    be converted to false that way it would'nt remove it. If test returned false the boolean expression would turn true and
    it would remove the given variable from list, decrease y by 1, and set the boolean expression to true.*/
    public boolean retainIf(Predicate<E> filter) {
        boolean x = false;
        for (int y = 0; y < size; y++) {
            if (!filter.test(list[y])) {
                remove(y--);
                x = true;
            }
        }
        return x;
    }

    /*This method is nearly identical to retainIf. The only thing that changes is that if test returns true the if statement
    * boolean expression becomes true so it removes the given variable from list.*/
    public boolean removeIf(Predicate<E> filter) {
        boolean x = false;
        for (int y = 0; y < size; y++) {
            if (filter.test(list[y])) {
                remove(y--);
                x = true;
            }
        }
        return x;
    }

    /*This method receives a an object of type Function that contains two type of datatypes. First I made a for loop so
    * that it would go through list. The Function interface has a method called apply that basically applies the given
    * operation(operator) to the given variable. In the body of the for loop the the apply methos would return an object
    * of type Rectangle that its nearly the same as the object at list[x], but with the given operator applied. The
    * returned object is stored in list[x].*/
    public void replaceAll(Function<E, E> operator) {
        for (int x = 0; x < size; x++) {
            list[x] = operator.apply(list[x]);
        }
    }

    /*This method receives an object of type Comparator. First I initialized an generic array tmp, then I copied everything
    * from list to tmp. I used the Arrays.sort method so it sorts the array for me. In the parameters of Array.sort I passed
    * it tmp and c, i needed to put the c in there that way Arrays.sort would know how I cant my array sorted. Arrays.sort has
    * an overloaded method that receives the array and a Comparator object, c in this case is out comparator. At the end I set
    * the reference of list to the reference of tmp.*/
    public void sort(Comparator<E> c) {
        E[] tmp = (E[]) new Object[size];
        System.arraycopy(list, 0, tmp, 0, size);
        Arrays.sort(tmp, c);
        list = tmp;
    }

    /*This method returns an array that stores a portion of list. First to check for errors I made two if statements. The
    * first if statement would check if fromIndex was less that 0 or if toIndex was bigger that size. I any of these was
    * true it would throw and IndexOutOfBoundsException(). The second if statement would check if fromIndex was bigger then
    * toIndex, if this was true it would throw an IllegalArgumentException(). Then I created a MyArrayList object and set it
    * size to equal toIndex - fromIndex. After that I copied a portion of list to tmp, that portion would start at the index
    * fromIndex and would end when it copied the about of iterations toIndex-FromIndex was. At the end it would return tmp.*/
    public MyArrayList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException();//TODO; Get familiar with try, catch, and exceptions, specially the ones on Midterm 1.
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }
        MyArrayList<E> tmp = new MyArrayList<>();
        tmp.size = toIndex - fromIndex;
        System.arraycopy(list, fromIndex, tmp.list, 0, toIndex - fromIndex);
        return tmp;
    }


}


//TODO; get familiar with lambda expressions and how to use them in method parameters.