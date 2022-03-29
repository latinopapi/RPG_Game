package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Characters extends Application {

    private Image characterlevel1;
    private Image characterlevel2;
    private Image characterlevel3;
    private Image characterlevel4;
    private Image characterlevel5;

    private Image characterenemy;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();
    }
}
