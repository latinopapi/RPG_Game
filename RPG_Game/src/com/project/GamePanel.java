package com.project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class GamePanel extends Application {

    private ObservableList<Character> olcharacter;
    private static final String DEFAULT_CHARACTER_IMAGE = "src/images/custom.png";
    private Image imgCustomCharacter;
    private ImageView iviewCustomCharacter;
    private String saveName = " ";
    public static Character selectedCharacter;
    Image yourimg;
    File customImageFile;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("the great adventure");

        Label welcomeLabel = new Label("Welcome to the game adventure");
        welcomeLabel.setFont(new Font(20));

        Button startGameButton = new Button("Start Game");
        Font startGameButtonFont = Font.font("Arial Rounded MT Bold", 20);
        startGameButton.setFont(startGameButtonFont);

        FileInputStream inputDababy = new FileInputStream("src/images/titel.jpg");
        Image imageDababy = new Image(inputDababy);
        ImageView imageViewDababy = new ImageView(imageDababy);
        imageViewDababy.setPreserveRatio(true);
        imageViewDababy.setFitHeight(400);
        imageViewDababy.setFitWidth(500);
        VBox welcomeVbox = new VBox(welcomeLabel, imageViewDababy, startGameButton);
        welcomeVbox.setSpacing(20);
        welcomeVbox.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane(welcomeVbox);
        Scene welcomeScene = new Scene(pane, 600, 600);
        primaryStage.setResizable(true);
        primaryStage.setScene(welcomeScene);


        // C H A R A C T E R S

        FileInputStream inputGunner = new FileInputStream("src/images/TransparentPixelGunner.png");
        FileInputStream inputObama = new FileInputStream("src/images/TransparentPixelObama.png");
        FileInputStream inputMage = new FileInputStream("src/images/TransparentPixelWizard.png");


        Image imageGunner = new Image(inputGunner);
        Image imageObama = new Image(inputObama);
        Image imageMage = new Image(inputMage);


        Character Gunner = new Character("Gunner", "src/images/TransparentPixelGunner.png", "pew pew", false);
        Character Obama = new Character("Obama", "src/images/TransparentPixelObama.png", "black", false);
        Character Mage = new Character("Mage", "src/images/TransparentPixelWizard.png", "magic", false);
        Character Knight = new Character("Knight", "src/images/TransparentPixelKnight.png", "schwerter und so", false);

        olcharacter = FXCollections.observableArrayList(
                Gunner,
                Obama,
                Mage,
                Knight
        );

        FileInputStream inputCharacterImg = new FileInputStream(DEFAULT_CHARACTER_IMAGE);
        imgCustomCharacter = new Image(inputCharacterImg);
        iviewCustomCharacter = new ImageView(imgCustomCharacter);
        iviewCustomCharacter.setFitHeight(400);
        iviewCustomCharacter.setPreserveRatio(true);

        // C H O O S E        C H A R A C T E R          S C E N E


        //DEFAULT CODE, BLEIBT FIX
        Label chooseCharacterLabel = new Label("CHOOSE YOUR CHARACTER");
        chooseCharacterLabel.setFont(new Font("Montserrat", 35));
        HBox chooseCharacterLabelHbox = new HBox(chooseCharacterLabel);
        chooseCharacterLabelHbox.setAlignment(Pos.TOP_CENTER);
        chooseCharacterLabelHbox.setPadding(new Insets(90, 0, 0, 0));

        ImageView imageViewGunner = new ImageView(imageGunner);
        imageViewGunner.setFitHeight(250);
        imageViewGunner.setFitWidth(180);
        Button buttonGunner = new Button("select gunner");
        Label labelGunner = new Label("Random american student");
        labelGunner.setPadding(new Insets(15, 0, 0, 0));
        VBox GunnerVBox = new VBox(10, imageViewGunner, buttonGunner, labelGunner);
        labelGunner.setFont(new Font("Arial", 22));

        ImageView imageViewObama = new ImageView(imageObama);
        imageViewObama.setFitHeight(250);
        imageViewObama.setFitWidth(200);
        Button buttonObama = new Button("select Obama");
        Label labelObama = new Label("Obama");
        labelObama.setPadding(new Insets(15, 0, 0, 0));
        VBox ObamaVBox = new VBox(10, imageViewObama, buttonObama, labelObama);
        labelObama.setFont(new Font("Arial", 22));

        ImageView imageViewMage = new ImageView(imageMage);
        imageViewMage.setFitHeight(250);
        imageViewMage.setFitWidth(200);
        Button buttonMage = new Button("select mage");
        Label labelMage = new Label("Random Mage");
        labelMage.setPadding(new Insets(15, 0, 0, 0));
        VBox MageVbox = new VBox(10, imageViewMage, buttonMage, labelMage);
        labelMage.setFont(new Font("Arial", 22));
        // BLEIBT FIX DA


        //EIN CHARACTER VON DER OBSERVABLELIST
        FileInputStream inputcustom = new FileInputStream(olcharacter.get(3).getImage());
        Image custom = new Image(inputcustom);
        ImageView imageViewKnight = new ImageView(custom);
        imageViewKnight.setFitHeight(250);
        imageViewKnight.setFitWidth(200);
        Button buttonKnight = new Button("select knight");
        Label labelKnight = new Label("Random knight");
        labelKnight.setPadding(new Insets(15, 0, 0, 0));
        VBox KnightVBox = new VBox(10, imageViewKnight, buttonKnight, labelKnight);
        labelKnight.setFont(new Font("Arial", 22));
        //EIN CHARACTER VON DER OBSERVABLELIST


        Button backToStartPageButton = new Button("Back to StartPage");
        HBox backtoStartPageButtonHbox = new HBox(backToStartPageButton);
        backtoStartPageButtonHbox.setPadding(new Insets(500, 0, 0, 0));
        backToStartPageButton.setFont(new Font("Ubuntu", 20));
        backtoStartPageButtonHbox.setAlignment(Pos.CENTER);

        Button addNewCharacter = new Button("Add new Character");
        Button removeNewCharacter = new Button("Remove new Character");
        addNewCharacter.setFont(new Font("Arial", 20));
        removeNewCharacter.setFont(new Font("Arial", 20));
        HBox removeAdd = new HBox(addNewCharacter, removeNewCharacter);
        removeAdd.setPadding(new Insets(20, 0, 0, 0));
        removeAdd.setSpacing(5);
        FileChooser fileChooser = new FileChooser();

        HBox characterHBox = new HBox(MageVbox, GunnerVBox, KnightVBox, ObamaVBox);
        VBox customVbox = new VBox();

        characterHBox.setSpacing(20);
        characterHBox.setAlignment(Pos.CENTER);
        HBox mainHBox = new HBox(chooseCharacterLabelHbox, characterHBox, backtoStartPageButtonHbox, removeAdd);
        AnchorPane secondepane = new AnchorPane(chooseCharacterLabelHbox, mainHBox, characterHBox, backtoStartPageButtonHbox, removeAdd);


        chooseCharacterLabelHbox.setLayoutX(400);
        chooseCharacterLabelHbox.setLayoutY(50);
        characterHBox.setLayoutY(250);
        characterHBox.setLayoutX(100);
        removeAdd.setLayoutX(380);
        removeAdd.setLayoutY(20);
        backtoStartPageButtonHbox.setLayoutY(150);
        backtoStartPageButtonHbox.setLayoutX(550);

        Scene chooseCharacterScene = new Scene(secondepane, 1300, 750, Color.GREEN);

        backToStartPageButton.setOnAction(event -> {
            primaryStage.setScene(welcomeScene);
            primaryStage.centerOnScreen();
        });

        startGameButton.setOnAction(event -> {
                    primaryStage.setScene(chooseCharacterScene);
                    primaryStage.setX(primaryStage.getX() - 200);
                }
        );


        Label customLabel = new Label("");
        Button customButton = new Button("");
        customLabel.setFont(new Font("Arial", 22));

        addNewCharacter.setOnAction(event -> {
            customImageFile = fileChooser.showOpenDialog(primaryStage);
            yourimg = new Image(customImageFile.toPath().toString());
            if (yourimg.getHeight() > 300 || yourimg.getWidth() > 300) {
                Alert alter= new Alert(Alert.AlertType.ERROR);
                alter.show();
                System.err.println("geht nicht ");
            }
            ImageView yourimgview = new ImageView(yourimg);
            customVbox.getChildren().add(yourimgview);
            yourimgview.setFitWidth(200);
            yourimgview.setFitHeight(250);
            yourimgview.setPreserveRatio(false);

            TextField enterNametextField = new TextField();
            enterNametextField.setPadding(new Insets(0, 0, 0, 0));
            Button enterNameButtonSubmit = new Button("Enter Name");
            //StackPane enternamepane = new StackPane(enterNametextField, enterNameButtonSubmit);
            HBox enternamebox = new HBox(enterNametextField, enterNameButtonSubmit);
            enternamebox.setSpacing(10);
            //VBox submitvbox = new VBox(enterNametextField, enterNameButtonSubmit);
            Scene enterNameScene = new Scene(enternamebox, 300, 300);
            primaryStage.setScene(enterNameScene);

            enterNameButtonSubmit.setOnAction(event1 -> {
                saveName = enterNametextField.getText();
                if (saveName.isEmpty() || saveName.equals(" ") || saveName.equals("")) {
                    saveName = "king williams";
                } else
                    customLabel.setText(saveName);
                customButton.setText("select " + saveName);
                primaryStage.setScene(chooseCharacterScene);
                customVbox.getChildren().addAll(customButton, customLabel);
                customLabel.setPadding(new Insets(0, 0, 0, 0));
                customVbox.setSpacing(10);

            });

            characterHBox.getChildren().add(customVbox);

        });

        buttonKnight.setOnAction(event -> {
            System.out.println("Knight selected");

            this.selectedCharacter = Knight;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        customButton.setOnAction(event -> {
            //this.selectedCharacter = new Character(saveName, customImageFile.toString(), "faehigkeit", false);
            Image imagecustom = new Image(customImageFile.toURI().toString(), 100, 150, true, false);
            this.selectedCharacter = new Character(saveName, customImageFile.toURI().toString(), "faehigkeit", false);
            if (imagecustom.getWidth() > 250 || imagecustom.getHeight() > 200) {
                System.err.println("geht nicht, foto zu groß");
            } else {
                WorldSelector worldSelector = new WorldSelector();
                try {
                    worldSelector.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonObama.setOnAction(event -> {
            System.err.println("Obama clicked");
            this.selectedCharacter = Obama;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonGunner.setOnAction(event -> {
            System.out.println("Gunner selected");

            this.selectedCharacter = Gunner;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        buttonMage.setOnAction(event -> {
            System.out.println("Mage selected");

            this.selectedCharacter = Mage;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        removeNewCharacter.setOnAction(event -> {
            characterHBox.getChildren().remove(customVbox);
            this.selectedCharacter = null;
        });

        primaryStage.show();


    }

}