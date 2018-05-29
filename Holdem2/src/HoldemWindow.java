import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HoldemWindow {

    // Maybe don't need to make 'root' and 'stage' fields
    private StackPane root;
    private HoldemBorderPane pane;
    private Stage stage;

    public HoldemWindow(Stage myStage) {

        root = new StackPane();
        pane = new HoldemBorderPane();
        root.getChildren().add(pane);

        stage = myStage;
        stage.setTitle("NL Holdem");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void changePlayerName(int seatNum, String name) {
        pane.changePlayerName(seatNum, name);
    }

    public void setButton(int buttonIndex) {
        pane.setButton(buttonIndex);
    }

    public void updatePlayerChips(int seatNum, int chips) {
        pane.updatePlayerChips(seatNum, chips);
    }

    public void updatePlayerCurBet(int seatNum, int curBet) {
        pane.updatePlayerCurBet(seatNum, curBet);
    }

    // Show back for CPU players
    public void updatePlayerCards(int seatNum, String path1, String path2) {
        pane.updatePlayerCards(seatNum, path1, path2);
    }

    public void updatePot(int potValue) {
        pane.updatePot(potValue);
    }

}
