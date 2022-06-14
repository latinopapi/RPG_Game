package com.project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;

public class World3 extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    WorldSelector ws = new WorldSelector();
    private int anzahlRichtigeAntworten = 0;

    private final String[] Fragen = {
            "Is Nabil a lightskin?",
            "Will he get the n-word pass?",
            "Will you give this game a good rating?",
            " "
    };
    private final String[] Button1Antworten = {"Yes", "No", "Maybe", " "};
    private final String[] Button2Antworten = {"No", "Yes", "Maybe", " "};
    private final String[] Button3Antworten = {"Maybe", "Joe Mama", "Yes", " "};
    int FrageNummer = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea("");
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-size: 30px; -fx-font-family: 'Cambria Math'");
        textArea.setPrefHeight(100);
        textArea.setPrefWidth(WIDTH);
        textArea.setLayoutX(0);
        textArea.setLayoutY(0);
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        BetterButton button1 = new BetterButton("Antwort 1");
        button1.setLayoutX(WIDTH / 2 - 200);
        button1.setLayoutY(150);
        button1.setPrefHeight(50);
        button1.setPrefWidth(400);
        BetterButton button2 = new BetterButton("Antwort 2");
        button2.setLayoutX(WIDTH / 2 - 200);
        button2.setLayoutY(300);
        button2.setPrefHeight(50);
        button2.setPrefWidth(400);
        BetterButton button3 = new BetterButton("Antwort 3");
        button3.setLayoutX(WIDTH / 2 - 200);
        button3.setLayoutY(450);
        button3.setPrefHeight(50);
        button3.setPrefWidth(400);

        pane.getChildren().add(button1);
        pane.getChildren().add(button2);
        pane.getChildren().add(button3);
        pane.getChildren().add(textArea);

        // QUIZ PRINZIP

        textArea.setText(Fragen[FrageNummer]);
        button1.setText(Button1Antworten[FrageNummer]);
        button2.setText(Button2Antworten[FrageNummer]);
        button3.setText(Button3Antworten[FrageNummer]);

        button1.setOnAction(event -> {
            if (FrageNummer == 0) { //falls richtig geantwortet wurde
                System.out.println("Richtig");
                anzahlRichtigeAntworten++;
                Fragen[3] = "You got" + " " + anzahlRichtigeAntworten + " " + "/3 correct";
                FrageNummer++;
                if (!(FrageNummer > 3)) {
                    textArea.setText(Fragen[FrageNummer]);
                    //pane.getChildren().remove(button1);
                    //pane.getChildren().remove(Button1Antworten);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);
                }
            } else if (FrageNummer == 1 || FrageNummer == 3) {
                System.err.println("Falsch");
                FrageNummer++;
                if (!(FrageNummer > 3)) {
                    textArea.setText(Fragen[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);
                }
            } else if (FrageNummer == 2) {
                System.err.println("Falsch");
                Button2Antworten[3] = "CONTINUE";
                if (!(FrageNummer > 3)) {
                    Fragen[3] = "You got" + " " + anzahlRichtigeAntworten + " " + "/3 correct";
                    FrageNummer++;
                    textArea.setText(Fragen[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);

                }
            }

        });

        button2.setOnAction(event -> {
            if (button2.getText().equals("CONTINUE")) {
                if (anzahlRichtigeAntworten >= 3) {
                    System.out.println("DU HAST ES GESCHAFFT");
                    Label nice = new Label("super, jetzt hast du ein Zertifikat");
                    Scene newscene = new Scene(nice, 400, 200);
                    primaryStage.setScene(newscene);
                    nice.setStyle("-fx-font-family: 'Arial Black';-fx-font-size: 20px");
                    nice.setAlignment(Pos.CENTER);
                    final WebView browser = new WebView();
                    final WebEngine webEngine = browser.getEngine();
                    URL url = this.getClass().getResource("C:\\Users\\nabil\\OneDrive\\RPG_GAME\\RPG_GAME_2022-05-17\\certificate_original.html");
                    webEngine.load(url.toString());

                } else if (anzahlRichtigeAntworten < 3){
                    primaryStage.close();
                    WorldSelector ws = new WorldSelector();
                    try {
                        ws.start(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }


            if (FrageNummer == 1) { //falls richtig geantwortet wurde
                System.out.println("Richtig");
                anzahlRichtigeAntworten++;
                Fragen[3] = "You got" + " " + anzahlRichtigeAntworten + " " + "/3 correct";
                FrageNummer++;
                if (!(FrageNummer > 3)) {
                    textArea.setText(Fragen[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);
                }
            } else if (FrageNummer == 0) {
                System.err.println("Falsch");
                FrageNummer++;
                if (!(FrageNummer > 3)) {
                    textArea.setText(Fragen[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);
                }
            } else if (FrageNummer == 2) {
                System.err.println("Falsch");
                Button2Antworten[3] = "CONTINUE";
                if (!(FrageNummer > 3)) {
                    Fragen[3] = "You got" + " " + anzahlRichtigeAntworten + " " + "/3 correct";
                    FrageNummer++;
                    textArea.setText(Fragen[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);

                }

            }
        });

        button3.setOnAction(event -> {
            if (FrageNummer == 2) { //falls richtig geantwortet wurde
                System.out.println("Richtig");
                anzahlRichtigeAntworten++;
                Button2Antworten[3] = "CONTINUE";
                if (!(FrageNummer > 3)) {
                    Fragen[3] = "You got" + " " + anzahlRichtigeAntworten + " " + "/3 correct";
                    FrageNummer++;
                    textArea.setText(Fragen[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);

                }
            } else {
                Fragen[3] = "You got" + " " + anzahlRichtigeAntworten + " " + "/3 correct";
                System.err.println("Falsch");
                FrageNummer++;
                if (!(FrageNummer > 3)) {
                    textArea.setText(Fragen[FrageNummer]);
                    button1.setText(Button1Antworten[FrageNummer]);
                    button2.setText(Button2Antworten[FrageNummer]);
                    button3.setText(Button3Antworten[FrageNummer]);
                }
            }

        });


    }


}