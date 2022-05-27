package testing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ImgLeftRightTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Canvas canvas = new Canvas(400, 600);
        Image image = new Image("images\\Spider-Man_(Earth-1048_version).png");
        double xoff = 15;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.save();
        Button no = new Button("bro");

        gc.translate(image.getWidth() + xoff * 2, 0);
        gc.scale(-1, 1);
        gc.drawImage(image, xoff, 0);

        no.setOnAction(event -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.drawImage(image, 0, 0,image.getWidth(), image.getHeight(), image.getWidth(),0,-image.getWidth(),image.getHeight());
            //  gc.restore();
            //gc.drawImage(image, xoff, 0);
        });

        stage.setScene(new Scene(new Group(canvas, no)));
        stage.show();
    }
}