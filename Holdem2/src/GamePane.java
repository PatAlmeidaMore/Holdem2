import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class GamePane extends GridPane {

    private static final int NUM_PLAYERS = 6;
    private static final int GAP = 5;

    private PlayerPane[] playerPanes;
    private PotCardsPane potCardsPane;

    public GamePane() {

        setPadding(new Insets(GAP));
        setStyle("-fx-border-color: blue");
        setAlignment(Pos.CENTER);
        setHgap(GAP); setVgap(GAP);

        playerPanes = new PlayerPane[NUM_PLAYERS];
        for (int i=0; i < NUM_PLAYERS; i++) {
            playerPanes[i] = new PlayerPane();
        }
        add(playerPanes[2], 1, 0);
        add(playerPanes[3], 2, 0);
        add(playerPanes[4], 3, 0);
        add(playerPanes[1], 0, 1);
        add(playerPanes[5], 4, 1);
        add(playerPanes[0], 2, 2);

        potCardsPane = new PotCardsPane();
        add(potCardsPane, 1, 1, 3, 1);

    }

    public void changePlayerName(int seatNum, String name) {
        playerPanes[seatNum].changeName(name);
    }

    public void setButton(int buttonIndex) {
        for (int i=0; i < NUM_PLAYERS; i++) {
            playerPanes[i].setButtonVisibility(i == buttonIndex);
        }
    }

    public void updatePlayerChips(int seatNum, int chips) {
        playerPanes[seatNum].updateChipCount(chips);
    }

    public void updatePlayerCurBet(int seatNum, int curBet) {
        playerPanes[seatNum].updateCurBet(curBet);
    }

    // Show back for CPU players
    public void updatePlayerCards(int seatNum, String path1, String path2) {
        playerPanes[seatNum].updateCards(path1, path2);
    }

    public void updatePot(int potValue) {
        potCardsPane.updatePot(potValue);
    }

}
