// Видеоплеер

package Camera;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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

        // Создаем четыре умных кнопки
        SmartButton button1 = new SmartButton(stage, 1);
        SmartButton button2 = new SmartButton(stage, 2);
        SmartButton button3 = new SmartButton(stage, 3);
        SmartButton button4 = new SmartButton(stage, 4);
        
        // Создаем и заполняем контейнер элементами
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.add(view1.getGroup(), 0, 0);
        root.add(view2.getGroup(), 1, 0);
        root.add(button1.getButton(), 0, 1);
        root.add(button2.getButton(), 1, 1);
        root.add(view3.getGroup(), 0, 2);
        root.add(view4.getGroup(), 1, 2);
        root.add(button3.getButton(), 0, 3);
        root.add(button4.getButton(), 1, 3);
        
        Scene scene = new Scene(root, 1300, 810, Color.BLACK); // Создание сцену и добавляем в нее контейнер
        stage.setScene(scene); // Устанавливаем сцену в окно программы
        stage.show(); // Отображаем окно программы
    }
}
