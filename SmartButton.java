package Camera;

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

public class SmartButton {
    
    private final int number;
    private final Stage stage;
    private final Button button;

    SmartButton(Stage stage, int number) {
        
        this.number = number;
        this.stage = stage;
        this.button = new Button("Camera #" + number);
        GridPane.setHalignment(button, HPos.CENTER); // Размещение кнопки по центру ячейки
        button.setMinSize(640, 20); // Установка минимального размера кнопки
        button.setOnAction((ActionEvent event) -> {
            Stage gialog = new Stage(); // Создание диалогового окна
            gialog.setTitle("Input camera IP"); // Установка заголовка диалогового окна
            
            // Создание размещение надписи в диалоговом окне
            Label label = new Label("Camera IP");
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
            Button canselButton = new Button("Cansel");
            canselButton.setLayoutX(180);
            canselButton.setLayoutY(60);
            canselButton.setMinSize(100, 20);
            canselButton.setOnAction((ActionEvent event1) -> {
                gialog.close();
            });
            
            // Создание и заполнение контейнера
            Pane pane = new Pane();
            pane.setPadding(new Insets(10));
            pane.getChildren().addAll(label, cameraIP, okButton, canselButton);
            
            Scene dialogScene = new Scene(pane, 290, 100, Color.BLACK); // Создание сцену и добавляем в нее контейнер
            gialog.setScene(dialogScene); // Устанавливаем сцену в окно программы
            gialog.initModality(Modality.WINDOW_MODAL); // Запрет операций с главным окном при открытии диалогового окна
            gialog.initOwner(stage); // Определение родительского окна
            
            // Размещение диалогового окна
            gialog.setX(stage.getX() + 500);
            gialog.setY(stage.getY() + 355);
            
            // Закрытие диалогового окна при нажатии клавиши Esc
            dialogScene.setOnKeyPressed((KeyEvent ke) -> {
                if (ke.getCode() == KeyCode.ESCAPE) {
                    gialog.close();
                }
            });
            gialog.show();
            
        });
    }
    
    public Button getButton() {
        return button;
    }
}
