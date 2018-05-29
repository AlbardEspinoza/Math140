import java.util.Arrays;

public class TestLambda {
    public static void display(String[] arr) {
        for (String x : arr) {
            System.out.println(x);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String[] list = {"house", "book", "cat", "abcd", "Seven", "tsr", "monday", "Abcdefg"};
        Arrays.sort(list); // sorts by lexigraphical ordering
        display(list);

        //Sort by ascending length
        Arrays.sort(list, (a, b) -> a.length() - b.length());//TODO;Ask professor about sorting in ascending,descending,length,etc...
        display(list);

        //Sort by descending length
        Arrays.sort(list, (a, b) -> b.length() - a.length());
        display(list);


        // Write code that sorts the Strings in reverse lexigraphical ordering

        Arrays.sort(list, (x, y) -> -x.compareTo(y));//You use the compareTo for Strings.
        /*What the lambda expression does is that you can override the method in any interface
        * so you don't have to build from scratch the interface.*/

        ArraySort m = new ArraySort();

        String[] y = {"Keep", "working", "hard", "you'll", "get", "your", "A"};
        Arrays.sort(y, m);
        /*You created a class called ArraySort which implements the comparator interface
        on which you only included one method the compare in which you make it sort the way
        you want to. when you create an object from that class it's basically a comparator
        object. You can also send the pure reference which is new ArraySort. */
        System.out.println("");
        System.out.println(Arrays.toString(y));

        double sum = 0;
        for (int x = 1; x <= 30; x++) {
            sum += 40.0 / (x + 25);
        }

        sum *= (1.0 / 5);

        //System.out.printf("%6",sum);
        System.out.println(sum);


    }


}


