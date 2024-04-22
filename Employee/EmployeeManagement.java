import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Code: " + code + ", Salary Rate: " + salaryRate;
    }
}

public class EmployeeManagement {
    private List<Employee> employeeList;
    private Scanner scanner;

    public EmployeeManagement() {
        employeeList = new ArrayList<>();
        // Khởi tạo 10 nhân viên
        employeeList.add(new Employee(1, "Nguyen Van A", 30, "IT", "IT001", 50000));
        employeeList.add(new Employee(2, "Nguyen Thi B", 35, "HR", "HR001", 55000));
        employeeList.add(new Employee(3, "Tran Van C", 40, "HR", "FIN001", 60000));
        employeeList.add(new Employee(4, "Bui Duc A", 28, "Marketing", "MKT001", 48000));
        employeeList.add(new Employee(5, "Nguyen Thi C", 32, "Sales", "SAL001", 52000));
        employeeList.add(new Employee(6, "Pham Van A", 38, "Marketing", "OPS001", 57000));
        employeeList.add(new Employee(7, "Tran Thi B ", 45, "IT", "IT002", 62000));
        employeeList.add(new Employee(8, "Ho Thuy Tien", 31, "HR", "HR002", 53000));
        employeeList.add(new Employee(9, "Le Van A", 33, "HR", "FIN002", 58000));
        employeeList.add(new Employee(10, "Nguyen Thi D", 29, "Marketing", "MKT002", 49000));

        scanner = new Scanner(System.in);
    }

    private void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    public void addEmployee() {
        System.out.println("Enter employee details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Code: ");
        String code = scanner.nextLine();
        System.out.print("Salary Rate: ");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        employeeList.add(new Employee(id, name, age, department, code, salaryRate));
        System.out.println("Employee added successfully.");
        displayEmployees();
    }

    public void removeEmployee() {
        System.out.print("Enter ID of employee to remove: ");
        int employeeId = scanner.nextInt();

        Iterator<Employee> iterator = employeeList.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == employeeId) {
                iterator.remove();
                System.out.println("Employee with ID " + employeeId + " removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("No employee found with ID " + employeeId + ".");
        }
        displayEmployees();
    }

    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();

        // Hiển thị danh sách nhân viên ban đầu
        employeeManagement.displayEmployees();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = employeeManagement.scanner.nextInt();

            switch (choice) {
                case 1:
                    employeeManagement.addEmployee();
                    break;
                case 2:
                    employeeManagement.removeEmployee();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    employeeManagement.scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}
