import java.util.ArrayList;
import java.util.List;

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

    public EmployeeManagement() {
        employeeList = new ArrayList<>();
        // Khởi tạo 10 nhân viên
        employeeList.add(new Employee(1, "John Doe", 30, "IT", "IT001", 50000));
        employeeList.add(new Employee(2, "Jane Smith", 35, "HR", "HR001", 55000));
        employeeList.add(new Employee(3, "Michael Johnson", 40, "Finance", "FIN001", 60000));
        employeeList.add(new Employee(4, "Emily Davis", 28, "Marketing", "MKT001", 48000));
        employeeList.add(new Employee(5, "Chris Wilson", 32, "Sales", "SAL001", 52000));
        employeeList.add(new Employee(6, "Jessica Brown", 38, "Operations", "OPS001", 57000));
        employeeList.add(new Employee(7, "Daniel Lee", 45, "IT", "IT002", 62000));
        employeeList.add(new Employee(8, "Sarah Taylor", 31, "HR", "HR002", 53000));
        employeeList.add(new Employee(9, "Matthew Anderson", 33, "Finance", "FIN002", 58000));
        employeeList.add(new Employee(10, "Amanda Martinez", 29, "Marketing", "MKT002", 49000));
    }

    public void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                employeeList.remove(employee);
                System.out.println("Employee with ID " + employeeId + " removed successfully.");
                return;
            }
        }
        System.out.println("No employee found with ID " + employeeId + ".");
    }

    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.displayEmployees();

        // Thêm một nhân viên mới
        employeeManagement.addEmployee(new Employee(11, "Alex Johnson", 27, "Sales", "SAL002", 51000));

        // Xóa một nhân viên
        employeeManagement.removeEmployee(5);

        // Hiển thị danh sách sau khi thay đổi
        employeeManagement.displayEmployees();
    }
}
