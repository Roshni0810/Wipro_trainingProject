import java.util.ArrayList;
import java.util.Scanner;

class Video {
    private String videoName;
    private boolean checkout;
    private int rating;

    public Video(String name) {
        this.videoName = name;
        this.checkout = false;
        this.rating = 0;
    }

    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        this.checkout = true;
    }

    public void doReturn() {
        this.checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public boolean getCheckout() {
        return checkout;
    }
}

class VideoStore {
    private ArrayList<Video> store;

    public VideoStore() {
        store = new ArrayList<>();
    }

    public void addVideo(String name) {
        store.add(new Video(name));
    }

    public void doCheckout(String name) {
        for (Video video : store) {
            if (video.getName().equals(name)) {
                video.doCheckout();
                break;
            }
        }
    }

    public void doReturn(String name) {
        for (Video video : store) {
            if (video.getName().equals(name)) {
                video.doReturn();
                break;
            }
        }
    }

    public void receiveRating(String name, int rating) {
        for (Video video : store) {
            if (video.getName().equals(name)) {
                video.receiveRating(rating);
                break;
            }
        }
    }

    public void listInventory() {
        for (Video video : store) {
            System.out.println("Video: " + video.getName() + ", Checkout: " + video.getCheckout() + ", Rating: " + video.getRating());
        }
    }
}

public class Project2 {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu");
            System.out.println("===========================");


            System.out.println("1. Add Video");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter video name: ");
                    String name = scanner.nextLine();
                    store.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter video name: ");
                    name = scanner.nextLine();
                    store.doCheckout(name);
                    break;
                case 3:
                    System.out.print("Enter video name: ");
                    name = scanner.nextLine();
                    store.doReturn(name);
                    break;
                case 4:
                    System.out.print("Enter video name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter rating: ");
                    int rating = scanner.nextInt();
                    store.receiveRating(name, rating);
                    break;
                case 5:
                    store.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
