import java.util.Iterator;

public class MyLinkedList<E> implements Iterable {

    private Node head;
    private Node last;
    private int size;
    /*When you don't have a defined constructor the default constructor initializes the
    * private instance variables anyway. The Node(all variables that are not int or doubles)
    * variables will be set to null and int variables will be set to 0.*/

    private class Node {
        private E item;
        private Node next;
        private Node prev;

        private Node(E item) {
            this.item = item;
        }

        public boolean add(E item) {
            Node node = new Node(item);
            if (head == null) {
                head = last = node;
            } else {
                last.next = node;
                node.prev = last;
                last = node;
            }
            size++;
            return true;
        }

    }


    //TODO; KNow this for next quiz.
    public E get(int i) {//TODO; Would this method be in the MyLinkedList class or the node class?
        if (i < 0 || i >= size) {//i = # of index.
            throw new IndexOutOfBoundsException();//TODO; what do exceptions do?
        }
        Node ptr = head;
        E tmp;
        for (int index = 0; index < i; index++) {
            ptr = ptr.next;//ptr.next goes to the next Node of the LinkedList.
        }
        return ptr.item;
    }

    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        E tmp;
        if (i == 0) {
            if (size == 1) {
                tmp = head.item;
                head = last = null;
            } else {
                tmp = head.item;
                head = head.next;
                head.prev = null;
            }
        } else if (i == size - 1) {
            tmp = last.item;
            last = last.prev;
            last.next = null;
        } else {
            Node ptr = head;
            for (int index = 0; index < i; index++) {
                ptr = ptr.next;
            }
            tmp = ptr.item;
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
        return tmp;
    }

    public Iterator<E> iterator() {
        return new MyLinkedListIterator();//Returns an iterator object.
    }

    /*if you added diamond braces into the head of this class the compiler would think your passing another type of generic
    * into the class so that's why you would have to cast in the next method because you would be receiving an object that
    * maybe be different from that class object and you need to cast them so they can be the same object.*/
    private class MyLinkedListIterator implements Iterator<E> {//Iterator <E> means your passing it the same type of object as the one MyArrayList is receiving.
        private Node ptr = head;

        public boolean hasNext() {
            return ptr != null;
        }

        public E next() {
            E tmp = ptr.item;
            ptr = ptr.next;
            return tmp;
        }
    }

}
//TODO; When do we have to initialize a variable?
