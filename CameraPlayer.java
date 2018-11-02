// Видеоплеер

package Camera;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CameraPlayer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Camera Player"); // Устанавливаем заголовок окна
        
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
        
        GridPane root = new GridPane(); // Создаем контейнер
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
        GridPane.setHalignment(button1, HPos.CENTER);
        GridPane.setHalignment(button2, HPos.CENTER);
        GridPane.setHalignment(button3, HPos.CENTER);
        GridPane.setHalignment(button4, HPos.CENTER);

        Scene scene = new Scene(root, 1310, 820, Color.BLACK); // Создаем сцену и добавляем в нее контейнер
        stage.setScene(scene); // Устанавливаем сцену в окно программы
        stage.show(); // Отображаем окно программы
    }
}
