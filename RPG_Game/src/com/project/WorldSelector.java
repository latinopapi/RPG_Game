package com.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

public class WorldSelector extends Application {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 450;
    private AnchorPane mainPane = new AnchorPane();

    public boolean locked;
    private boolean world2unlocked;
    private boolean world3unlocked;


    @Override
    public void start(Stage stage) throws Exception {

        // BACKGROUND
        FileInputStream backgroundInputStream = new FileInputStream("src/images/fortnite.jpg");
        Image backgroundImage = new Image(backgroundInputStream);
        BackgroundImage backgroundImage1 = new BackgroundImage(
                backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage1);
        mainPane.setBackground(background);

        // BUTTONS

        BetterButton World1Button = new BetterButton("World 1");
        World1Button.setPrefHeight(65);
        World1Button.setPrefWidth(260);
        World1Button.setLayoutX(290);
        World1Button.setLayoutY(35);

        BetterButton World2Button = new BetterButton("World 2");
        World2Button.setPrefWidth(260);
        World2Button.setPrefHeight(65);
        World2Button.setLayoutX(290);
        World2Button.setLayoutY(185);

        BetterButton World3Button = new BetterButton("Quiz");
        World3Button.setPrefWidth(260);
        World3Button.setPrefHeight(65);
        World3Button.setLayoutX(290);
        World3Button.setLayoutY(335);

        World1 world1 = new World1();

        World2 world2 = new World2();

        World3 world3 = new World3();


        World1Button.setOnAction(event -> {
            stage.hide();
            AtomicBoolean Story1ButtonClicked= new AtomicBoolean(false);
            Stage story1Stage = new Stage();
            AnchorPane story1Pane = new AnchorPane();
            story1Pane.setStyle("-fx-background-color: #5ec08d");
            Scene story1Scene = new Scene(story1Pane);
            Text text = new Text("There once was a lightskin called Nabil. He really wanted to say the n-word so he asked his black friends if they can give him the n-word pass." + " " +
                    "But his friends said no. So he decided to go on a adventure to find a darkskin who would give him the n-word pass...");
            text.setStyle("-fx-font-family: 'Gill Sans MT';-fx-background-color: white;-fx-font-size: 34px;");
            text.setWrappingWidth(470);
            text.setX(160);
            text.setY(90);

            BetterButton story1Button = new BetterButton("Continue...");
            story1Button.setLayoutY(400);
            story1Button.setLayoutX(230);

            story1Pane.getChildren().add(text);
            story1Pane.getChildren().add(story1Button);

            story1Stage.setWidth(800);
            story1Stage.setHeight(600);
            story1Stage.setResizable(false);

            story1Stage.setScene(story1Scene);
            story1Stage.show();
            story1Button.setOnAction(event1 -> {
                if(Story1ButtonClicked.get()) {
                    try {
                        story1Stage.close();
                        world1.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else text.setText("So his adventure has begun...");
                text.setStyle("-fx-font-family: 'MS Gothic'; -fx-font-size: 40px");
                text.setX(180);
                text.setY(190);
                Story1ButtonClicked.set(true);
                story1Button.setText("Start they journey!");

            });

        });


        World2Button.setOnAction(event -> {
            if (!(world1.isBossDefeated())) {

                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("World 2 not unlocked yet! Defeat the boss in World 1 to unlock World 2!");
                a.show();
            } else {
                try {

                    world2.start(stage);
                    stage.setX(100);
                    stage.setY(10);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        World3Button.setOnAction(event -> {
            if (!(world1.isBossDefeated() && world2.isBossDefeated())) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Quiz not unlocked yet! Defeat the boss in World 1 and complete World 2 to unlock Quiz!");
                a.show();
            } else if(world1.isBossDefeated() && world2.isBossDefeated()) {
                try {
                    world3.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        mainPane.getChildren().add(World1Button);
        mainPane.getChildren().add(World2Button);
        mainPane.getChildren().add(World3Button);


        Scene scene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Level Auswahl");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }
}