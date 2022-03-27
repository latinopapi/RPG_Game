package com.project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileInputStream;

public class GamePanel extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("*game title*");


        Label welcomeLabel = new Label("Welcome to *game title*");
        welcomeLabel.setFont(new Font("Ubuntu",25));

        Button startGameButton= new Button("Start Game");
        Font startGameButtonFont = Font.font("Arial Rounded MT Bold", 20);
        startGameButton.setFont(startGameButtonFont);

        FileInputStream input = new FileInputStream("src/images/baby_on_babydababy_cover.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        VBox welcomeVbox= new VBox(welcomeLabel,imageView,startGameButton);
        welcomeVbox.setSpacing(20);
        welcomeVbox.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane(welcomeVbox);
        Scene welcomeScene = new Scene(pane, 700, 500);
        primaryStage.setResizable(false);
        primaryStage.setScene(welcomeScene);


        Label scene2Label= new Label("Yeah Yeah");
        scene2Label.setFont(new Font("Chiller",35));
        Button backToStartPageButton= new Button("Back to StartPage");
        VBox scene2vbox= new VBox(scene2Label,backToStartPageButton);
        scene2vbox.setAlignment(Pos.CENTER);
        scene2vbox.setSpacing(30);
        StackPane scene2Pane = new StackPane(scene2vbox);
        Scene scene2 = new Scene(scene2Pane,1050,750);
        backToStartPageButton.setOnAction(event -> primaryStage.setScene(welcomeScene));
        startGameButton.setOnAction(event -> primaryStage.setScene(scene2));


        primaryStage.show();

    }


}
