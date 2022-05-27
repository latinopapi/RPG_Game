package testing;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ScenesTesten extends Application {
    private Stage secondaryStage;
    private Scene secondaryScene;
    private int x;

    @Override
    public void start(Stage primaryStage) throws Exception {
        x = 10;
        Button textField = new Button(" " + x);
        Button secondarySceneButton = new Button("Return to Scene 1, x should be 20");
        secondarySceneButton.setId("title");

        Font dfont = Font.loadFont("C:\\Users\\nabil\\OneDrive\\RPG_GAME\\RPG_GAME_2022-05-17\\src\\ressources\\fortnite.otf", 10);
        textField.setFont(dfont);
        AnchorPane secondaryPane = new AnchorPane();
        secondaryPane.getChildren().add(secondarySceneButton);
        secondaryScene = new Scene(secondaryPane, 600, 400);

        //secondaryScene.getStylesheets().add(getClass().getResource("backgroundTEST.css").toExternalForm());

        AnchorPane mainPane = new AnchorPane();
        mainPane.getChildren().add(textField);
        Scene mainScene = new Scene(mainPane, 800, 600);
        textField.setOnAction(event -> {
            x = 20;
            System.out.println("Betätigt" + x);
            primaryStage.setScene(secondaryScene);

        });
        secondarySceneButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        primaryStage.setScene(mainScene);
        primaryStage.show();

    } // START END


}
