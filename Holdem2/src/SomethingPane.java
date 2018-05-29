import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class SomethingPane extends StackPane {

    private static final int GAP = 5;

    public SomethingPane() {

        setPadding(new Insets(GAP));
        setStyle("-fx-border-color: yellow");

        Label titleLabel = new Label("Something Here");
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        getChildren().add(titleLabel);

    }

}