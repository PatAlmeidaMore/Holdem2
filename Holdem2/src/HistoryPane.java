import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class HistoryPane extends StackPane {

    private static final int GAP = 5;

    public HistoryPane() {

        setPadding(new Insets(GAP));
        setStyle("-fx-border-color: green");

        Label titleLabel = new Label("Hand History Here");
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        getChildren().add(titleLabel);

    }

}