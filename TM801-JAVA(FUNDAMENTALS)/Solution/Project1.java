public class Project1 {
    public static void main(String[] args) {
        // Initialize arrays with employee details
        int[] empNo = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
        String[] empName = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
        String[] department = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
        char[] designationCode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
        int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
        int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
        int[] it = {2000, 3000, 1000, 2000, 20000, 4400, 10000};
        
        // Fetch employee ID from command line argument
        int empId = Integer.parseInt(args[0]);
        
        // Search for employee details based on employee ID
        int index = -1;
        for (int i = 0; i < empNo.length; i++) {
            if (empNo[i] == empId) {
                index = i;
                break;
            }
        }
        
        // If employee found, display details
        if (index != -1) {
            System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
            System.out.println(empNo[index] + "\t" + empName[index] + "\t\t" + department[index] + "\t\t" +
                    getDesignation(designationCode[index]) + "\t\t" + calculateSalary(basic[index], hra[index], it[index], designationCode[index]));
        } else {
            System.out.println("There is no employee with empid : " + empId);
        }
    }
    
    // Method to calculate designation based on code
    public static String getDesignation(char code) {
        switch(code) {
            case 'e':
                return "Engineer";
            case 'c':
                return "Consultant";
            case 'k':
                return "Clerk";
            case 'r':
                return "Receptionist";
            case 'm':
                return "Manager";
            default:
                return "Unknown";
        }
    }
    
    // Method to calculate salary
    public static int calculateSalary(int basic, int hra, int it, char code) {
        int da = 0;
        switch(code) {
            case 'e':
                da = 20000;
                break;
            case 'c':
                da = 32000;
                break;
            case 'k':
                da = 12000;
                break;
            case 'r':
                da = 15000;
                break;
            case 'm':
                da = 40000;
                break;
        }
        return basic + hra + da - it;
    }
}
