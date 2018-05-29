/*This code was created by Albard Espinoza. The purpose of this program is to make a doubly LinkedList
* that sorts its objects by the preference of the user by implementing the users lambda expressions.*/

import java.util.Comparator;
import java.util.Iterator;

public class SortedLinkedList<E> implements Iterable<E> {

    private Comparator<E> c;
    private Node head;
    private Node last;
    private int size;

    public SortedLinkedList(Comparator<E> c) {
        this.c = c;
    }

    /*If you add another generic into this class the compiler will see it as you are
    * trying to pass another generic to the class different from the first one 'E'.
    * Ex: public class Node<E>{. Your creating this private inner class Node so you can use
    * Node objects and so nobody outside this class can create Node objects.*/
    private class Node {
        private E item;
        private Node next;
        private Node prev;

        private Node(E item) {
            this.item = item;
        }
    }

    public int size() {
        return size;
    }

    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = null;
        if (i == 0) {
            tmp = head.item;
            if (size == 1) {
                head = last = null;
            } else {
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
        size--;
        return tmp;
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node ptr = head;
        for (int index = 0; index < i; index++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    /*The first thing the add method checks is if the size of the LinkedList = 0(head == null), if that's
    * the case then it assigns a 'node' to last which then assigns it to head. If the size of the
    * LinkedList is one or more the add method checks if the given item is <= to the item in head if
    * it is it connects node to the head and sets head to node. If it isn't it checks if its >= to
    * last.item and does the same process but to last. If none of the previous if statements is true
    * then it means that the object sorted position is in the middle so to check in what specific
    * position it needs to be I created a for loop that iterates as long as x < size and
    * c.compare(item,ptr.item) > 0 is true, in the body of the for loop I made it so that ptr would
    * advance to the next position. After the for loop became false ptr would be in the node that
    * 'node' will be connected in between. After connecting all the nodes together I increased size
    * by 1 and returned true.*/
    public boolean add(E item) {
        Node node = new Node(item);
        if (size == 0) {
            head = last = node;
        } else if (c.compare(item, head.item) <= 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (c.compare(item, last.item) >= 0) {
            last.next = node;
            node.prev = last;
            last = node;
        } else {
            Node ptr = head;
            for (int x = 0; x < size && c.compare(item, ptr.item) > 0; x++) {
                ptr = ptr.next;
            }
            node.next = ptr;
            node.prev = ptr.prev;
            ptr.prev.next = node;
            ptr.prev = node;
        }
        size++;
        return true;
    }

    /*This method returns sublist of the original LinkedList only with values that are less than
    * item.*/
    public SortedLinkedList<E> lessThan(E item) {
        SortedLinkedList<E> x = new SortedLinkedList<>(c);
        Node ptr = head;
        for (int y = 0; y < size && ptr != null; y++) {
            if (c.compare(item, ptr.item) > 0) {
                x.add(ptr.item);
            }
            ptr = ptr.next;
        }
        return x;
    }

    /*This method returns a a sublist that contains values greater than item.*/
    public SortedLinkedList<E> greaterThan(E item) {
        SortedLinkedList<E> x = new SortedLinkedList<>(c);
        Node ptr = head;
        for (int y = 0; y < size && ptr != null; y++) {
            if (c.compare(item, ptr.item) < 0) {
                x.add(ptr.item);
            }
            ptr = ptr.next;
        }
        return x;
    }

    public Iterator<E> iterator() {
        return new SortedLinkedListIterator();
    }

    private class SortedLinkedListIterator implements Iterator<E> {
        Node ptr = head;

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
