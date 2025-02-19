// Med exp 4 
import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String toString() {
        return "Symbol: " + symbol + ", Value: " + value;
    }
}

public class CardCollection {
    static Collection<Card> cards = new ArrayList<>();
    
    static void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }
    
    static void findCardsBySymbol(String symbol) {
        for (Card card : cards) {
            if (card.symbol.equalsIgnoreCase(symbol)) {
                System.out.println(card);
            }
        }
    }
    
    static void displayCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Card\n2. Find Cards by Symbol\n3. Display All Cards\n4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;
            switch (choice) {
                case 1:
                    System.out.println("Enter Symbol and Value:");
                    addCard(sc.next(), sc.next());
                    break;
                case 2:
                    System.out.println("Enter Symbol to find:");
                    findCardsBySymbol(sc.next());
                    break;
                case 3:
                    displayCards();
                    break;
            }
        }
        sc.close();
    }
}
