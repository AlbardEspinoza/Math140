public class Person implements Comparable<Person> {

    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Age: " + age + "Name: " + firstName + " " + lastName;
    }

    public int compareTo(Person a) {
        return a.age - this.age;//Descending order.
    }

}
