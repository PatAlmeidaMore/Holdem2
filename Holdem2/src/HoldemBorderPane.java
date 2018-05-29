import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HoldemBorderPane extends BorderPane {

    public HoldemBorderPane() {

        setTop(new TitlePane());
        setLeft(new HistoryPane());
        setCenter(new GamePane());
        setRight(new SomethingPane());
        setBottom(new ActionsPane());

    }

    public void changePlayerName(int seatNum, String name) {
        GamePane gamePane = (GamePane) getCenter();
        gamePane.changePlayerName(seatNum, name);
    }

    public void setButton(int buttonIndex) {
        GamePane gamePane = (GamePane) getCenter();
        gamePane.setButton(buttonIndex);
    }

    public void updatePlayerChips(int seatNum, int chips) {
        GamePane gamePane = (GamePane) getCenter();
        gamePane.updatePlayerChips(seatNum, chips);
    }

    public void updatePlayerCurBet(int seatNum, int curBet) {
        GamePane gamePane = (GamePane) getCenter();
        gamePane.updatePlayerCurBet(seatNum, curBet);
    }

    // Show back for CPU players
    public void updatePlayerCards(int seatNum, String path1, String path2) {
        GamePane gamePane = (GamePane) getCenter();
        gamePane.updatePlayerCards(seatNum, path1, path2);
    }

    public void updatePot(int potValue) {
        GamePane gamePane = (GamePane) getCenter();
        gamePane.updatePot(potValue);
    }

}
