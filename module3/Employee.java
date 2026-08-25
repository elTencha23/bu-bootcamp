import java.util.ArrayList;
import java.util.HashMap;

public class Employee {
    private String name;
    private double salary;

    //Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
    return name + " - $" + salary;
}

    public static void printTeam(ArrayList<Employee> team) {
        for (Employee emp : team) { 
            System.out.println(emp);   // calls toString automatically 
        } 
    }

    public static void main(String[] args) {
        ArrayList<Employee> team = new ArrayList<>();
        team.add(new Employee("Ada Lovelace",  95000.0)); 
        team.add(new Employee("Alan Turing", 02000.0)); 
        team.add(new Employee("Grace Hopper", 110000.0)); 
        printTeam(team);


        // A lookup table: name -> Employee 
    HashMap<String, Employee> directory = new HashMap<>(); 
    for (Employee emp : team) { 
        directory.put(emp.getName(), emp); 
    } 

    Employee found = directory.get("Ada Lovelace"); 
    System.out.println(found.getSalary());   // 95000.0
    }

}