public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.salary = salary;
        this.age = age;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Employee x) {
        return x.getSalary() - this.getSalary();
    }

}
