
public class Test {

    public static void main(String[] args) {

        // Test complement
        Set setOne = new Set(10);
        for (int i = 0; i < 20; i++) {
            setOne.add(i);
        }
        System.out.println("Set One: " + setOne);
        Set setTwo = new Set(10);
        for (int i = 20; i < 40; i++) {
            setTwo.add(i);
        }
        System.out.println("Set Two: " + setTwo);
        Set setThree = setOne.complement(setTwo);
        System.out.println("Set Three: " + setThree);
        setTwo.clear();
        for (int i = 10; i < 40; i++) {
            setTwo.add(i);
        }
        System.out.println("Set Two: " + setTwo);
        setThree = setOne.complement(setTwo);
        System.out.println("Set Three: " + setThree);

        //Test union
        System.out.println();
        setThree = setOne.union(setTwo);
        System.out.println("Set Three: " + setThree);
        setOne.clear();
        for (int i = 0; i < 10; i++) {
            setOne.add(i);
        }
        setTwo.clear();
        for (int i = 100; i < 110; i++) {
            setTwo.add(i);
        }
        setThree = setOne.union(setTwo);
        System.out.println("Set Three: " + setThree);
        //Test removeAll
        System.out.println();
        setOne.add(100);
        System.out.println("Set One: " + setOne);
        System.out.println(setOne.removeAll(setTwo));
        System.out.println("Set One: " + setOne);
        System.out.println(setOne.removeAll(setTwo));   // repeat
        System.out.println("Set One: " + setOne);
        System.out.println(setOne.removeAll(setOne));  // remove all elements
        System.out.println("Set One: " + setOne);
        //Test retainAll
        System.out.println();
        setOne.clear();
        setTwo.clear();
        for (int i = 0; i < 10; i++) {
            setOne.add(i);
        }
        for (int i = 5; i < 15; i++) {
            setTwo.add(i);
        }
        System.out.println(setOne.retainAll(setOne));
        System.out.println("Set One: " + setOne);
        System.out.println(setOne.retainAll(setTwo));
        System.out.println("Set One: " + setOne);
        setTwo.clear();
        for (int i = 50; i < 55; i++) {
            setTwo.add(i);
        }
        System.out.println(setOne.retainAll(setTwo));
        System.out.println("Set One: " + setOne);

        Set m = new Set(10);
        for (int x = 1; x <= 10; x++) {
            m.add(x);
        }
        Set y = new Set(10);
        for (int x = 5; x <= 15; x++) {
            y.add(x);
        }
        System.out.println(y.union(m));//TODO; Why does it print the curly braces?
        //Because remember when you call the name of the variable only it calls the toString.

        Set x = new Set(10);
        x.add(3);
        x.add(4);
        x.add(5);


        System.out.print("This ");
        System.out.print("is ");
        System.out.print("printing ");
        System.out.print("consistently ");
        System.out.print("on ");
        System.out.print("a ");
        System.out.print("single ");
        System.out.print("line.");
        System.out.println(" Will this create a line break?");//No.
        System.out.println("This will.");
        System.out.print("Although you can still attach print statements to it, until you create another line break.");
        System.out.println(" Another line break wont create a new line, use /n if you want. \nLike this");

    }
}
