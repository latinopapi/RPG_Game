package testing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StagesTesten extends Application {

    private Stage secondaryStage;
    private Scene mainScene;
    private Scene secondaryScene;
    private Button button1;
    private Button button2;
    private AnchorPane pane1;
    private AnchorPane pane2;
    private int x=10;

        @Override
    public void start(Stage primaryStage) throws Exception {
        button1 = new Button("x=" + x);
            TextField text = new TextField("Was hier steht sollte bleiben");
            text.setLayoutY(100);
            text.setLayoutX(100);
        pane1 = new AnchorPane();
        pane1.getChildren().add(button1);
        pane1.getChildren().add(text);
        mainScene = new Scene(pane1, 800, 600);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        button1.setOnAction(event -> {
            this.x=20;

            primaryStage.hide();
            button2 = new Button("x=" + x + "x should be 20 in both buttons");
            pane2 = new AnchorPane();
            pane2.getChildren().add(button2);
            secondaryScene = new Scene(pane2, 700, 500);
            secondaryStage = new Stage();
            secondaryStage.setScene(secondaryScene);
            secondaryStage.show();

            button2.setOnAction(event2 -> {
                secondaryStage.hide();
                primaryStage.show();
            });

        });

    }
}
