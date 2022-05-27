package testing;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.FileInputStream;

public class BetterButton extends Button {
    private static final String BUTTON_PRESSED_STYLE = "-fx-background-color: white; -fx-background-image: url('src/images/Button.png');";
    private static final String BUTTON_FREE_STYLE = "-fx-background-color: white; -fx-background-image: url('src/images/Button.png');";
    private static final String FONT_PATH = "src/ressources/Chickenhunter.ttf";

    public BetterButton(String text) {
        setText(text);
        setButtonFont();
        ButtonListeners();
        setStyle(BUTTON_FREE_STYLE);
    }

    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 50));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(65);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonFreeStyle() {
        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(69);
        setLayoutY(getLayoutY() - 4);
    }

    private void ButtonListeners() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonFreeStyle();
                }
            }
        });


    }
}
