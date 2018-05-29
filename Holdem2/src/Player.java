public class Player {

    private String name;
    private int chips;
    private Card card1, card2;
    private boolean hasButton;
    private int currentBet;

    public Player(String myName) {
        name = myName;
        chips = 10000;
        card1 = null;
        card2 = null;
        hasButton = false;
        currentBet = 0;
    }

    public String getName() { return name; }
    public int getChips() { return chips; }
    public int getCurrentBet() { return currentBet; }

    public void payAnte(int ante) {
        chips -= ante;
    }

    public void resetCurrentBet() {
        currentBet = 0;
    }

    public void payBlind(int blind) {
        chips -= blind;
        currentBet += blind;
    }

    public void setNewCards(Card myCard1, Card myCard2) {
        card1 = myCard1;
        card2 = myCard2;
    }

}
