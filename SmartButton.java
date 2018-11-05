// Класс для создания и обработки нажатия на кнопку выбора камеры

package Camera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SmartButton {
    
    private final Stage stage;
    private final Button button;
    private final int number;

    SmartButton(Stage stage, int number) {
        this.stage = stage;
        this.button = new Button("Camera #" + number);
        this.number = number;
        createSmartButton();
    }
    
    private void createSmartButton() {
        GridPane.setHalignment(button, HPos.CENTER); // Размещение кнопки по центру ячейки
        button.setMinSize(640, 20); // Установка минимального размера кнопки
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                
                // Создание и размещение кнопок
                Button okButton = new Button("Ok");
                okButton.setLayoutX(70);
                okButton.setLayoutY(60);
                okButton.setMinSize(100, 20);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event1) {
                        try {
                            String config = CameraPlayer.getConfig();
                            JSONParser parser = new JSONParser();
                            JSONArray array = (JSONArray) parser.parse(new FileReader(config));
                            JSONObject jCamera = new JSONObject();
                            String text = cameraIP.getText();
                            jCamera.put("Camera #" + number, cameraIP.getText());
                            array.set(number, event);
                            File oldFile = new File(config);
                            oldFile.delete();
                            try (FileWriter newFile = new FileWriter(config)) {
                                newFile.write(array.toJSONString().replace("\\/", "/"));
                                newFile.flush();
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException | ParseException ex) {
                            Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
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
                
                Scene dialogScene = new Scene(pane, 290, 100, Color.BLACK); // Создание сцену и добавляем в нее контейнер
                secondaryWindow.setScene(dialogScene); // Устанавливаем сцену в окно программы
                secondaryWindow.initModality(Modality.WINDOW_MODAL); // Запрет операций с главным окном при открытии диалогового окна
                secondaryWindow.initOwner(stage); // Определение родительского окна
                
                // Размещение диалогового окна
                secondaryWindow.setX(stage.getX() + 500);
                secondaryWindow.setY(stage.getY() + 355);
                
                // Закрытие диалогового окна при нажатии клавиши Esc
                dialogScene.setOnKeyPressed((KeyEvent ke) -> {
                    if (ke.getCode() == KeyCode.ESCAPE) {
                        secondaryWindow.close();
                    }
                });
                secondaryWindow.show();
            }
        });
    }
    
    public Button getButton() {
        return button;
    }
}
