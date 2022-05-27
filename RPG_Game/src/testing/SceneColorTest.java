package testing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneColorTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Title");

        final Circle circ = new Circle(40, 40, 30);
        final Group root = new Group(circ);

        Scene scene = new Scene(root);
        root.setId("pane");
        final Text text1 = new Text(25, 25, "java2s.com");
        text1.setFill(Color.CHOCOLATE);
        text1.setFont(Font.font(java.awt.Font.SERIF, 25));
        root.getChildren().add(text1);
        scene.getStylesheets().addAll(this.getClass().getResource("backgroundTEST.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
