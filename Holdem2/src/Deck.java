public class Deck {

    private static final int NUM_CARDS = 52;
    private static final int NUM_SUITS = 4;
    private static final int NUM_VALUES = 13;

    private int topIndex;
    private Card[] cards;

    public Deck() {

        topIndex = 0;

        cards = new Card[NUM_CARDS];
        Suit suit = null;
        Value value = null;
        for (int i=0; i < NUM_SUITS; i++) {

            switch (i) {
                case 0: suit = Suit.CLUBS; break;
                case 1: suit = Suit.DIAMONDS; break;
                case 2: suit = Suit.HEARTS; break;
                case 3: suit = Suit.SPADES; break;
            }

            for (int j=0; j < NUM_VALUES; j++) {
                switch (j) {
                    case 0: value = Value.TWO; break;
                    case 1: value = Value.THREE; break;
                    case 2: value = Value.FOUR; break;
                    case 3: value = Value.FIVE; break;
                    case 4: value = Value.SIX; break;
                    case 5: value = Value.SEVEN; break;
                    case 6: value = Value.EIGHT; break;
                    case 7: value = Value.NINE; break;
                    case 8: value = Value.TEN; break;
                    case 9: value = Value.JACK; break;
                    case 10: value = Value.QUEEN; break;
                    case 11: value = Value.KING; break;
                    case 12: value = Value.ACE; break;
                }
                cards[i*NUM_VALUES + j] = new Card(suit, value);
            }

        }

    }

    public Card dealCard() {
        topIndex++;
        return cards[topIndex - 1];
    }

    public void shuffle() {

        topIndex = 0;

        int[] nums = new int[NUM_CARDS];
        for (int i=0; i < nums.length; i++) {
            nums[i] = i;
        }

        Card[] newCards = new Card[NUM_CARDS];
        for (int i=0; i < newCards.length; i++) {
            int cardsRemaining = NUM_CARDS - i;
            int rand = (int) (Math.random() * cardsRemaining);
            newCards[i] = cards[nums[rand]];
            nums[rand] = nums[cardsRemaining - 1];
        }
        cards = newCards;

    }

}
