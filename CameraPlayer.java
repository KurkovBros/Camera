// Видеоплеер

package Camera;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;

public class CameraPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Camera Player"); // Устанавливаем заголовок окна
        stage.setResizable(false); // Запрещаем изменять размер окна

        // Создаем четыре объекта класса Viewer для отображения видеопотоков с четырех камер
        Viewer view1 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Baby.mp4");
        Viewer view2 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Crying.mp4");
        Viewer view3 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Slim.mp4");
        Viewer view4 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Alergia.mp4");

        // Создаем кнопки для выбора камер
        Button button1 = new Button("Camera #1");
        Button button2 = new Button("Camera #2");
        Button button3 = new Button("Camera #3");
        Button button4 = new Button("Camera #4");

        // Создаем и заполняем контейнер элементами
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        
        root.add(view1.getGroup(), 0, 0);
        root.add(view2.getGroup(), 1, 0);
        root.add(button1, 0, 1);
        root.add(button2, 1, 1);
        root.add(view3.getGroup(), 0, 2);
        root.add(view4.getGroup(), 1, 2);
        root.add(button3, 0, 3);
        root.add(button4, 1, 3);

        // Располагаем кнопки по центру и указываем их размер
        GridPane.setHalignment(button1, HPos.CENTER);
        GridPane.setHalignment(button2, HPos.CENTER);
        GridPane.setHalignment(button3, HPos.CENTER);
        GridPane.setHalignment(button4, HPos.CENTER);
        button1.setMinSize(640, 20);
        button2.setMinSize(640, 20);
        button3.setMinSize(640, 20);
        button4.setMinSize(640, 20);

        Button button = new Button();
        button.setText("Open a New Window");

        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage gialog = new Stage();
                gialog.setTitle("Input camera IP");
                Label label = new Label("Camera IP");
                TextField cameraIP = new TextField();
                Pane pane = new Pane();
                pane.setPadding(new Insets(10));
                label.setLayoutX(10);
                label.setLayoutY(10);
                cameraIP.setLayoutX(50);
                cameraIP.setLayoutY(10);
                pane.getChildren().addAll(label, cameraIP);
                Scene secondScene = new Scene(pane, 230, 100, Color.BLACK);
                gialog.setScene(secondScene);
                gialog.initModality(Modality.WINDOW_MODAL);
                gialog.initOwner(stage);
                

                // Set position of second window, related to primary window.
                gialog.setX(stage.getX() + 200);
                gialog.setY(stage.getY() + 100);

                gialog.show();
            }
        });

        Scene scene = new Scene(root, 1300, 810, Color.BLACK); // Создаем сцену и добавляем в нее контейнер
        stage.setScene(scene); // Устанавливаем сцену в окно программы
        stage.show(); // Отображаем окно программы
    }
}
