
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Employee> employees = new ArrayList<>();

    public static void addEmployee(int id, String name, String department) {
        Employee employee = new Employee(id, name, department);
        employees.add(employee);
    }

    public static void listEmployees() {
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + "| Name: " + employee.getName() + "| Department: " + employee.getDepartment());
        }
    }

    public static void searchEmployeeByDepartment(String department) {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                System.out.println("ID: " + employee.getId() + "| Name: " + employee.getName() + "| Department: " + employee.getDepartment());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found in the department: " + department);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===Employee Managemet System===");

            System.out.println();
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Search Employee by Department");
            System.out.println("4. Exit");

            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Department: ");
                    String department = scanner.nextLine();
                    addEmployee(id, name, department);
                    break;
                case 2:
                    listEmployees();
                    break;
                case 3:
                    System.out.print("Enter Department to search: ");
                    String searchDepartment = scanner.nextLine();
                    searchEmployeeByDepartment(searchDepartment);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

}
