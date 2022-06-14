package testing;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class JumpscareHashMapTest extends Application {

    private HashMap<Double, HashMap<Node, Node>> hashmapjumpscares = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        Media media1 = new Media("src/mainmusic/music/Jumpscare Sound.mp4");
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        MediaView mediaView1 = new MediaView(mediaPlayer1);
        mediaPlayer1.play();
        Image myimgtravis = new Image("images/travis.jpg");
        ImageView myimgviewtravis = new ImageView(myimgtravis);

        Image myimgfortnite = new Image("images/fortnite.jpg");
        ImageView myimgviewfortnite = new ImageView(myimgfortnite);

        HashMap hashmap1 = new HashMap<Node, Node>();
        hashmap1.put(mediaPlayer1, myimglightskin);

        hashmapjumpscares.put(0.112, hashmap1);


    }
}
