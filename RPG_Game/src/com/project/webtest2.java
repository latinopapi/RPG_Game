package com.project;
import static com.project.GamePanel.selectedCharacter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class webtest2 extends Application {
    private String selectedCharacterImageURL = "src/images/yakub.jpg";
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    private int moveSpeed = 20;
    private long frameCount = 0;

    private boolean gameStarted = false;

    private static boolean BossDefeated;

    private Sprite character;
    private Sprite Reihe1;
    private Sprite Reihe2;
    private Sprite Reihe3;
    private Sprite SpalteRechts;
    private Sprite SpalteLinks;
    private Sprite Reihe4;

    private boolean LabyrinthVerschoben = false;
    private boolean LabyrithVerschiebenBitte = false;

    private boolean LabyrinthZurückschiebenBitte;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private DoubleProperty timeSeconds = new SimpleDoubleProperty();

    private Duration time = Duration.ZERO, splitTime = Duration.ZERO;
    private int i = 0;
    ArrayList<Node> imgviewjumpscares;


    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("World 2");
        primaryStage.setResizable(false);


        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        Pane pane = new StackPane();
        pane.getChildren().add(canvas);

        Scene scene = new Scene(pane);

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        canvas.setOnMouseClicked(e -> {

            System.out.println("mouse clicked");
            gameStarted = !gameStarted;
        });
        // J U M P S C A R E S
        double random;
        double formattedrandom;
        ArrayList<Double> randomNumbers = new ArrayList<>();
        for (int n = 0; n < 10; n++) {
            random = (Math.random() * 0.4 + 0.001);
            formattedrandom = (Math.floor(random * 1000) / 1000);
            randomNumbers.add(formattedrandom);
        }
        Collections.sort(randomNumbers);
        for (Double d : randomNumbers) {
            System.out.println(d);
        }
        System.out.println("ENDE ARRAYLIST RANDOM NUMBERS");
        Image myimglightskin = new Image("images/lightskin.jpg");
        ImageView myimgviewlightskin = new ImageView(myimglightskin);
        Image myimgtravis = new Image("images/travis.jpg");
        ImageView myimgviewtravis = new ImageView(myimgtravis);
        Image myimgfortnite = new Image("images/fortnite.jpg");
        ImageView myimgviewfortnite = new ImageView(myimgfortnite);
        Image batman = new Image("images/batman.png");
        ImageView myimgviewbatman = new ImageView(batman);

        Image myimgjumpscare1 = new Image("images/jumpscares1.jpg");
        ImageView myimgviewjumpscare1 = new ImageView(myimgjumpscare1);
        Image myimgjumpscare2 = new Image("images/jumpscares2.jpg");
        ImageView myimgviewjumpscare2 = new ImageView(myimgjumpscare2);
        Image myimgjumpscare3 = new Image("images/jumpscares3.gif");
        ImageView myimgviewjumpscare3 = new ImageView(myimgjumpscare3);
        myimgviewjumpscare3.setFitWidth(500);


        imgviewjumpscares = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            imgviewjumpscares.add(myimgviewjumpscare1);
            imgviewjumpscares.add(myimgviewlightskin);
            imgviewjumpscares.add(myimgviewtravis);
            imgviewjumpscares.add(myimgviewfortnite);
            imgviewjumpscares.add(myimgviewjumpscare2);
            imgviewjumpscares.add(myimgviewbatman);
            imgviewjumpscares.add(myimgviewjumpscare3);

        }

        if (timeline != null) {
        } else {
            timeline = new Timeline(
                    new KeyFrame(Duration.millis(100),
                            t -> {
                                Duration duration = new Duration(1);
                                time = time.add(duration);
                                timeSeconds.set(time.toMillis());


                            })
            );
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();

        }

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (event) ->

        {


            if (gameStarted) {

                if (character.getPositionX() < 100 && character.getPositionY() == 700) {
                    try {
                        BossDefeated=true;
                        primaryStage.close();
                        WorldSelector worldSelector = new WorldSelector();
                        worldSelector.start(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (event.getCode() == KeyCode.UP) {
                    character.translateBy(0, -moveSpeed);
                    System.out.println("X:" + " " + character.getPositionX() + " " + "Y:" + " " + character.getPositionY());
                    System.out.println("Time:" + timeSeconds.getValue());
                    if (LabyrithVerschiebenBitte) {
                        Reihe2.translateBy(200, 0);
                        Reihe3.translateBy(-200, 0);
                        Reihe4.translateBy(200, 0);
                        LabyrithVerschiebenBitte = false;
                        LabyrinthVerschoben = true;
                    }

                    if (LabyrinthZurückschiebenBitte) {
                        Reihe2.translateBy(-200, 0);
                        Reihe3.translateBy(200, 0);
                        Reihe4.translateBy(-200, 0);
                        LabyrinthZurückschiebenBitte = false;
                        LabyrinthVerschoben = false;
                    }

                } else if (event.getCode() == KeyCode.DOWN) {
                    character.translateBy(0, moveSpeed);
                    System.out.println("X:" + " " + character.getPositionX() + " " + "Y:" + " " + character.getPositionY());
                    System.out.println("Time:" + timeSeconds.getValue());
                    if (LabyrithVerschiebenBitte) {
                        Reihe2.translateBy(200, 0);
                        Reihe3.translateBy(-200, 0);
                        Reihe4.translateBy(200, 0);
                        LabyrithVerschiebenBitte = false;
                        LabyrinthVerschoben = true;

                    }
                    if (LabyrinthZurückschiebenBitte) {
                        Reihe2.translateBy(-200, 0);
                        Reihe3.translateBy(200, 0);
                        Reihe4.translateBy(-200, 0);
                        LabyrinthZurückschiebenBitte = false;
                        LabyrinthVerschoben = false;
                    }

                } else if (event.getCode() == KeyCode.LEFT) {
                    character.translateBy(-moveSpeed, 0);
                    System.out.println("X:" + " " + character.getPositionX() + " " + "Y:" + " " + character.getPositionY());
                    System.out.println("Time:" + timeSeconds.getValue());
                    if (LabyrithVerschiebenBitte) {
                        Reihe2.translateBy(200, 0);
                        Reihe3.translateBy(-200, 0);
                        Reihe4.translateBy(200, 0);
                        LabyrithVerschiebenBitte = false;
                        LabyrinthVerschoben = true;
                    }

                    if (LabyrinthZurückschiebenBitte) {
                        Reihe2.translateBy(-200, 0);
                        Reihe3.translateBy(200, 0);
                        Reihe4.translateBy(-200, 0);
                        LabyrinthZurückschiebenBitte = false;
                        LabyrinthVerschoben = false;
                    }

                } else if (event.getCode() == KeyCode.RIGHT) {
                    character.translateBy(moveSpeed, 0);
                    System.out.println("X:" + " " + character.getPositionX() + " " + "Y:" + " " + character.getPositionY());
                    System.out.println("Time:" + timeSeconds.getValue());
                    if (LabyrithVerschiebenBitte) {
                        Reihe2.translateBy(200, 0);
                        Reihe3.translateBy(-200, 0);
                        Reihe4.translateBy(200, 0);
                        LabyrithVerschiebenBitte = false;
                        LabyrinthVerschoben = true;
                    }

                    if (LabyrinthZurückschiebenBitte) {
                        Reihe2.translateBy(-200, 0);
                        Reihe3.translateBy(200, 0);
                        Reihe4.translateBy(-200, 0);
                        LabyrinthZurückschiebenBitte = false;
                        LabyrinthVerschoben = false;
                    }

                }

                if (timeSeconds.getValue() % 15 == 0) {
                    if (LabyrinthVerschoben) {
                        LabyrinthZurückschiebenBitte = true;
                    } else if (!LabyrinthVerschoben) {
                        LabyrithVerschiebenBitte = true;
                    }
                }
                // Überprüfen ob character das rote berührt (intersects ging nicht)
                //Rand
                if (!LabyrinthVerschoben) {
                    if (character.getPositionY() < 100 || character.getPositionX() > 1000 || character.getPositionY() > 700 || character.getPositionX() < 0) {
                        System.err.println("Game Over");        character.setPosition(0, 100);
                    }
                    //Spalte Links
                    if (character.getPositionX() >= 0 && character.getPositionX() < 100 && character.getPositionY() > 100 && character.getPositionY() < 700) {
                        System.err.println("Game Over");        character.setPosition(0, 100);
                    }
                    //Reihe 2
                    if (character.getPositionX() >= 100 && character.getPositionX() < 1000 && character.getPositionY() > 100 & character.getPositionY() < 300) {
                        System.err.println("Game Over");        character.setPosition(0, 100);
                    }

                    //reihe 3
                    if (character.getPositionX() > 100 && character.getPositionY() > 300 && character.getPositionY() < 500) {
                        System.err.println("Game Over");        character.setPosition(0, 100);
                    }
                    //Reihe 4
                    if (character.getPositionX() >= 0 && character.getPositionX() < 1000 && character.getPositionY() > 500 && character.getPositionY() < 700) {
                        System.err.println("Game Over");        character.setPosition(0, 100);
                    }
                }
            }
            if(LabyrinthVerschoben){
                //Rand
                if (character.getPositionY() < 100 || character.getPositionX() > 1000 || character.getPositionY() > 700 || character.getPositionX() < 0) {
                    System.err.println("Game Over");
                    character.setPosition(0, 100);
                }
                //Spalte Links
                if (character.getPositionX() > 0 && character.getPositionX() < 100 && character.getPositionY() > 100 && character.getPositionY() < 700) {
                    System.err.println("Game Over");
                    character.setPosition(0, 100);
                }
                //Reihe 2
                if (character.getPositionX() > 200 && character.getPositionX() <= 1000 && character.getPositionY() > 100 & character.getPositionY() < 300) {
                    System.err.println("Game Over");
                    character.setPosition(0, 100);
                }

                //reihe 3
                if (character.getPositionX() > 0 && character.getPositionX() < 1000 && character.getPositionY() > 300 && character.getPositionY() < 500) {
                    System.err.println("Game Over");
                    character.setPosition(0, 100);
                }
                //Reihe 4
                if (character.getPositionX() > 100 && character.getPositionX() <= 1000 && character.getPositionY() > 500 && character.getPositionY() < 700) {
                    System.err.println("Game Over");
                    character.setPosition(0, 100);
                }
            }
        });

        character = new Sprite();
        character.setImage("src/images/yakub.jpg");
        character.setPosition(0, 100);


        Reihe1 = new Sprite();
        Reihe1.setImage("src/images/12erReihe.png");
        Reihe1.setPosition(0, 0);

        SpalteRechts = new Sprite();
        SpalteRechts.setImage("src/images/8erNachUnten.png");
        SpalteRechts.setPosition(WIDTH - 100, 0);

        SpalteLinks = new Sprite();
        SpalteLinks.setImage("src/images/5erNachUnten.png");
        SpalteLinks.setPosition(0, 200);

        Reihe2 = new Sprite();
        Reihe2.setImage("src/images/10erReihe.png");
        Reihe2.setPosition(0, 200);
        Reihe3 = new Sprite();
        Reihe3.setImage("src/images/10erReihe.png");
        Reihe3.setPosition(200, 400);
        Reihe4 = new Sprite();
        Reihe4.setImage("src/images/10erReihe.png");
        Reihe4.setPosition(0, 600);

        primaryStage.setScene(new

                Scene(new StackPane(canvas)));
        primaryStage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {


        // Bewegung von Sprites / Logik
        //////////////////////////////////////////////////////
        if (gameStarted) {
            frameCount++;


        }
        // RENDER / ZEICHEN VON SPRITES
        ///////////////////////////////////////////////////////
        // set graphics
        // set background color
        gc.setFill(Color.color(0, 0, 0));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        // set text
        gc.setFill(Color.color(1, 1, 1));
        gc.setFont(Font.font(25));
        // set the start text
        gc.setStroke(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        if (!gameStarted) {
            gc.fillText("Click to Start", WIDTH / 2, (HEIGHT / 4) - 20);
        }
        // score


        character.render(gc);
        Reihe1.render(gc);
        SpalteRechts.render(gc);
        SpalteLinks.render(gc);
        Reihe2.render(gc);
        Reihe3.render(gc);
        Reihe4.render(gc);
        drawShapes(gc);

    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.CHOCOLATE);
        gc.fillOval(0, 700, 100, 100);

    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }

    public boolean isBossDefeated() {
        return this.BossDefeated;
    }
}








