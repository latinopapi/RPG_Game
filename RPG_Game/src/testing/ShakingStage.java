package testing;
/*
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.StackPaneBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShakingStage extends Application {

    public Stage primaryStage;
    boolean xyState= true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage= stage;
        Button shakeButton= ButtonBuilder.create()
                .text("shake it")
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        TimelineBuilder.create()
                                .keyFrames(new KeyFrame(Duration.seconds(0.2), new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        if (xyState) {
                                            primaryStage.setX(primaryStage.getX() + 10);
                                            primaryStage.setY(primaryStage.getY() + 10);
                                        } else {
                                            primaryStage.setX(primaryStage.getX() - 10);
                                            primaryStage.setY(primaryStage.getY() - 10);
                                        }
                                        xyState= !xyState;
                                    }
                                }))
                                .autoReverse(true)
                                .cycleCount(Timeline.INDEFINITE)
                                .build().play();
                    }
                })
                .build();

        Scene scene= SceneBuilder.create()
                .root(StackPaneBuilder.create()
                        .children(shakeButton)
                        .build()
                )
                .width(300)
                .height(400)
                .build();

        stage.setScene(scene);
        stage.show();
    }
}*/