package testing;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Jumpscare extends Application {

    private Timeline timeline;
    private Label timerLabel = new Label();
    private DoubleProperty timeSeconds = new SimpleDoubleProperty();

    private Duration time = Duration.ZERO, splitTime = Duration.ZERO;
    private int i = 0;
    ArrayList<Node> listjumpscares;

    @Override
    public void start(Stage primaryStage) {
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");

        Button button = new Button();
        button.setText("Start / Split");
        double random;
        double formattedrandom;
        ArrayList<Double> randomNumbers = new ArrayList<>();
        /*for (int n = 0; n < 5; n++) {
           random = (Math.random() * 0.15+ 0.001)+0.02;
            formattedrandom = (Math.floor(random * 1000) / 1000);
            randomNumbers.add(formattedrandom);
          }*/

        double prevNumber = 0.01;
        for (int n = 0; n < 5; n++) {
            random = (Math.random() * 0.15+ 0.001)+prevNumber+0.02;       //WIESO GEHT DAS?
            formattedrandom = (Math.floor(random * 1000) / 1000);
            prevNumber = formattedrandom;
            randomNumbers.add(formattedrandom);
        }

/*
int prevNumber = 0;
for (int n = 0; n < 5; n++) {
            random = (Math.random() * 0.15+ 0.001)+prevNumber+0.02;
            formattedrandom = (Math.floor(random * 1000) / 1000);
            prevNumber = formattedrandom;
            randomNumbers.add(formattedrandom);
        } VON DEM TYPEN AUS DISCORD

        System.out.println("OTHER RANDOM NUMBERS");
        double max = 10;
        double min = 1;
        Random random2 = new Random();
        double first = random2.nextDouble(max - min) + min;
        double second = random2.nextDouble(max + 10 - first) + first + 10;
        double third = random2.nextDouble(max + 20 - second) + second + 10;
        System.out.println(first + " " + second + " " + third);
        System.out.println("OTHER RANDOM NUMBERS FINISHED");
*/
        Collections.sort(randomNumbers);
        for (Double d : randomNumbers) {
            System.out.println(d);
        }
        System.out.println("ENDE ARRAYLIST RANDOM NUMBERS");

        Image myimglightskin = new Image("C:\\Users\\nabil\\OneDrive\\RPG_GAME\\RPG_GAME 2022-04-26\\src\\images\\lightskin.jpg");
        ImageView myimgviewlightskin = new ImageView(myimglightskin);
        Image myimgtravis = new Image("C:\\Users\\nabil\\OneDrive\\RPG_GAME\\RPG_GAME 2022-04-26\\src\\images\\travis.jpg");
        ImageView myimgviewtravis = new ImageView(myimgtravis);
        Image myimgfortnite = new Image("C:\\Users\\nabil\\OneDrive\\RPG_GAME\\RPG_GAME 2022-04-26\\src\\images\\fortnite.jpg");
        ImageView myimgviewfortnite = new ImageView(myimgfortnite);


        StackPane root = new StackPane();
        Scene scene = new Scene(root, 350, 400);
        VBox vb = new VBox(20);
        vb.setAlignment(Pos.CENTER);
        vb.setPrefWidth(scene.getWidth());
        vb.setLayoutY(30);
        vb.getChildren().addAll(button, timerLabel);
        root.getChildren().add(vb);
        primaryStage.setTitle("FX Timer");
        primaryStage.setScene(scene);
        primaryStage.show();

        String path = "C:\\Users\\nabil\\Videos\\Grand Theft Auto V\\Grand Theft Auto V 2021.08.12 - 19.08.30.01.mp4";
        Media mediaGTA = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayerGTA = new MediaPlayer(mediaGTA);
        MediaView mediaViewGTA = new MediaView(mediaPlayerGTA);
        mediaPlayerGTA.setAutoPlay(false);


        listjumpscares = new ArrayList<>();
        listjumpscares.add(mediaViewGTA);
        listjumpscares.add(myimgviewlightskin);
        listjumpscares.add(myimgviewtravis);
        listjumpscares.add(myimgviewfortnite);


        button.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (timeline != null) {
                } else {
                    timeline = new Timeline(
                            new KeyFrame(Duration.millis(100),
                                    t -> {
                                        Duration duration = new Duration(1);
                                        time = time.add(duration);
                                        timeSeconds.set(time.toSeconds());
                                        mediaPlayerGTA.setStartTime(Duration.millis(randomNumbers.get(i)));

                                        if (randomNumbers.get(i).equals(timeSeconds.getValue())) {
                                            System.out.println("JUMPSCARE" + i);
                                            root.getChildren().add(listjumpscares.get(i));
                                            mediaPlayerGTA.play();


                                        }
                                        if (timeSeconds.getValue().equals(randomNumbers.get(i) + 0.01)) {
                                            root.getChildren().remove(listjumpscares.get(i));
                                            mediaPlayerGTA.stop();
                                            i++;
                                        }
                                    })
                    );
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();

                }
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}