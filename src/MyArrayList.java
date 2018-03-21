import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

    private E[] list;
    private int size;

    public MyArrayList() {//Why empty parentheses and casting when not receiving anything?
        list = (E[]) new Object[10];//Why casting?
        /*Because the constructor doesn't know what kind of object it is going to receive
          so it sets it to receive an object(this works because the object class is the highest
          class of all and an object can be any data type) then it casts the incoming input to
          an array of E objects.*/
    }

    private void increaseCapacity() {//Every time you call a method and the method calls a method without a variable behind the function that the method does it's going to affect the variable that called the method form the main class, the one that has is a Object from that class that has memory allocated for it in that class.//TODO; verify.
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

    public void add(int index, E e) {
        if (index == 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (size == list.length) {
            increaseCapacity();
        }
        System.arraycopy(list, index, list, index + 1, size - index);//TODO; practice this
        list[index] = e;
        size++;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = e;
        list[index] = e;
        return tmp;
    }

    //Code for iterator
    public Iterator<E> iterator() {//Constructor
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int index = 0;

        public boolean hasNext() {
            return index < size;//Stop iterating when index = size.
        }

        public E next() {
            return list[index++];//Return current item; advance index.
        }

    }
}

//TODO;Understand this whole class.