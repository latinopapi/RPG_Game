package com.project;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static com.project.GamePanel.selectedCharacter;

public class World1 extends Application {

    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;
    private static final String GunnerRightUrl = "src/images/TransparentPixelGunner.png";
    private static final String GunnerLeftUrl = "src/images/TransparentPixelGunner_LEFT.png";
    private static final String WizardLeftUrl = "src/images/TransparentPixelWizard.png";
    private static final String WizardRightUrl = "src/images/TransparentPixelWizard_LEFT.png";
    private static final String KnightRightUrl = "src/images/TransparentPixelKnight.png";
    private static final String KnightLeftUrl = "src/images/TransparentPixelKnight_LEFT.png";
    private static final String ObamaRightUrl = "src/images/TransparentPixelObama.png";
    private static final String ObamaLeftUrl = "src/images/TransparentPixelObama_LEFT.png";


    private static boolean BossDefeated = false;

    private boolean gameStarted = false;
    private long frameCount;
    private Sprite backButtonSprite;
    private Sprite hero;
    private Sprite monster1;
    private Sprite monster2;
    private Sprite boss;
    private Sprite backgroundSprite;
    private Sprite shopKeeper;

    private Sprite shoplabel;
    private Sprite bosslabel;
    private Sprite monsterlabel;
    private Sprite mosterLabel2;


    // Monster 1 Nodes
    private Scene monster1Scene;
    private Stage monster1Stage;
    private AnchorPane monster1Pane;
    private Button monster1BackButton;
    private short monster1Health;
    private boolean monster1SpecialAttackUsed = false;


    // Monster 2 Nodes
    private Scene monster2Scene;
    private Stage monster2Stage;
    private AnchorPane monster2Pane;
    private Button monster2BackButton;
    private short monster2Health;
    private boolean monster2SpecialAttackUsed = false;

    // Boss Nodes
    private Scene bossScene;
    private Stage bossStage;
    private AnchorPane bossPane;
    private Button bossBackButton;
    private short bossHealth;
    private boolean bossSpecialAttackUsed = false;


    //Shop Nodes
    private Scene shopScene;
    private Stage shopStage;
    private AnchorPane shopPane;

    private int attackDamage = 1;
    private int specialAttackDamage = 5;
    private long earnedCoins = 1;
    private long coins = 0;
    private int maxMana = 100;
    private int RollPrice = 2;
    private int currentMana;

    private int heroSpeed = 7;

    private String selectedCharacterImageURL = selectedCharacter.getImage();

    private Timeline timeline;
    private Label timerLabel = new Label();
    private DoubleProperty timeSeconds = new SimpleDoubleProperty();

    private Duration time = Duration.ZERO, splitTime = Duration.ZERO;
    private int i = 0;
    ArrayList<Node> imgviewjumpscares;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane pane = new StackPane();
        pane.getChildren().add(canvas);

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("World 1");
        primaryStage.show();

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1), e -> run(gc)));
        tl.setCycleCount(Animation.INDEFINITE);

        double random;
        double formattedrandom;
        ArrayList<Double> randomNumbers = new ArrayList<>();

        for (int n = 0; n <= 40; n++) {
            double i = 0.05 * n;
            double x = round(i, 2);
            randomNumbers.add(x);
            System.out.println(randomNumbers.get(n));
        }


//        randomNumbers.add(0.04);
//        randomNumbers.add(0.1);
//        randomNumbers.add(0.13);
//        randomNumbers.add(0.18);
//        randomNumbers.add(0.22);
//        randomNumbers.add(0.25);
//        randomNumbers.add(0.28);
//        randomNumbers.add(0.32);
//        randomNumbers.add(0.35);
//        randomNumbers.add(0.39);
//        randomNumbers.add(0.45);
//        randomNumbers.add(0.54);
//        randomNumbers.add(0.58);
//        randomNumbers.add(0.63);
//        randomNumbers.add(0.65);
//        randomNumbers.add(0.7);
//        randomNumbers.add(0.75);
//        randomNumbers.add(0.83);
//        randomNumbers.add(0.9);
//        randomNumbers.add(0.95);


        Collections.sort(randomNumbers);
        for (Double d : randomNumbers) {
            System.out.println(d);
        }

        System.out.println("ENDE ARRAYLIST RANDOM NUMBERS");
        Image myimglightskin = new Image("images/lightskin.jpg");
        ImageView myimgviewlightskin = new ImageView(myimglightskin);

        Image imageducahn = new Image("images/ducahn.jpg");
        ImageView imgviewducahn = new ImageView(imageducahn);


        Image myimgtravis = new Image("images/jumpscare5#.jpg");
        ImageView myimgviewtravis = new ImageView(myimgtravis);
        Image batman = new Image("images/jumpscares4.jpg");
        ImageView myimgviewbatman = new ImageView(batman);
        Image imageducahn2 = new Image("images/ducahn.jpg");
        ImageView imgviewducahn2 = new ImageView(imageducahn2);
        Image myimgjumpscare1 = new Image("images/jumpscares1.jpg");
        ImageView myimgviewjumpscare1 = new ImageView(myimgjumpscare1);
        Image myimgjumpscare2 = new Image("images/jumpscares2.jpg");
        ImageView myimgviewjumpscare2 = new ImageView(myimgjumpscare2);
        imgviewjumpscares = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            imgviewjumpscares.add(myimgviewjumpscare1);
            imgviewjumpscares.add(imgviewducahn);
            imgviewjumpscares.add(myimgviewlightskin);
            imgviewjumpscares.add(myimgviewtravis);
            imgviewjumpscares.add(imgviewducahn2);
            imgviewjumpscares.add(myimgviewjumpscare2);
            imgviewjumpscares.add(myimgviewbatman);
        }

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameStarted = !gameStarted;
                if (gameStarted) {
                    frameCount = 0;
                }
                if (event.getSceneX() <= 100 && event.getSceneY() <= 29) {
                    primaryStage.close();
                    timeline.stop();
                    WorldSelector worldSelector = new WorldSelector();
                    try {

                        worldSelector.start(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        try {
            primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
                if (gameStarted) {
                    if (event.getCode() == KeyCode.P) {
                        coins += 999999;
                    }
                    if (event.getCode() == KeyCode.R) {
                        primaryStage.setX(450);
                        primaryStage.setY(50);
                    }

                    if (timeline != null) {
                    } else {
                        timeline = new Timeline(
                                new KeyFrame(Duration.millis(100),
                                        t -> {
                                            Duration duration = new Duration(1);
                                            time = time.add(duration);
                                            timeSeconds.set(time.toSeconds());
                                            System.out.println(timeSeconds.getValue());
                                            if (randomNumbers.get(i).equals(timeSeconds.getValue())) {
                                                System.out.println("JUMPSCARE" + i);
                                                pane.getChildren().add(imgviewjumpscares.get(i));
                                                primaryStage.setX(primaryStage.getX() + 100);
                                                primaryStage.setY(primaryStage.getY() + 100);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.001)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() - 100);
                                                primaryStage.setY(primaryStage.getY() - 00);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.002)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() + 100);
                                                primaryStage.setY(primaryStage.getY() + 00);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.003)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() - 100);
                                                primaryStage.setY(primaryStage.getY() - 00);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.004)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() + 100);
                                                primaryStage.setY(primaryStage.getY() + 00);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.005)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() - 100);
                                                primaryStage.setY(primaryStage.getY() - 100);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.006)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() + 100);
                                                primaryStage.setY(primaryStage.getY() + 100);
                                            }
                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.007)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() - 100);
                                                primaryStage.setY(primaryStage.getY() - 00);
                                            }

                                            if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.009)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                primaryStage.setX(primaryStage.getX() - 100);
                                                primaryStage.setY(primaryStage.getY() - 100);
                                            }
                                            if (timeSeconds.getValue() > (randomNumbers.get(i) + 0.01)) {  //die differenz zwischen den random numbers muss größer als 0.02 sein!
                                                pane.getChildren().remove(imgviewjumpscares.get(i));
                                                primaryStage.setX(primaryStage.getX() + 100);
                                                primaryStage.setY(primaryStage.getY() + 50);
                                                i++;
                                            }

                                        })
                        );
                        timeline.setCycleCount(Timeline.INDEFINITE);
                        timeline.play();

                    }

                    if (event.getCode() == KeyCode.UP) {
                        hero.translateBy(0, -heroSpeed);
                    } else if (event.getCode() == KeyCode.DOWN) {
                        hero.translateBy(0, heroSpeed);
                    } else if (event.getCode() == KeyCode.LEFT) {
                        if (selectedCharacterImageURL == GunnerRightUrl) {
                            hero.setImage(GunnerLeftUrl);
                            selectedCharacterImageURL = GunnerLeftUrl;
                        }
                        if (selectedCharacterImageURL == WizardRightUrl) {
                            hero.setImage(WizardLeftUrl);
                            selectedCharacterImageURL = WizardLeftUrl;
                        }
                        if (selectedCharacterImageURL == KnightRightUrl) {
                            hero.setImage(KnightLeftUrl);
                            selectedCharacterImageURL = KnightLeftUrl;
                        }

                        if (selectedCharacterImageURL == ObamaRightUrl) {
                            hero.setImage(ObamaLeftUrl);
                            selectedCharacterImageURL = ObamaLeftUrl;
                        }
                        //

                        hero.translateBy(-heroSpeed, 0);

                    } else if (event.getCode() == KeyCode.RIGHT) {
                        if (selectedCharacterImageURL == GunnerLeftUrl) {
                            hero.setImage(GunnerRightUrl);
                            selectedCharacterImageURL = GunnerRightUrl;
                        }
                        if (selectedCharacterImageURL == WizardLeftUrl) {
                            hero.setImage(WizardRightUrl);
                            selectedCharacterImageURL = WizardRightUrl;
                        }
                        if (selectedCharacterImageURL == KnightLeftUrl) {
                            hero.setImage(KnightRightUrl);
                            selectedCharacterImageURL = KnightRightUrl;
                        }
                        if (selectedCharacterImageURL == ObamaLeftUrl) {
                            hero.setImage(ObamaRightUrl);
                            selectedCharacterImageURL = ObamaRightUrl;
                        }

                        hero.translateBy(heroSpeed, 0);
                    }

                }

                // WENN HERO EINEN GEGNER BERÜHRT

                if (hero.intersects(monster1) && event.getCode() == KeyCode.E) {
                    System.out.println("Monster1 herausgefordert");
                    createMonster1Stage(primaryStage);
                    monster1Stage.show();
                }
                if (hero.intersects(monster2) && event.getCode() == KeyCode.E) {
                    System.out.println("Monster2 herausgefordert");
                    createMonster2Stage(primaryStage);
                    monster2Stage.show();
                }
                if (hero.intersects(boss) && event.getCode() == KeyCode.E) {
                    System.out.println("Boss herausgefordert");
                    createBossStage(primaryStage);
                    bossStage.show();

                }

                if (hero.intersects(shopKeeper) && event.getCode() == KeyCode.E) {
                    System.out.println("Shop geöffnet");
                    createShopStage(primaryStage);
                    shopStage.show();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        hero = new Sprite();
        hero.setPosition(0, GAME_WIDTH / 2);
        hero.setImage(selectedCharacterImageURL);


        monster1 = new Sprite();
        monster1.setPosition(GAME_HEIGHT - 50, GAME_WIDTH / 2);
        monster1.setImage("src/images/kumalala.jpg");
        mosterLabel2 = new Sprite();
        mosterLabel2.setPosition(GAME_HEIGHT - 40, GAME_WIDTH / 2 + 150);
        mosterLabel2.setImage("src/images/monster.jpg");

        monster2 = new Sprite();
        monster2.setPosition(GAME_WIDTH - 650, GAME_HEIGHT / 3);
        monster2.setImage("src/images/savesta.jpg");
        monsterlabel = new Sprite();
        monsterlabel.setImage("src/images/monster.jpg");
        monsterlabel.setPosition(GAME_WIDTH - 650, GAME_HEIGHT / 3 + 110);


        boss = new Sprite();
        boss.setPosition(GAME_WIDTH - 250, GAME_HEIGHT / 2 - 200);
        boss.setImage("src/images/kanye.jpg");
        bosslabel = new Sprite();
        bosslabel.setImage("src/images/boss.jpg");
        bosslabel.setPosition(GAME_WIDTH - 230, GAME_HEIGHT / 2 - 10);
        //private Sprite bosslabel;
        //private Sprite monsterlabel;

        shopKeeper = new Sprite();
        shopKeeper.setPosition(GAME_WIDTH / 2 - 50, 20);
        shopKeeper.setImage("src/images/amer.jpg");
        shoplabel = new Sprite();
        shoplabel.setImage("src/images/shopman.jpg");
        shoplabel.setPosition(GAME_WIDTH / 2 - 50, 130);


        backgroundSprite = new Sprite();
        backgroundSprite.setPosition(0, 0);
        backgroundSprite.setImage("src/images/GameGrass.png");

        backButtonSprite = new Sprite();
        backButtonSprite.setPosition(0, 0);
        backButtonSprite.setImage("src/images/backbutton.jpg");

        tl.play();

    }

    public void run(GraphicsContext gc) {
        if (gameStarted) {
            frameCount++;

            // PACMAN PRINZIP
            if (hero.getPositionY() < 0) hero.setPositionY(GAME_HEIGHT);
            else if (hero.getPositionY() > GAME_HEIGHT) hero.setPositionY(0);

            if (hero.getPositionX() < 0) hero.setPositionX(GAME_WIDTH);
            else if (hero.getPositionX() > GAME_WIDTH) hero.setPositionX(0);

        }

        gc.setFill(Color.FORESTGREEN);
        gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        backgroundSprite.render(gc);
        backButtonSprite.render(gc);
        gc.setFill(Color.WHITESMOKE);
        gc.setFont(Font.font(25));
        gc.setTextAlign(TextAlignment.CENTER);
        if (!gameStarted) {
            gc.fillText("Click to Start", GAME_WIDTH / 2, GAME_HEIGHT / 2);
        }

        hero.render(gc);
        monster1.render(gc);
        monster2.render(gc);
        boss.render(gc);
        shopKeeper.render(gc);
        shoplabel.render(gc);
        bosslabel.render(gc);
        monsterlabel.render(gc);
        mosterLabel2.render(gc);


    }


    public void setBossDefeated(boolean value) {
        this.BossDefeated = value;
    }

    public boolean isBossDefeated() {
        return this.BossDefeated;
    }

    public void createMonster1Stage(Stage stageToHide) {
        stageToHide.hide();
        monster1Health = 10;
        currentMana = maxMana;

        //Create Character ImageViews
        ImageView monster1ImageView = new ImageView(monster1.getImage());
        monster1ImageView.setLayoutX(600);
        monster1ImageView.setLayoutY(GAME_HEIGHT / 2 - 50);

        ImageView heroImageView = new ImageView(hero.getImage());
        heroImageView.setLayoutX(100);
        heroImageView.setLayoutY(GAME_HEIGHT / 2 - 50);

        //Create Nodes
        monster1Stage = new Stage();
        monster1Pane = new AnchorPane();


        //Buttons
        monster1BackButton = new Button("Back");
        monster1BackButton.setPrefHeight(50);
        monster1BackButton.setPrefWidth(150);

        Button monster1AttackButton = new Button("Attack");
        monster1AttackButton.setLayoutX(0);
        monster1AttackButton.setLayoutY(GAME_HEIGHT - 125);

        Button monster1SpecialAttackButton = new Button("Special Attack");
        monster1SpecialAttackButton.setLayoutX(50);
        monster1SpecialAttackButton.setLayoutY(GAME_HEIGHT - 125);

        Button monster1GetManaButton = new Button("Show current mana");
        monster1GetManaButton.setLayoutY(GAME_HEIGHT - 125);
        monster1GetManaButton.setLayoutX(140);

        Button monster1HelpButton = new Button("Help");
        monster1HelpButton.setLayoutX(260);
        monster1HelpButton.setLayoutY(GAME_HEIGHT - 125);

        //TextArea
        TextArea monster1Text = new TextArea();
        monster1Text.setText("Press help to see how the game works!");
        monster1Text.setEditable(false);
        monster1Text.setPrefWidth(GAME_WIDTH);
        monster1Text.setPrefHeight(150);
        monster1Text.setLayoutX(0);
        monster1Text.setLayoutY(GAME_HEIGHT - 100);

        //Add nodes to pane

        monster1Pane.getChildren().add(monster1BackButton);
        monster1Pane.getChildren().add(monster1ImageView);
        monster1Pane.getChildren().add(heroImageView);
        monster1Pane.getChildren().add(monster1Text);
        monster1Pane.getChildren().add(monster1AttackButton);
        monster1Pane.getChildren().add(monster1SpecialAttackButton);
        monster1Pane.getChildren().add(monster1GetManaButton);
        monster1Pane.getChildren().add(monster1HelpButton);

        monster1Pane.setBackground(new Background(
                new BackgroundImage(
                        new Image("images/GameGrass.png", false),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        monster1Scene = new Scene(monster1Pane, GAME_WIDTH, GAME_HEIGHT);
        monster1Stage.setScene(monster1Scene);
        monster1Stage.setResizable(false);


        // BUTTON ACTIONS
        monster1BackButton.setOnAction(event -> {
            setMonster1SpecialAttackUsed(false);
            monster1Stage.close();
            stageToHide.show();
        });

        monster1AttackButton.setOnAction(event -> {
            monster1Health -= attackDamage;
            currentMana -= 10;
            if (currentMana < 0) {
                Alert noManaAlert = new Alert(Alert.AlertType.WARNING);
                noManaAlert.setContentText("You lost all your mana! Always keep an eye on it!");
                noManaAlert.setTitle("GAME OVER");
                Optional<ButtonType> result = noManaAlert.showAndWait();
                if (!result.isPresent()) {
                    monster1Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.OK) {
                    monster1Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    monster1Stage.close();
                    stageToHide.show();
                }
            }
            monster1Text.setText(
                    "Attack did" + " " + attackDamage + " " + " Damage - Monster has" + " " + monster1Health + " " + "HP left");
            if (monster1Health <= 0) {
                setMonster1SpecialAttackUsed(false);
                currentMana = maxMana;
                coins += earnedCoins;
                Alert WinAlert = new Alert(Alert.AlertType.INFORMATION);
                WinAlert.setContentText("You earned" + " " + earnedCoins + " " + "coins through defeating the monster - You have" + " " + coins + " " + "coins now!");
                WinAlert.setTitle("Congratulations!");
                Optional<ButtonType> result = WinAlert.showAndWait();
                if (!result.isPresent()) {
                    monster1Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.OK) {
                    monster1Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    monster1Stage.close();
                    stageToHide.show();
                }
            }

        });

        monster1SpecialAttackButton.setOnAction(event -> {
            if (monster1SpecialAttackUsed) {
                monster1Text.setText("You can use the special attack only once in a fight!");
            }
            if (monster1SpecialAttackUsed == false) {
                setMonster1SpecialAttackUsed(true);
                monster1Health -= specialAttackDamage;
                currentMana -= 25;

                if (currentMana < 0) {
                    Alert noManaAlert = new Alert(Alert.AlertType.WARNING);
                    noManaAlert.setContentText("You lost all your mana! Always keep an eye on it!");
                    noManaAlert.setTitle("GAME OVER");
                    Optional<ButtonType> result = noManaAlert.showAndWait();
                    if (!result.isPresent()) {
                        monster1Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.OK) {
                        monster1Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        monster1Stage.close();
                        stageToHide.show();
                    }
                }
                monster1Text.setText(
                        "Special attack did" + " " + specialAttackDamage + " " + " Damage - Monster has" + " " + monster1Health + " " + "HP left");
                if (monster1Health <= 0) {
                    setMonster1SpecialAttackUsed(false);
                    coins += earnedCoins;
                    Alert WinAlert = new Alert(Alert.AlertType.INFORMATION);
                    WinAlert.setContentText("You earned" + " " + earnedCoins + " " + " coin through defeating the monster - You have" + " " + coins + " " + "coins now!");
                    WinAlert.setTitle("Congratulations!");
                    Optional<ButtonType> result = WinAlert.showAndWait();
                    if (!result.isPresent()) {
                        monster1Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.OK) {
                        monster1Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        monster1Stage.close();
                        stageToHide.show();
                    }
                }

            }
        });

        monster1GetManaButton.setOnAction(event -> {
            if (currentMana > 50) monster1Text.setText("You have" + " " + currentMana + " " + "mana left");
            if (currentMana < 50)
                monster1Text.setText("You have" + " " + currentMana + " " + "mana left - Be careful!");

        });

        monster1HelpButton.setOnAction(event -> {
            monster1Text.setText("If you use more mana than you have, you lose the game" +
                    "\n" + "A normal Attack deals" + " " + attackDamage + " " + "damage and costs 10 mana" +
                    "\n" + "The special Attack deals" + " " + specialAttackDamage + " " + "damage and costs 25 mana");
        });


        monster1AttackButton.setOnMousePressed(event -> {
            heroImageView.setLayoutY(heroImageView.getLayoutY() - 5);
        });

        monster1AttackButton.setOnMouseReleased(event -> {
            heroImageView.setLayoutY(heroImageView.getLayoutY() + 5);
        });

    }

    public void createMonster2Stage(Stage stageToHide) {
        stageToHide.hide();
        monster2Health = 50;
        currentMana = maxMana;

        //Create Character ImageViews
        ImageView monster2ImageView = new ImageView(monster2.getImage());
        monster2ImageView.setLayoutX(600);
        monster2ImageView.setLayoutY(GAME_HEIGHT / 2 - 50);

        ImageView heroImageView = new ImageView(hero.getImage());
        heroImageView.setLayoutX(100);
        heroImageView.setLayoutY(GAME_HEIGHT / 2 - 50);

        //Create Nodes
        monster2Stage = new Stage();
        monster2Pane = new AnchorPane();

        //Buttons
        monster2BackButton = new Button("Back");
        monster2BackButton.setPrefHeight(50);
        monster2BackButton.setPrefWidth(150);

        Button monster2AttackButton = new Button("Attack");
        monster2AttackButton.setLayoutX(0);
        monster2AttackButton.setLayoutY(GAME_HEIGHT - 125);

        Button monster2SpecialAttackButton = new Button("Special Attack");
        monster2SpecialAttackButton.setLayoutX(50);
        monster2SpecialAttackButton.setLayoutY(GAME_HEIGHT - 125);

        Button monster2GetManaButton = new Button("Show current mana");
        monster2GetManaButton.setLayoutY(GAME_HEIGHT - 125);
        monster2GetManaButton.setLayoutX(140);

        Button monster2HelpButton = new Button("Help");
        monster2HelpButton.setLayoutX(260);
        monster2HelpButton.setLayoutY(GAME_HEIGHT - 125);

        //TextArea
        TextArea monster2Text = new TextArea();
        monster2Text.setText("Press help to see how the game works!");
        monster2Text.setEditable(false);
        monster2Text.setPrefWidth(GAME_WIDTH);
        monster2Text.setPrefHeight(150);
        monster2Text.setLayoutX(0);
        monster2Text.setLayoutY(GAME_HEIGHT - 100);

        //Add nodes to pane

        monster2Pane.getChildren().add(monster2BackButton);
        monster2Pane.getChildren().add(monster2ImageView);
        monster2Pane.getChildren().add(heroImageView);
        monster2Pane.getChildren().add(monster2Text);
        monster2Pane.getChildren().add(monster2AttackButton);
        monster2Pane.getChildren().add(monster2SpecialAttackButton);
        monster2Pane.getChildren().add(monster2GetManaButton);
        monster2Pane.getChildren().add(monster2HelpButton);

        monster2Pane.setBackground(new Background(
                new BackgroundImage(
                        new Image("images/GameGrass.png", false),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        monster2Scene = new Scene(monster2Pane, GAME_WIDTH, GAME_HEIGHT);
        monster2Stage.setScene(monster2Scene);
        monster2Stage.setResizable(false);


        // BUTTON ACTIONS
        monster2BackButton.setOnAction(event -> {
            setMonster2SpecialAttackUsed(false);
            monster2Stage.close();
            stageToHide.show();
        });

        monster2AttackButton.setOnAction(event -> {
            monster2Health -= attackDamage;
            currentMana -= 10;
            if (currentMana < 0) {
                Alert noManaAlert = new Alert(Alert.AlertType.WARNING);
                noManaAlert.setContentText("You lost all your mana! Always keep an eye on it!");
                noManaAlert.setTitle("GAME OVER");
                Optional<ButtonType> result = noManaAlert.showAndWait();
                if (!result.isPresent()) {
                    monster2Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.OK) {
                    monster2Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    monster2Stage.close();
                    stageToHide.show();
                }
            }
            monster2Text.setText(
                    "Attack did" + " " + attackDamage + " " + " Damage - Monster has" + " " + monster2Health + " " + "HP left");

            if (monster2Health <= 0) {
                setMonster2SpecialAttackUsed(false);
                currentMana = maxMana;
                coins += earnedCoins * 10;
                Alert WinAlert = new Alert(Alert.AlertType.INFORMATION);
                WinAlert.setContentText("You earned" + " " + earnedCoins * 10 + " " + " coins through defeating the monster - You have" + " " + coins + " " + "coins now!");
                WinAlert.setTitle("Congratulations!");
                Optional<ButtonType> result = WinAlert.showAndWait();
                if (!result.isPresent()) {
                    monster2Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.OK) {
                    monster2Stage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    monster2Stage.close();
                    stageToHide.show();
                }
            }

        });

        monster2SpecialAttackButton.setOnAction(event -> {
            if (monster2SpecialAttackUsed) {
                monster2Text.setText("You can use the special attack only once in a fight!");
            }
            if (monster2SpecialAttackUsed == false) {
                setMonster2SpecialAttackUsed(true);
                monster2Health -= specialAttackDamage;
                currentMana -= 25;

                if (currentMana < 0) {
                    Alert noManaAlert = new Alert(Alert.AlertType.WARNING);
                    noManaAlert.setContentText("You lost all your mana! Always keep an eye on it!");
                    noManaAlert.setTitle("GAME OVER");
                    Optional<ButtonType> result = noManaAlert.showAndWait();
                    if (!result.isPresent()) {
                        monster2Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.OK) {
                        monster2Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        monster2Stage.close();
                        stageToHide.show();
                    }
                }
                monster2Text.setText(
                        "Special attack did" + " " + specialAttackDamage + " " + " Damage - Monster has" + " " + monster2Health + " " + "HP left");
                if (monster2Health <= 0) {
                    setMonster2SpecialAttackUsed(false);
                    coins += earnedCoins * 10;
                    Alert WinAlert = new Alert(Alert.AlertType.INFORMATION);
                    WinAlert.setContentText("You earned" + " " + earnedCoins * 10 + " " + "coin through defeating the monster - You have" + " " + coins + " " + "coins now!");
                    WinAlert.setTitle("Congratulations!");
                    Optional<ButtonType> result = WinAlert.showAndWait();
                    if (!result.isPresent()) {
                        monster2Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.OK) {
                        monster2Stage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        monster2Stage.close();
                        stageToHide.show();
                    }
                }

            }
        });

        monster2GetManaButton.setOnAction(event -> {
            if (currentMana > 50) monster2Text.setText("You have" + " " + currentMana + " " + "mana left");
            if (currentMana < 50)
                monster2Text.setText("You have" + " " + currentMana + " " + "mana left - Be careful!");

        });

        monster2HelpButton.setOnAction(event -> {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setContentText("If you use more mana than you have, you lose the game" +
                    "\n" + "A normal Attack deals" + " " + attackDamage + " " + "damage and costs 10 mana" +
                    "\n" + "The special Attack deals" + " " + specialAttackDamage + " " + "damage and costs 25 mana");
            infoAlert.show();

        });


//ONLY ANIMATION
        monster2AttackButton.setOnMousePressed(event -> {
            heroImageView.setLayoutY(heroImageView.getLayoutY() - 5);
        });

        monster2AttackButton.setOnMouseReleased(event -> {
            heroImageView.setLayoutY(heroImageView.getLayoutY() + 5);
        });
    }

    public void createBossStage(Stage stageToHide) {
        stageToHide.hide();
        bossHealth = 1000;
        currentMana = maxMana;

        //Create Character ImageViews
        ImageView bossImageView = new ImageView(boss.getImage());
        bossImageView.setLayoutX(600);
        bossImageView.setLayoutY(GAME_HEIGHT / 2 - 50);

        ImageView heroImageView = new ImageView(hero.getImage());
        heroImageView.setLayoutX(100);
        heroImageView.setLayoutY(GAME_HEIGHT / 2 - 50);

        //Create Nodes
        bossStage = new Stage();
        bossPane = new AnchorPane();

        //Buttons
        bossBackButton = new Button("Back");
        bossBackButton.setPrefHeight(50);
        bossBackButton.setPrefWidth(150);

        Button bossAttackButton = new Button("Attack");
        bossAttackButton.setLayoutX(0);
        bossAttackButton.setLayoutY(GAME_HEIGHT - 125);

        Button bossSpecialAttackButton = new Button("Special Attack");
        bossSpecialAttackButton.setLayoutX(50);
        bossSpecialAttackButton.setLayoutY(GAME_HEIGHT - 125);

        Button bossGetManaButton = new Button("Show current mana");
        bossGetManaButton.setLayoutY(GAME_HEIGHT - 125);
        bossGetManaButton.setLayoutX(140);

        Button bossHelpButton = new Button("Help");
        bossHelpButton.setLayoutX(260);
        bossHelpButton.setLayoutY(GAME_HEIGHT - 125);

        //TextArea
        TextArea bossText = new TextArea();
        bossText.setText("Press help to see how the game works!");
        bossText.setEditable(false);
        bossText.setPrefWidth(GAME_WIDTH);
        bossText.setPrefHeight(150);
        bossText.setLayoutX(0);
        bossText.setLayoutY(GAME_HEIGHT - 100);

        //Add nodes to pane

        bossPane.getChildren().add(bossBackButton);
        bossPane.getChildren().add(bossImageView);
        bossPane.getChildren().add(heroImageView);
        bossPane.getChildren().add(bossText);
        bossPane.getChildren().add(bossAttackButton);
        bossPane.getChildren().add(bossSpecialAttackButton);
        bossPane.getChildren().add(bossGetManaButton);
        bossPane.getChildren().add(bossHelpButton);

        bossPane.setBackground(new Background(
                new BackgroundImage(
                        new Image("images/BossBackground.png", false),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        bossScene = new Scene(bossPane, GAME_WIDTH, GAME_HEIGHT);
        bossStage.setScene(bossScene);
        bossStage.setResizable(false);


        // BUTTON ACTIONS
        bossBackButton.setOnAction(event -> {
            setBossSpecialAttackUsed(false);
            bossStage.close();
            stageToHide.show();
        });

        bossAttackButton.setOnAction(event -> {
            bossHealth -= attackDamage;
            currentMana -= 10;
            if (currentMana < 0) {
                Alert noManaAlert = new Alert(Alert.AlertType.WARNING);
                noManaAlert.setContentText("You lost all your mana! Always keep an eye on it!");
                noManaAlert.setTitle("GAME OVER");
                Optional<ButtonType> result = noManaAlert.showAndWait();
                if (!result.isPresent()) {
                    bossStage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.OK) {
                    bossStage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    bossStage.close();
                    stageToHide.show();
                }
            }

            bossText.setText(
                    "Attack did" + " " + attackDamage + " " + " Damage - Monster has" + " " + bossHealth + " " + "HP left");

            if (bossHealth <= 0) {

                setBossSpecialAttackUsed(false);
                currentMana = maxMana;
                coins += earnedCoins * 100;
                setBossDefeated(true);
                Alert WinAlert = new Alert(Alert.AlertType.INFORMATION);
                WinAlert.setContentText("You earned" + " " + earnedCoins * 100 + " " + " coins through defeating the monster - You have" + " " + coins + " " + "coins now!");
                WinAlert.setTitle("Congratulations!");
                Optional<ButtonType> result = WinAlert.showAndWait();
                if (!result.isPresent()) {
                    bossStage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.OK) {
                    bossStage.close();
                    stageToHide.show();
                } else if (result.get() == ButtonType.CANCEL) {
                    bossStage.close();
                    stageToHide.show();
                }
            }

        });

        bossSpecialAttackButton.setOnAction(event -> {
            if (bossSpecialAttackUsed) {
                bossText.setText("You can use the special attack only once in a fight!");
            }
            if (bossSpecialAttackUsed == false) {
                setBossSpecialAttackUsed(true);
                bossHealth -= specialAttackDamage;
                currentMana -= 25;

                if (currentMana < 0) {
                    Alert noManaAlert = new Alert(Alert.AlertType.WARNING);
                    noManaAlert.setContentText("You lost all your mana! Always keep an eye on it!");
                    noManaAlert.setTitle("GAME OVER");
                    Optional<ButtonType> result = noManaAlert.showAndWait();
                    if (!result.isPresent()) {
                        bossStage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.OK) {
                        bossStage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        bossStage.close();
                        stageToHide.show();
                    }
                }
                bossText.setText(
                        "Special attack did" + " " + specialAttackDamage + " " + " Damage - Monster has" + " " + bossHealth + " " + "HP left");
                if (bossHealth <= 0) {
                    setBossSpecialAttackUsed(false);
                    setBossDefeated(true);
                    coins += earnedCoins * 100;
                    Alert WinAlert = new Alert(Alert.AlertType.INFORMATION);
                    WinAlert.setContentText("You earned" + " " + earnedCoins * 100 + " " + "coin through defeating the monster - You have" + " " + coins + " " + "coins now!");
                    WinAlert.setTitle("Congratulations!");
                    Optional<ButtonType> result = WinAlert.showAndWait();
                    if (!result.isPresent()) {
                        bossStage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.OK) {
                        bossStage.close();
                        stageToHide.show();
                    } else if (result.get() == ButtonType.CANCEL) {
                        bossStage.close();
                        stageToHide.show();
                    }
                }

            }
        });

        bossGetManaButton.setOnAction(event -> {
            if (currentMana > 50) bossText.setText("You have" + " " + currentMana + " " + "mana left");
            if (currentMana < 50)
                bossText.setText("You have" + " " + currentMana + " " + "mana left - Be careful!");

        });

        bossHelpButton.setOnAction(event -> {
            bossText.setText("If you use more mana than you have, you lose the game" +
                    "\n" + "A normal Attack deals" + " " + attackDamage + " " + "damage and costs 10 mana" +
                    "\n" + "The special Attack deals" + " " + specialAttackDamage + " " + "damage and costs 25 mana");
        });


//ONLY ANIMATION
        bossAttackButton.setOnMousePressed(event -> {
            heroImageView.setLayoutY(heroImageView.getLayoutY() - 5);
        });

        bossAttackButton.setOnMouseReleased(event -> {
            heroImageView.setLayoutY(heroImageView.getLayoutY() + 5);
        });
    }


    public void createShopStage(Stage stageToHide) {
        stageToHide.hide();


        Image attackDamageBoost = new Image("images/PixelSword.png");
        Image specialAttackDamageBoost = new Image("images/PixelSword.png");
        Image coinBoost = new Image("images/PixelCoin.png");
        //   Image EpicSkin = new Image("images/PixelDarkskin.png");
        Image MovementSpeed = new Image("images/PixelShoe.png");


        ArrayList<Image> Items = new ArrayList<>();
        int y = 0;
        while (y < 16) {
            Items.add(attackDamageBoost);
            Items.add(specialAttackDamageBoost);
            Items.add(coinBoost);
            //  Items.add(EpicSkin);
            Items.add(MovementSpeed);
            y++;
        }

        ImageView wonItem = new ImageView("images/batman.png");
        wonItem.setFitHeight(150);
        wonItem.setFitWidth(150);
        wonItem.setLayoutY(GAME_HEIGHT / 2 - 75);
        wonItem.setLayoutX(GAME_WIDTH / 2 - 75);


        TextArea shopText = new TextArea();
        shopText.setEditable(false);
        shopText.setPrefHeight(125);
        shopText.setPrefWidth(GAME_WIDTH);
        shopText.setLayoutX(0);
        shopText.setLayoutY(25);
        shopText.setText("You have" + " " + coins + " " + "Coins");
        shopStage = new Stage();
        shopPane = new AnchorPane();
        BetterButton RollButton = new BetterButton("Roll! (Cost:" + " " + RollPrice + ")");
        Button shopBackButton = new Button("Back");
        Button showCoinsButton = new Button("Show Coins");

        RollButton.setStyle("-fx-background-color: gold; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        RollButton.setPrefHeight(50);
        RollButton.setPrefWidth(400);
        RollButton.setLayoutX(GAME_WIDTH / 2 - 200);
        RollButton.setLayoutY(GAME_HEIGHT - 125);
        shopBackButton.setPrefHeight(25);
        shopBackButton.setLayoutY(0);
        shopBackButton.setLayoutX(0);
        showCoinsButton.setPrefHeight(25);
        showCoinsButton.setLayoutY(0);
        showCoinsButton.setLayoutX(50);

        shopPane.getChildren().add(RollButton);
        shopPane.getChildren().add(shopText);
        shopPane.getChildren().add(shopBackButton);
        shopPane.getChildren().add(showCoinsButton);

        shopBackButton.setOnAction(event -> {
            stageToHide.show();
            shopStage.hide();
        });

        showCoinsButton.setOnAction(event -> {
            shopText.setText("You have" + " " + coins + " " + "Coins");

        });

        RollButton.setOnAction(event -> {
            if (coins >= RollPrice) {
                coins -= RollPrice;
                RollPrice *= 1.5;
                RollButton.setText(
                        "Roll! (Cost:" + " " + RollPrice + ")");
                int x = (int) (Math.random() * 15) + 1;
                if (Items.get(x) == attackDamageBoost) {
                    attackDamage *= 2;
                    shopText.setText("You won Atteack Damage Boost - You got " + " " + attackDamage + " " + "attack damage now");
                }


                if (Items.get(x) == specialAttackDamageBoost) {
                    specialAttackDamage *= 2;
                    shopText.setText("You won Special Attack Damage Boost - You got " + " " + specialAttackDamage + " " + " special attack damage now");
                }
                if (Items.get(x) == coinBoost) {
                    earnedCoins *= 2;
                    shopText.setText("You won Coin Boost - You earn" + " " + "x" +
                            " " + earnedCoins + " " + "now");
                }
                //  if (Items.get(x) == EpicSkin) {
                //    shopText.setText("You won Epic Skin");
                //}
                if (Items.get(x) == MovementSpeed) {
                    heroSpeed += 1;
                    if (heroSpeed > 10) {
                        shopText.setText("You already have max hero speed!");
                    }
                    shopText.setText("You won Mevement speed boost - You got" + " " + heroSpeed + " " + "Speed now");

                }

                wonItem.setImage(Items.get(x));
            } else {
                shopText.setText("Not enough money");
            }

        });

        shopPane.getChildren().add(wonItem);
        shopScene = new Scene(shopPane, GAME_WIDTH, GAME_HEIGHT);
        shopStage.setScene(shopScene);
        shopStage.setResizable(false);

        shopStage.show();
    }


    public void setMonster1SpecialAttackUsed(boolean value) {
        this.monster1SpecialAttackUsed = value;

    }

    public void setMonster2SpecialAttackUsed(boolean value) {
        this.monster2SpecialAttackUsed = value;

    }

    public void setBossSpecialAttackUsed(boolean value) {
        this.bossSpecialAttackUsed = value;

    }

    private static double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }
}


