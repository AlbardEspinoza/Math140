
public class Test {   // 2-pts

    public static void main(String[] args) {

        boolean flag;
        Set s = new Set(8);

        s.add(4);
        System.out.println("Size of the set: " + s.size());

        s.add(100);
        System.out.println("Size of the set: " + s.size());

        s.add(23);
        System.out.println("Size of the set: " + s.size());
        System.out.println("Contents of the set: " + s);
        flag = s.remove(2);
        if (flag) {
            System.out.println("An element was removed from the set");
        } else {
            System.out.println("An element was not removed from the set");
        }
        System.out.println();
        s.clear();
        System.out.println("Contents of the set: " + s);
        System.out.println();
        s.add(50);
        s.add(24);
        s.add(101);
        s.add(45);
        System.out.println("Size of the set: " + s.size());
        System.out.println("Contents of the set: " + s);
        System.out.println();
        flag = s.remove(50);
        if (flag) {
            System.out.println("An element was removed from the set");
        } else {
            System.out.println("An element was not removed from the set");
        }
        System.out.println("Size of the set: " + s.size());
        System.out.println("Contents of the set: " + s);
        System.out.println();
        s.clear();
        for (int i = 0; i < 20; i++) {
            s.add(i);
        }
        System.out.println("Size of the set: " + s.size());//Prints until this line.
        System.out.println("Contents of the set: " + s);
        System.out.println();
        s.add(10);
        System.out.println("Size of the set: " + s.size());
        System.out.println("Contents of the set: " + s);

    }
}
