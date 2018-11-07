// Класс, экземпляр которого создает окно программы

package Camera;

import static Camera.CameraPlayer.config;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

public class GUI {
    
    private final Stage primaryWindow;
    private final GridPane root = new GridPane();
    private Viewer view1;
    private Viewer view2;
    private Viewer view3;
    private Viewer view4;

    public GUI() throws IOException, FileNotFoundException, ParseException {
        Map<Integer, String> mapStr = Configuration.readConfig(config);
        String camera1 = mapStr.get(1);
        String camera2 = mapStr.get(2);
        String camera3 = mapStr.get(3);
        String camera4 = mapStr.get(4);
        primaryWindow = new Stage(); // Создание главного окна программы
        primaryWindow.setTitle("Camera Player"); // Установка заголовока окна
        primaryWindow.setResizable(false); // Запрет изменения размера окна
        
        // Создание четырех объектов класса Viewer для отображения видеопотоков с четырех камер
        view1 = new Viewer(camera1);
        view2 = new Viewer(camera2);
        view3 = new Viewer(camera3);
        view4 = new Viewer(camera4);
        
        // Создание четырех умных кнопок
        SmartButton button1 = new SmartButton(primaryWindow, 1);
        SmartButton button2 = new SmartButton(primaryWindow, 2);
        SmartButton button3 = new SmartButton(primaryWindow, 3);
        SmartButton button4 = new SmartButton(primaryWindow, 4);

        // Создание и заполнение контейнера элементами
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
        
        Scene scene = new Scene(root, 1300, 810, Color.BLACK); // Создание сцены и добавление в нее контейнера
        primaryWindow.setScene(scene); // Установка сцены в окно программы
        primaryWindow.show(); // Отображение окна программы
    }

    public void modifyRoot(int number) throws IOException, FileNotFoundException, ParseException {
        if (number == 1) {
            root.getChildren().remove(view1.getGroup());
            view1 = new Viewer(Configuration.readConfig(config).get(1));
            root.add(view1.getGroup(), 0, 0);
        } else if (number == 2) {
            root.getChildren().remove(view2.getGroup());
            view2 = new Viewer(Configuration.readConfig(config).get(2));
            root.add(view2.getGroup(), 1, 0);
        } else if (number == 3) {
            root.getChildren().remove(view3.getGroup());
            view3 = new Viewer(Configuration.readConfig(config).get(3));
            root.add(view3.getGroup(), 0, 2);
        } else if (number == 4) {
            root.getChildren().remove(view4.getGroup());
            view4 = new Viewer(Configuration.readConfig(config).get(4));
            root.add(view4.getGroup(), 1, 2);
        }
    }
}
