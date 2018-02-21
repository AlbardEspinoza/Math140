public class Exchange {
    public static void placeSmallestAtPositionZero(Comparable[] arr) {
        if (arr != null) {
            int smallest = 0;
            for (int x = 0; x < arr.length; x++) {
                if (arr[x].compareTo(arr[smallest]) < 0) {
                    /*In the if statement argument you call the compareTo method
                    to compare arr[x] and arr[smallest], the compareTo method
                    basically arr[x] to arr[smallest] if it returned result is positive
                    it means arr[x] is bigger that arr[smallest], if it returns negative
                    arr[smallest] is bigger than arr[x], then the if statement runs.
                    You need to create a Comparable array or variable to be able to use the
                    methods in the Compare class.
                    Remember Objects created from a class can use the methods from their class.
                    Classes can only use other classes methods if they extend that class or if its
                    their parent class.
                    You have to use the compareTo method
                    because you can't compare 2 objects with "><".*/
                    smallest = x;
                }
            }
            Comparable temp = arr[0];
            arr[0] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}
