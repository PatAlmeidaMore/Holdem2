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

public class Hand {

    private static final int NUM_ROUNDS = 4;

    private Game game;
    private int pot;
    private BettingRound[] rounds;

    // See ThingsToDo.txt
    public Hand(Game myGame) {

        game = myGame;

        pot = 0;
        game.incButton();
        pot += game.chargeAntes();
        game.updatePot(pot);
        pot += game.chargeBlinds();
        game.updatePot(pot);
        game.shuffleDeck();
        game.dealCards();

        rounds = new BettingRound[NUM_ROUNDS];
        rounds[0] = new BettingRound(this, RoundName.PREFLOP);

    }

    public void resetBets() {
        game.resetBets();
    }

}
