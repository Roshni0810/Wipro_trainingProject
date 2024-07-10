import java.util.*;

class Card {
    String symbol;
    int number;

    Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of cards
        System.out.println("Enter Number of Cards :");
        int numOfCards = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Map<String, List<Card>> cardMap = new HashMap<>();

        // Collect card details from the user
        for (int i = 1; i <= numOfCards; i++) {
            System.out.println("Enter card " + i + " symbol:");
            String symbol = scanner.nextLine().toLowerCase();

            System.out.println("Enter card " + i + " number:");
            int number = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Create a new card
            Card card = new Card(symbol, number);

            // Add card to the map
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(card);
        }

        // Get distinct symbols and sort them
        Set<String> distinctSymbols = new TreeSet<>(cardMap.keySet());

        // Print the results
        System.out.println("Distinct Symbols are :");
        for (String symbol : distinctSymbols) {
            System.out.print(symbol);
        }
        System.out.println();

        for (String symbol : distinctSymbols) {
            System.out.println("Cards in " + symbol + " Symbol");
            List<Card> cards = cardMap.get(symbol);
            int sum = 0;

            for (Card card : cards) {
                System.out.println(card);
                sum += card.number;
            }

            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        scanner.close();
    }
}
