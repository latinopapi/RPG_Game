package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileInputStream;

public class GamePanel extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("*game title*");


        Label welcomeLabel = new Label("Welcome to *game title*");
        welcomeLabel.setFont(new Font("Ubuntu", 25));

        Button startGameButton = new Button("Start Game");
        Font startGameButtonFont = Font.font("Arial Rounded MT Bold", 20);
        startGameButton.setFont(startGameButtonFont);

        FileInputStream input = new FileInputStream("src/images/baby_on_babydababy_cover.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        VBox welcomeVbox = new VBox(welcomeLabel, imageView, startGameButton);
        welcomeVbox.setSpacing(20);
        welcomeVbox.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane(welcomeVbox);
        Scene welcomeScene = new Scene(pane, 700, 500);
        primaryStage.setResizable(false);
        primaryStage.setScene(welcomeScene);


        FileInputStream inputSpiderman = new FileInputStream("src/images/Spider-Man_(Earth-1048_version).png");
        FileInputStream inputLightskin = new FileInputStream("src/images/lightskin.jpg");
        FileInputStream inputDeligt = new FileInputStream("src/images/deligt.png");
        FileInputStream inputDybala = new FileInputStream("src/images/dybala.png");

        Label chooseCharacterLabel = new Label("CHOOSE YOUR CHARACTER");
        chooseCharacterLabel.setFont(new Font("Montserrat", 35));
        HBox chooseCharacterLabelHbox = new HBox(chooseCharacterLabel);
        chooseCharacterLabelHbox.setAlignment(Pos.TOP_CENTER);
        chooseCharacterLabelHbox.setPadding(new Insets(90, 0, 0, 0));


        Image imageSpiderman = new Image(inputSpiderman);
        ImageView imageViewSpiderman = new ImageView(imageSpiderman);
        imageViewSpiderman.setFitHeight(250);
        imageViewSpiderman.setFitWidth(180);
        Button buttonSpiderman = new Button("", imageViewSpiderman);
        Label labelSpiderman = new Label("Spiderman");
        labelSpiderman.setPadding(new Insets(15, 0, 0, 0));
        VBox spidermanVbox = new VBox(buttonSpiderman, labelSpiderman);
        labelSpiderman.setFont(new Font("Arial", 22));

        Image imageLightskin = new Image(inputLightskin);
        ImageView imageViewLightskin = new ImageView(imageLightskin);
        imageViewLightskin.setFitHeight(250);
        imageViewLightskin.setFitWidth(200);
        Button buttonlightskin = new Button("", imageViewLightskin);
        Label labelLightskin = new Label("random Lightskin");
        labelLightskin.setPadding(new Insets(15, 0, 0, 0));
        VBox LightskinVbox = new VBox(buttonlightskin, labelLightskin);
        labelLightskin.setFont(new Font("Arial", 22));

        Image imageDeligt = new Image(inputDeligt);
        ImageView imageViewDeligt = new ImageView(imageDeligt);
        imageViewDeligt.setFitHeight(250);
        imageViewDeligt.setFitWidth(200);
        Button buttonDeligt = new Button("", imageViewDeligt);
        Label labelDeligt = new Label("Matthjis De Ligt");
        labelDeligt.setPadding(new Insets(15, 0, 0, 0));
        VBox DeligtVbox = new VBox(buttonDeligt, labelDeligt);
        labelDeligt.setFont(new Font("Arial", 22));

        Image imageDybala = new Image(inputDybala);
        ImageView imageViewDybala = new ImageView(imageDybala);
        imageViewDybala.setFitHeight(250);
        imageViewDybala.setFitWidth(200);
        Button buttonDybala = new Button("", imageViewDybala);
        Label labelDybala = new Label("Paulo Dybala");
        labelDybala.setPadding(new Insets(15, 0, 0, 0));
        VBox DybalaVbox = new VBox(buttonDybala, labelDybala);
        labelDybala.setFont(new Font("Arial", 22));

        spidermanVbox.setAlignment(Pos.CENTER);
        DeligtVbox.setAlignment(Pos.CENTER);
        LightskinVbox.setAlignment(Pos.CENTER);
        DybalaVbox.setAlignment(Pos.CENTER);

        Button backToStartPageButton = new Button("Back to StartPage");
        HBox backtoStartPageButtonHbox = new HBox(backToStartPageButton);
        backtoStartPageButtonHbox.setPadding(new Insets(550, 0, 0, 0));
        backToStartPageButton.setFont(new Font("Ubuntu", 20));
        backtoStartPageButtonHbox.setAlignment(Pos.CENTER);

        HBox characterHBox = new HBox(DeligtVbox, spidermanVbox, DybalaVbox, LightskinVbox);
        characterHBox.setSpacing(20);
        characterHBox.setAlignment(Pos.CENTER);
        StackPane secondepane = new StackPane(chooseCharacterLabelHbox, characterHBox, backtoStartPageButtonHbox);
        Scene chooseCharacterScene = new Scene(secondepane, 1050, 700);

        backToStartPageButton.setOnAction(event -> primaryStage.setScene(welcomeScene));
        startGameButton.setOnAction(event -> primaryStage.setScene(chooseCharacterScene));


        primaryStage.show();

    }


}
