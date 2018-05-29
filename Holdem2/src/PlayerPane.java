import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class PlayerPane extends VBox {

    private static final int GAP = 2;
    private static final Font FONT = Font.font("Times New Roman", FontWeight.NORMAL, 20);

    private ImageView buttonView;
    private Label nameLabel;
    private ImageView chipsView;
    private Label chipsLabel;
    private ImageView card1View;
    private ImageView card2View;
    private Label currentBetTitle;
    private ImageView currentBetView;
    private Label currentBetLabel;

    public PlayerPane() {

        super(GAP);
        setPadding(new Insets(GAP));
        setAlignment(Pos.CENTER);

        buttonView = new ImageView("file:images/other/button.png");
        buttonView.setVisible(false);
        nameLabel = new Label("");
        nameLabel.setFont(FONT);
        chipsView = new ImageView("file:images/other/chips.png");
        chipsLabel = new Label("");
        chipsLabel.setFont(FONT);
        card1View = new ImageView("file:images/other/transparent.png");
        card2View = new ImageView("file:images/other/transparent.png");
        currentBetTitle = new Label("Bet:");
        currentBetTitle.setFont(FONT);
        currentBetTitle.setVisible(false);
        currentBetView = new ImageView("file:images/other/chips.png");
        currentBetView.setVisible(false);
        currentBetLabel = new Label("");
        currentBetLabel.setFont(FONT);
        currentBetLabel.setVisible(false);

        HBox chips = new HBox(GAP*2);
        chips.setAlignment(Pos.CENTER);
        chips.getChildren().add(chipsView);
        chips.getChildren().add(chipsLabel);

        HBox cards = new HBox(GAP*2);
        cards.setAlignment(Pos.CENTER);
        cards.getChildren().add(card1View);
        cards.getChildren().add(card2View);

        HBox currentBet = new HBox(GAP*2);
        currentBet.setAlignment(Pos.CENTER);
        currentBet.getChildren().add(currentBetTitle);
        currentBet.getChildren().add(currentBetView);
        currentBet.getChildren().add(currentBetLabel);

        getChildren().add(buttonView);
        getChildren().add(nameLabel);
        getChildren().add(chips);
        getChildren().add(cards);
        getChildren().add(currentBet);

    }

    public void changeName(String name) {
        nameLabel.setText(name);
    }

    public void setButtonVisibility(boolean vis) {
        buttonView.setVisible(vis);
    }

    public void updateChipCount(int chipCount) {
        chipsLabel.setText(Integer.toString(chipCount));
    }

    public void updateCurBet(int curBet) {
        if (curBet == 0) {
            currentBetTitle.setVisible(false);
            currentBetView.setVisible(false);
            currentBetLabel.setText("");
            currentBetLabel.setVisible(false);
        } else {
            currentBetTitle.setVisible(true);
            currentBetView.setVisible(true);
            currentBetLabel.setText(Integer.toString(curBet));
            currentBetLabel.setVisible(true);
        }
    }

    public void updateCards(String path1, String path2) {
        card1View.setImage(new Image(path1));
        card2View.setImage(new Image(path2));
    }

}
