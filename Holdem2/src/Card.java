public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit mySuit, Value myValue) {
        suit = mySuit;
        value = myValue;
    }

    public String getPath() {
        return "file:images/" + suit + "/" + value + ".png";
    }

    public String toString() {
        return value + " of " + suit;
    }

}
