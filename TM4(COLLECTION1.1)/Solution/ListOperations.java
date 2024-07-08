import java.util.ArrayList;
import java.util.Scanner;

public class ListOperations {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to be inserted: ");
                    String itemToInsert = scanner.nextLine();
                    list.add(itemToInsert);
                    System.out.println("Inserted successfully");
                    break;

                case 2:
                    System.out.print("Enter the item to be searched: ");
                    String itemToSearch = scanner.nextLine();
                    if (list.contains(itemToSearch)) {
                        System.out.println("Item found");
                    } else {
                        System.out.println("Item not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter the item to be deleted: ");
                    String itemToDelete = scanner.nextLine();
                    if (list.remove(itemToDelete)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item not found");
                    }
                    break;

                case 4:
                    System.out.println("Displaying all items:");
                    for (String item : list) {
                        System.out.println(item);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
