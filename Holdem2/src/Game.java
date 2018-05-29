/*
 * THINGS TO DO BEFORE GAME STARTS:
 *  - Initialize players
 *  - Initialize deck
 *  - Initialize button/blinds
 *
 * STEPS IN EACH HAND:
 *  - Getting Started:
 *    - Advance Button
 *    - Reset Pot
 *    - Ante
 *    - Blinds
 *    - Shuffle
 *    - Deal
 *  - Betting Rounds:
 *    - Preflop -> Flop -> Turn -> River
 *    - If Postflop, set current bets to 0
 *    - Player Actions:
 *      - Preflop: Start from left of Big Blind
 *      - Postflop: Start from left of Button
 *      - If only one player remains: Jump to Payout Winner
 *      - If bet < maxBet: Call, Raise, or Fold
 *      - If bet = maxBet: Check or Bet (Raise)
 *      - Continue if all players acted and have maxBet (Could be 0)
 *    - Showdown if River ended with players remaining
 *  - Payout Winner:
 *    - If only one player remains: Award them Pot
 *    - If multiple players remain: Use Hand Rankings to Award Pot
 */

import java.util.ArrayList;

public class Game {

    public static final int NUM_PLAYERS = 6;
    public static final int BIG_BLIND = 100;
    public static final int SMALL_BLIND = 50;
    public static final int ANTE = 10;

    private HoldemWindow window;
    private Player[] players;
    private Deck deck;
    private int buttonIndex;

    public Game(HoldemWindow myWindow) {
        window = myWindow;
        startGame();
        Hand hand = new Hand(this);
    }

    private void startGame() {

        players = new Player[NUM_PLAYERS];
        players[0] = new Player("Pat");
        players[1] = new Player("John");
        players[2] = new Player("BJ");
        players[3] = new Player("Jackie");
        players[4] = new Player("Andrew");
        players[5] = new Player("Sara");
        for (int i=0; i < players.length; i++) {
            window.changePlayerName(i, players[i].getName());
        }

        deck = new Deck();

        // Makes the Player act first Preflop after advance
        buttonIndex = 2;

    }

    public void incButton() {
        buttonIndex = (buttonIndex + 1) % NUM_PLAYERS;
        window.setButton(buttonIndex);
    }

    // See ThingsToDo.txt
    public int chargeAntes() {
        int totalPaid = 0;
        for (int i=0; i < players.length; i++) {
            players[i].payAnte(ANTE);
            totalPaid += ANTE;
            window.updatePlayerChips(i, players[i].getChips());
        }
        return totalPaid;
    }

    // See ThingsToDo.txt
    public int chargeBlinds() {

        int sbIndex = (buttonIndex + 1) % NUM_PLAYERS;
        int bbIndex = (buttonIndex + 2) % NUM_PLAYERS;

        players[bbIndex].payBlind(BIG_BLIND);
        window.updatePlayerChips(bbIndex, players[bbIndex].getChips());
        window.updatePlayerCurBet(bbIndex, players[bbIndex].getCurrentBet());
        players[sbIndex].payBlind(SMALL_BLIND);
        window.updatePlayerChips(sbIndex, players[sbIndex].getChips());
        window.updatePlayerCurBet(sbIndex, players[sbIndex].getCurrentBet());

        return BIG_BLIND + SMALL_BLIND;

    }

    public void resetBets() {
        for (int i=0; i < NUM_PLAYERS; i++) {
            players[i].resetCurrentBet();
            window.updatePlayerCurBet(i, players[i].getCurrentBet());
        }
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void dealCards() {
        for (int i=0; i < NUM_PLAYERS; i++) {
            Card card1 = deck.dealCard();
            Card card2 = deck.dealCard();
            players[i].setNewCards(card1, card2);
            window.updatePlayerCards(i, card1.getPath(), card2.getPath());
        }
    }

    public void updatePot(int potValue) {
        window.updatePot(potValue);
    }

}
