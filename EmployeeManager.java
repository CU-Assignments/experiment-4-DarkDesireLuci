
//Easy Exp_4
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    static List<Employee> employees = new ArrayList<>();
    
    static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
    }
    
    static void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = name;
                emp.salary = salary;
                return;
            }
        }
    }
    
    static void removeEmployee(int id) {
        employees.removeIf(emp -> emp.id == id);
    }
    
    static Employee searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                return emp;
            }
        }
        return null;
    }
    
    static void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display Employees\n6. Exit");
            int choice = sc.nextInt();
            if (choice == 6) break;
            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Name, Salary:");
                    addEmployee(sc.nextInt(), sc.next(), sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter ID to update, New Name, New Salary:");
                    updateEmployee(sc.nextInt(), sc.next(), sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Enter ID to remove:");
                    removeEmployee(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter ID to search:");
                    Employee emp = searchEmployee(sc.nextInt());
                    System.out.println(emp == null ? "Employee not found" : emp);
                    break;
                case 5:
                    displayEmployees();
                    break;
            }
        }
        sc.close();
    }
}