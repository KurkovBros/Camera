// Класс для создания и обработки нажатия на кнопку выбора камеры

package Camera;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

public class SmartButton {
    
    private final Stage stage;
    private final Button button;
    private static int number;
    private static String inputText;

    SmartButton(Stage stage, int number) {
        this.stage = stage;
        this.button = new Button("Camera #" + number);
        createSmartButton(number);
    }
    
    private void createSmartButton(int number) {
        GridPane.setHalignment(button, HPos.CENTER); // Размещение кнопки по центру ячейки
        button.setMinSize(640, 20); // Установка минимального размера кнопки
        button.setOnAction((ActionEvent event) -> {
            Stage secondaryWindow = new Stage(); // Создание диалогового окна
            secondaryWindow.setTitle("Input camera IP"); // Установка заголовка диалогового окна
            
            // Создание размещение надписи в диалоговом окне
            Label label = new Label("Camera #" + number);
            label.setLayoutX(10); // Указание
            label.setLayoutY(24);
            
            // Создание и размещение поля для ввода IP адреса камеры
            TextField cameraIP = new TextField();
            cameraIP.setLayoutX(70);
            cameraIP.setLayoutY(20);
            cameraIP.setMinWidth(210);
            
            // Создание и размещение кнопки ОК
            Button okButton = new Button("Ok");
            okButton.setLayoutX(70);
            okButton.setLayoutY(60);
            okButton.setMinSize(100, 20);
            okButton.setOnAction((ActionEvent event1) -> {
                try {
                    inputText = cameraIP.getText();
                    Configuration.modifyConfig(inputText, number);
                    CameraPlayer.getGui().modifyRoot(number);
                    secondaryWindow.close();
                } catch (IOException | ParseException ex) {
                    Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            // Создание и размещение кнопки Cansel
            Button canselButton = new Button("Cansel");
            canselButton.setLayoutX(180);
            canselButton.setLayoutY(60);
            canselButton.setMinSize(100, 20);
            canselButton.setOnAction((ActionEvent event1) -> {
                secondaryWindow.close();
            });
            
            // Создание и заполнение контейнера
            Pane pane = new Pane();
            pane.setPadding(new Insets(10));
            pane.getChildren().addAll(label, cameraIP, okButton, canselButton);
            
            Scene secondaryScene = new Scene(pane, 290, 100, Color.BLACK); // Создание сцену и добавляем в нее контейнер
            secondaryWindow.setScene(secondaryScene); // Устанавливаем сцену в окно программы
            secondaryWindow.initModality(Modality.WINDOW_MODAL); // Запрет операций с главным окном при открытии диалогового окна
            secondaryWindow.initOwner(stage); // Определение родительского окна
            
            // Размещение диалогового окна
            secondaryWindow.setX(stage.getX() + 500);
            secondaryWindow.setY(stage.getY() + 355);
            
            // Закрытие диалогового окна при нажатии клавиши Esc
            secondaryScene.setOnKeyPressed((KeyEvent ke) -> {
                if (ke.getCode() == KeyCode.ESCAPE) {
                    secondaryWindow.close();
                } else if (ke.getCode() == KeyCode.ENTER) {
                    try {
                        inputText = cameraIP.getText();
                        Configuration.modifyConfig(inputText, number);
                        CameraPlayer.getGui().modifyRoot(number);
                        secondaryWindow.close();
                    } catch (IOException | ParseException ex) {
                        Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            secondaryWindow.show();
        });
    }

    public Button getButton() {
        return button;
    }
}
