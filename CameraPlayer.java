// Видеоплеер

package Camera;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class CameraPlayer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Camera Player"); // Устанавливаем заголовок окна
        
        // Создаем четыре объекта класса Viewer для отображения видеопотоков с четырех камер
        Viewer view1 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Baby.mp4");
        Viewer view2 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Crying.mp4");
        Viewer view3 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Slim.mp4");
        Viewer view4 = new Viewer("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Alergia.mp4");
        
        FlowPane root = new FlowPane(view1.getGroup(), view2.getGroup(), view3.getGroup(), view4.getGroup()); // Создаем контейнер и добавляем в него четыре видеопотока
        Scene scene = new Scene(root, 1280, 720, Color.BLACK); // Создаем сцену и добавляем в нее контейнер
        stage.setScene(scene); // Устанавливаем сцену в окно программы
        stage.show(); // Отображаем окно программы
    }
}
