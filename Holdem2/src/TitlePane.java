import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class TitlePane extends StackPane {

    private static final int GAP = 5;

    public TitlePane() {

        setPadding(new Insets(GAP));
        setStyle("-fx-border-color: red");

        Label titleLabel = new Label("50/100 Ante 10 - NL Holdem");
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        getChildren().add(titleLabel);

    }

}
