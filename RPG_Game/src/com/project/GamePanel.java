package com.project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
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
    Character custiom;

    BetterButton betterButton = new BetterButton("Starte Spiel");

    BetterButton2 betterButton2 = new BetterButton2("back startpage");
    BetterButton betterButtonobama= new BetterButton("select Obama");

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("the great adventure");

        Label welcomeLabel = new Label("Welcome to the lightskin adventure pt.5-4= 1");
        welcomeLabel.setFont(new Font(4));
        welcomeLabel.setPadding(new Insets(-40, 0, 0, 0));
        welcomeLabel.setFont(betterButton.getFont());
        welcomeLabel.setStyle("-fx-text-fill: white ");
        /*Button startGameButton = new Button("Start Game");
        Font startGameButtonFont = Font.font("Arial Rounded MT Bold", 20);
        startGameButton.setFont(startGameButtonFont);
*/
        FileInputStream inputDababy = new FileInputStream("src/images/titel.jpg");
        Image imageDababy = new Image(inputDababy);
        ImageView imageViewDababy = new ImageView(imageDababy);
        imageViewDababy.setPreserveRatio(true);
        imageViewDababy.setFitHeight(400);
        imageViewDababy.setFitWidth(500);
        VBox welcomeVbox = new VBox(welcomeLabel, imageViewDababy, betterButton);
        welcomeVbox.setSpacing(20);
        welcomeVbox.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane();

        FileInputStream InputStreamDababy = new FileInputStream("src/images/baby_on_babydababy_cover.jpg");
        Image ImageDababy = new Image(InputStreamDababy);
        BackgroundImage backgroundImageDababy = new BackgroundImage(
                ImageDababy, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundDababy = new Background(backgroundImageDababy);
        pane.setBackground(backgroundDababy);

        GaussianBlur blur = new GaussianBlur(1);
        pane.setEffect(blur);
        System.out.println("\"Hello\"");
        //pane.setStyle("-fx-background-image: url('src/images/baby_on_babydababy_cover.jpg');");


        pane.getChildren().add(welcomeVbox);
        Scene welcomeScene = new Scene(pane, 900, 670);
        primaryStage.setResizable(true);
        primaryStage.setScene(welcomeScene);
        // C H A R A C T E R S

        FileInputStream inputGunner = new FileInputStream("src/images/yakub.jpg");
        FileInputStream inputObama = new FileInputStream("src/images/TransparentPixelObama.png");
        FileInputStream inputMage = new FileInputStream("src/images/luanNEW.jpg");


        Image imageGunner = new Image(inputGunner);
        Image imageObama = new Image(inputObama);
        Image imageMage = new Image(inputMage);


        Character Gunner = new Character("jakub", "src/images/yakub.jpg", "pew pew", false);
        Character Obama = new Character("Obama", "src/images/TransparentPixelObama.png", "black", false);
        Character Mage = new Character("luan", "src/images/luanNEW.jpg", "albania", false);
        Character Knight = new Character("leon machere", "src/images/leon.jpg", "youtube", false);

        olcharacter = FXCollections.observableArrayList(
                Gunner,
                Obama,
                Mage,
                Knight
        );

        // C H O O S E        C H A R A C T E R          S C E N E

        //DEFAULT CODE, BLEIBT FIX
        Label chooseCharacterLabel = new Label("CHOOSE YOUR CHARACTER");
        chooseCharacterLabel.setFont(betterButton.getFont());
        chooseCharacterLabel.setStyle("-fx-text-fill: red;");
        HBox chooseCharacterLabelHbox = new HBox(chooseCharacterLabel);
        chooseCharacterLabelHbox.setAlignment(Pos.TOP_CENTER);
        chooseCharacterLabelHbox.setPadding(new Insets(90, 0, 0, 0));

        ImageView imageViewGunner = new ImageView(imageGunner);
        imageViewGunner.setFitHeight(250);
        imageViewGunner.setFitWidth(180);
        Button buttonGunner = new Button("select jakob");
        buttonGunner.setStyle("-fx-font-size: 27px;-fx-font-family: 'Segoe UI';-fx-background-color: #17147a;-fx-text-fill: white");
        Label labelGunner = new Label("Random student");
        labelGunner.setPadding(new Insets(15, 0, 0, 0));

        VBox GunnerVBox = new VBox(10, imageViewGunner, buttonGunner, labelGunner);
        labelGunner.setFont(betterButton2.getFont());
        labelGunner.setStyle("-fx-font-size: 19px; -fx-text-fill: white");

        ImageView imageViewObama = new ImageView(imageObama);
        imageViewObama.setFitHeight(250);
        imageViewObama.setFitWidth(200);
        Button buttonObama = new Button("select Obama");
        buttonObama.setStyle("-fx-font-size: 25px;-fx-font-family: 'Segoe UI';-fx-background-color: #17147a;-fx-text-fill: white");
        Label labelObama = new Label("Obama");
        labelObama.setPadding(new Insets(15, 0, 0, 0));
        labelObama.setFont(betterButton2.getFont());
        VBox ObamaVBox = new VBox(10, imageViewObama, buttonObama, labelObama);
        labelObama.setStyle("-fx-font-size: 23px; -fx-text-fill: white");


        ImageView imageViewMage = new ImageView(imageMage);
        imageViewMage.setFitHeight(250);
        imageViewMage.setFitWidth(200);
        Button buttonMage = new Button("select luan");
        buttonMage.setStyle("-fx-font-size: 25px;-fx-font-family: 'Segoe UI';-fx-background-color: #17147a;-fx-text-fill: white");
        Label labelMage = new Label("Random albaner");
        labelMage.setPadding(new Insets(15, 0, 0, 0));
        VBox MageVbox = new VBox(10, imageViewMage, buttonMage, labelMage);
        GaussianBlur blurw= new GaussianBlur();
        blurw.setRadius(20);
        labelMage.setFont(betterButton2.getFont());
        labelMage.setStyle("-fx-font-size: 23px; -fx-text-fill: white");

        // BLEIBT FIX DA


        //EIN CHARACTER VON DER OBSERVABLELIST
        FileInputStream inputcustom = new FileInputStream(olcharacter.get(3).getImage());
        Image custom = new Image(inputcustom);
        ImageView imageViewKnight = new ImageView(custom);
        imageViewKnight.setFitHeight(250);
        imageViewKnight.setFitWidth(200);
        Button buttonKnight = new Button("select leon machere");
        buttonKnight.setStyle("-fx-font-size: 26px;-fx-font-family: 'Segoe UI';-fx-background-color: #17147a;-fx-text-fill: white");
        Label labelKnight = new Label("Random youtuber");
        labelKnight.setPadding(new Insets(15, 0, 0, 0));
        VBox KnightVBox = new VBox(10, imageViewKnight, buttonKnight, labelKnight);
        labelKnight.setFont(betterButton2.getFont());
        labelKnight.setStyle("-fx-font-size: 23px; -fx-text-fill: white;");

        //EIN CHARACTER VON DER OBSERVABLELIST


        Button backToStartPageButton = new Button("Back to StartPage");

        HBox backtoStartPageButtonHbox = new HBox(backToStartPageButton);
        backtoStartPageButtonHbox.setPadding(new Insets(480, -30, 0, 0));
        backToStartPageButton.setFont(new Font("Ubuntu", 20));
        backtoStartPageButtonHbox.setAlignment(Pos.CENTER);

        Button addNewCharacter = new Button("Add new Character");
        addNewCharacter.setStyle("-fx-font-family: 'Consolas';-fx-background-color: #78789e");

        Button removeNewCharacter = new Button("Remove new Character");
        removeNewCharacter.setStyle("-fx-font-family: 'Consolas';-fx-background-color: white");

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
        //secondepane.setStyle("-fx-background-color: green");

        chooseCharacterLabelHbox.setLayoutX(400);
        chooseCharacterLabelHbox.setLayoutY(50);
        characterHBox.setLayoutY(250);
        characterHBox.setLayoutX(100);
        removeAdd.setLayoutX(380);
        removeAdd.setLayoutY(20);
        backtoStartPageButtonHbox.setLayoutY(180);
        backtoStartPageButtonHbox.setLayoutX(550);

        FileInputStream InputStreamKumala = new FileInputStream("src/images/wallpaper.jpg");
        Image ImageKumala = new Image(InputStreamKumala);
        BackgroundImage backgroundImageKumala = new BackgroundImage(
                ImageKumala, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background backgroundKumala = new Background(backgroundImageKumala);

        Scene chooseCharacterScene = new Scene(secondepane, 1390, 750);
        secondepane.setBackground(backgroundKumala);

        backToStartPageButton.setOnAction(event -> {
            primaryStage.setScene(welcomeScene);
            primaryStage.centerOnScreen();
        });

        betterButton.setOnAction(event ->
                {
                    primaryStage.setScene(chooseCharacterScene);
                    primaryStage.setX(primaryStage.getX() - 280);
                    primaryStage.setY(primaryStage.getY() - 30);
                }
        );


        Label customLabel = new Label("");
        Button customButton = new Button("");
        customLabel.setFont(new   Font("Arial", 22));
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("DAS IMAGE MUSS KLEINER ALS 100x100px sein! ");
        alert.setTitle("Image zu groß");


        addNewCharacter.setOnAction(event -> {
            customImageFile = fileChooser.showOpenDialog(primaryStage);
            yourimg = new Image(customImageFile.toPath().toString());
            if (yourimg.getHeight() <= 100 || yourimg.getWidth() <= 100) {
                ImageView yourimgview = new ImageView(yourimg);
                customVbox.getChildren().add(yourimgview);
                yourimgview.setFitWidth(200);
                yourimgview.setFitHeight(250);
                yourimgview.setPreserveRatio(false);

                TextField enterNametextField = new TextField();
                Button enterNameButtonSubmit = new Button("Enter Name");

                HBox enternamebox = new HBox(enterNametextField, enterNameButtonSubmit);
                enternamebox.setSpacing(10);
                Scene enterNameScene = new Scene(enternamebox, 300, 300);
                primaryStage.setScene(enterNameScene);

                enterNameButtonSubmit.setOnAction(event1 -> {
                    saveName = enterNametextField.getText();
                    if (saveName.isEmpty() || saveName.equals(" ")) {
                        saveName = "king williams";
                    } else
                        customLabel.setText(saveName);
                    customButton.setText("select " + saveName);
                    customButton.setStyle("-fx-font-size: 26px;-fx-font-family: 'Segoe UI';-fx-background-color: #9f0606;-fx-text-fill: white");
                    primaryStage.setScene(chooseCharacterScene);
                    customVbox.getChildren().addAll(customButton, customLabel);
                    customLabel.setPadding(new Insets(0, 0, 0, 0));

                    customVbox.setSpacing(10);

                });
                custiom = new Character(saveName, yourimg.getUrl(), "lightskin", false);
                characterHBox.getChildren().add(customVbox);

            } else
                alert.show();
            System.err.println("geht nicht ");

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


        customButton.setOnAction(event ->

        {
            this.selectedCharacter = custiom;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();

            }
        });

        buttonObama.setOnAction(event ->

        {
            System.err.println("Obama clicked");
            this.selectedCharacter = Obama;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonGunner.setOnAction(event ->

        {
            System.out.println("Gunner selected");

            this.selectedCharacter = Gunner;
            WorldSelector worldSelector = new WorldSelector();
            try {
                worldSelector.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        buttonMage.setOnAction(event ->

        {
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