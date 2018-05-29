import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class ActionsPane extends StackPane {

    private static final int GAP = 5;

    public ActionsPane() {

        setPadding(new Insets(GAP));
        setStyle("-fx-border-color: purple");

        Label titleLabel = new Label("Actions Here");
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        getChildren().add(titleLabel);

    }

}