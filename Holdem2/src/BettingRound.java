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

public class BettingRound {

    private Hand hand;
    private RoundName roundName;

    public BettingRound(Hand myHand, RoundName myRoundName) {

        hand = myHand;
        roundName = myRoundName;

        if (roundName != RoundName.PREFLOP) {
            hand.resetBets();
        }

        System.out.println("Starting to do stuff with players");

    }

}
