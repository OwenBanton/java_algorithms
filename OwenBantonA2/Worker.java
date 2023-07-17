// Owen Banton

package javaProjects.OwenBantonA2;

/**
 * Worker class as described in assignment instructions with name and salary attributes, constructor and a toString function.
 */
public class Worker {

    public String name;

    public int salary;

    public Worker() {
    }

    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Salary: " + salary;
    }


    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
