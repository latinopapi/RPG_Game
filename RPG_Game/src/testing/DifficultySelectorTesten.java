package testing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class DifficultySelectorTesten extends Application {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 450;
    private AnchorPane mainPane = new AnchorPane();


    @Override
    public void start(Stage stage) throws Exception {

        // BACKGROUND
        FileInputStream backgroundInputStream = new FileInputStream("src/images/background.png");
        Image backgroundImage = new Image(backgroundInputStream);
        BackgroundImage backgroundImage1 = new BackgroundImage(
                backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage1);
        mainPane.setBackground(background);


        // BUTTONS

        BetterButton EasyButton = new BetterButton("Easy");
        EasyButton.setPrefHeight(65);
        EasyButton.setPrefWidth(260);
        EasyButton.setLayoutX(290);
        EasyButton.setLayoutY(35);

        BetterButton AdvancedButton = new BetterButton("Advanced");
        AdvancedButton.setPrefWidth(260);
        AdvancedButton.setPrefHeight(65);
        AdvancedButton.setLayoutX(290);
        AdvancedButton.setLayoutY(185);

        BetterButton HardButton = new BetterButton("Hard");
        HardButton.setPrefWidth(260);
        HardButton.setPrefHeight(65);
        HardButton.setLayoutX(290);
        HardButton.setLayoutY(335);


        mainPane.getChildren().add(EasyButton);
        mainPane.getChildren().add(AdvancedButton);
        mainPane.getChildren().add(HardButton);


        Scene scene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Level Auswahl");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
