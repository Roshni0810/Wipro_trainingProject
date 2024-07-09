import java.util.*;

class Card {
    private char symbol;
    private int number;

    public Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return symbol == card.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Card> cardSet = new LinkedHashSet<>();
        Set<Character> symbols = new TreeSet<>();

        while (symbols.size() < 4) {
            System.out.println("Enter a card :");
            char symbol = scanner.next().charAt(0);
            int number = scanner.nextInt();

            Card card = new Card(symbol, number);
            if (!symbols.contains(symbol)) {
                cardSet.add(card);
                symbols.add(symbol);
            }
        }

        System.out.println("Four symbols gathered in " + cardSet.size() + " cards.");
        System.out.println("Cards in Set are :");
        for (Card card : cardSet) {
            System.out.println(card);
        }
    }
}
