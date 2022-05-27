package com.project;

import javafx.stage.Stage;

public class Main extends GamePanel {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GamePanel gamePanel = new GamePanel();
        gamePanel.start(primaryStage);
    }

}
