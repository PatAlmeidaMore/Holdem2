import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class PotCardsPane extends VBox {

    private static final int GAP = 5;
    private static final int CARDS = 5;
    private static final Font FONT = Font.font("Times New Roman", FontWeight.NORMAL, 20);

    private ImageView[] cardViews;
    private Label potNameLabel;
    private ImageView potView;
    private Label potValueLabel;

    public PotCardsPane() {

        super(GAP);
        setPadding(new Insets(GAP));
        setAlignment(Pos.CENTER);

        HBox cards = new HBox(GAP);
        cards.setAlignment(Pos.CENTER);
        cardViews = new ImageView[CARDS];
        for (int i=0; i < cardViews.length; i++) {
            cardViews[i] = new ImageView("file:images/other/transparent.png");
            cardViews[i].setVisible(false);
            cards.getChildren().add(cardViews[i]);
        }
        getChildren().add(cards);

        HBox pot = new HBox(GAP);
        pot.setAlignment(Pos.CENTER);
        potNameLabel = new Label("Pot:");
        potNameLabel.setFont(FONT);
        pot.getChildren().add(potNameLabel);
        potView = new ImageView("file:images/other/chips.png");
        pot.getChildren().add(potView);
        potValueLabel = new Label("");
        potValueLabel.setFont(FONT);
        pot.getChildren().add(potValueLabel);
        getChildren().add(pot);

    }

    public void updatePot(int potValue) {
        potValueLabel.setText(Integer.toString(potValue));
    }

}
