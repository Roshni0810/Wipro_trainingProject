import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Box box = (Box) obj;
        return Double.compare(box.getVolume(), this.getVolume()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(getVolume()).hashCode();
    }

    @Override
    public String toString() {
        return "Length = " + length + " Width = " + width + " Height = " + height + " Volume = " + getVolume();
    }
}

public class UniqueBoxSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Box> boxSet = new HashSet<>();

        System.out.println("Enter the number of Box");
        int numberOfBoxes = scanner.nextInt();

        for (int i = 1; i <= numberOfBoxes; i++) {
            System.out.println("Enter the Box " + i + " details");

            System.out.println("Enter Length");
            double length = scanner.nextDouble();

            System.out.println("Enter Width");
            double width = scanner.nextDouble();

            System.out.println("Enter Height");
            double height = scanner.nextDouble();

            Box box = new Box(length, width, height);
            boxSet.add(box);
        }

        System.out.println("Unique Boxes in the Set are");
        for (Box box : boxSet) {
            System.out.println(box);
        }

        scanner.close();
    }
}
