import java.util.Iterator;

public class TestMyArrayListIterator {
    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add("" + i);
        }
        for (Iterator<String> i = arr.iterator(); i.hasNext(); ) {//This for loop is calling the MyArrayList class.
            System.out.println(i.next());
        }
        System.out.println();
        Iterator<String> i = arr.iterator();
        i.next();
        i.next();
        System.out.println(i.next());
    }
}
