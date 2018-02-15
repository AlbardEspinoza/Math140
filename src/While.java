public class While {
    public static void main(String[] args) {
        int x = 0;
        while (x < 100) {
            System.out.println(x);
            x++;
        }
        System.out.println(x);

        int[] l = new int[10];//TODO; can these two variables access the methods from the set class?
        //No, only Set objects are allowed to use objects from the set class.
        Set m = new Set(2);

        //l.contains(3); compiler error.
        m.contains(3);

        m.add(3);
        m.add(4);
        m.add(5);
        m.add(6);
        m.add(7);
        m.add(9);

        String o = m.toString();
        System.out.println(o);
        System.out.println("Line Break");

        Set a = new Set(10);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.remove(10);
        System.out.println(a.toString());
        System.out.println("Line Break");
        Set b = new Set(10);
        System.out.println(b.toString());

    }
}
