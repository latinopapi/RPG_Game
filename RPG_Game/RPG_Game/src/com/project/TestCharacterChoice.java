package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class TestCharacterChoice extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("*game title*");

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
        Label labelSpiderman = new Label("Spiderman");
        labelSpiderman.setPadding(new Insets(15,0,0,0));
        VBox spidermanVbox = new VBox(imageViewSpiderman, labelSpiderman);
        labelSpiderman.setFont(new Font("Arial", 22));

        Image imageLightskin = new Image(inputLightskin);
        ImageView imageViewLightskin = new ImageView(imageLightskin);
        imageViewLightskin.setFitHeight(250);
        imageViewLightskin.setFitWidth(200);
        Label labelLightskin = new Label("random Lightskin");
        labelLightskin.setPadding(new Insets(15,0,0,0));
        VBox LightskinVbox = new VBox(imageViewLightskin, labelLightskin);
        labelLightskin.setFont(new Font("Arial", 22));

        Image imageDeligt = new Image(inputDeligt);
        ImageView imageViewDeligt = new ImageView(imageDeligt);
        imageViewDeligt.setFitHeight(250);
        imageViewDeligt.setFitWidth(200);
        Label labelDeligt = new Label("Matthjis De Ligt");
        labelDeligt.setPadding(new Insets(15,0,0,0));
        VBox DeligtVbox = new VBox(imageViewDeligt, labelDeligt);
        labelDeligt.setFont(new Font("Arial", 22));

        Image imageDybala = new Image(inputDybala);
        ImageView imageViewDybala = new ImageView(imageDybala);
        imageViewDybala.setFitHeight(250);
        imageViewDybala.setFitWidth(200);
        Label labelDybala = new Label("Paulo Dybala");
        Button dybalaButton= new Button("",imageViewDybala);
        labelDybala.setPadding(new Insets(15,0,0,0));
        VBox DybalaVbox = new VBox(dybalaButton, labelDybala);
        labelDybala.setFont(new Font("Arial", 22));

        spidermanVbox.setAlignment(Pos.CENTER);
        DeligtVbox.setAlignment(Pos.CENTER);
        LightskinVbox.setAlignment(Pos.CENTER);
        DybalaVbox.setAlignment(Pos.CENTER);



        HBox characterHBox = new HBox(DeligtVbox, spidermanVbox, DybalaVbox, LightskinVbox);
        characterHBox.setSpacing(20);
        characterHBox.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane(chooseCharacterLabelHbox, characterHBox);
        Scene welcomeScene = new Scene(pane, 1050, 700);
        primaryStage.setResizable(false);
        primaryStage.setScene(welcomeScene);


        primaryStage.show();


    }
}
