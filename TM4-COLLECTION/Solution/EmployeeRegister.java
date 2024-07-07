import java.util.*;

class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String address;

    public Employee(String firstName, String lastName, String mobile, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(Employee other) {
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-30s %-15s", firstName, lastName, mobile, email, address);
    }
}

public class EmployeeRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the Number of Employees:");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        
        List<Employee> employees = new ArrayList<>();
        
        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.println("Enter Employee " + i + " Details:");
            System.out.println("Enter the Firstname:");
            String firstName = scanner.nextLine();
            System.out.println("Enter the Lastname:");
            String lastName = scanner.nextLine();
            System.out.println("Enter the Mobile:");
            String mobile = scanner.nextLine();
            System.out.println("Enter the Email:");
            String email = scanner.nextLine();
            System.out.println("Enter the Address:");
            String address = scanner.nextLine();
            
            Employee employee = new Employee(firstName, lastName, mobile, email, address);
            employees.add(employee);
        }
        
        Collections.sort(employees);
        
        System.out.println("\nEmployee List:");
        System.out.format("%-15s %-15s %-15s %-30s %-15s\n", "Firstname", "Lastname", "Mobile", "Email", "Address");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        
        scanner.close();
    }
}
