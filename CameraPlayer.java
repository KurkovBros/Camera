// Основной класс

package Camera;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CameraPlayer extends Application {
    
    public static String config = "C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/config.json";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryWindow) throws IOException, ParseException {
        
        String camera1;
        String camera2;
        String camera3;
        String camera4;
        
        // Чтение JSON файла настроек
        JSONParser parser = new JSONParser();
        File f = new File(config);
        if (f.exists()) {
            JSONArray array = (JSONArray) parser.parse(new FileReader(config));
            JSONObject jCamera1 = (JSONObject) array.get(0);
            JSONObject jCamera2 = (JSONObject) array.get(1);
            JSONObject jCamera3 = (JSONObject) array.get(2);
            JSONObject jCamera4 = (JSONObject) array.get(3);
            camera1 = (String) jCamera1.get("Camera #1");
            camera2 = (String) jCamera2.get("Camera #2");
            camera3 = (String) jCamera3.get("Camera #3");
            camera4 = (String) jCamera4.get("Camera #4");
        } else {
            // Создание массива объектов JSON с директориями видеозаписей / адресами IP видеокамер
            camera1 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Baby.mp4";
            camera2 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Crying.mp4";
            camera3 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Slim.mp4";
            camera4 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Alergia.mp4";
            JSONArray array = new JSONArray();
            JSONObject object = new JSONObject();
            object.put("Camera #1", camera1);
            array.add(object);
            object = new JSONObject();
            object.put("Camera #2", camera2);
            array.add(object);
            object = new JSONObject();
            object.put("Camera #3", camera3);
            array.add(object);
            object = new JSONObject();
            object.put("Camera #4", camera4);
            array.add(object);

            // Создание JSON файла
            try {
                try (FileWriter file = new FileWriter(config)) {
                    file.write(array.toJSONString().replace("\\/", "/"));
                    file.flush();
                }
            } catch (IOException ex) {
                Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        primaryWindow.setTitle("Camera Player"); // Установка заголовока окна
        primaryWindow.setResizable(false); // Запрет изменения размера окна

        // Создание четырех объектов класса Viewer для отображения видеопотоков с четырех камер
        Viewer view1 = new Viewer(camera1);
        Viewer view2 = new Viewer(camera2);
        Viewer view3 = new Viewer(camera3);
        Viewer view4 = new Viewer(camera4);

        // Создание четырех умных кнопок
        SmartButton button1 = new SmartButton(primaryWindow, 1);
        SmartButton button2 = new SmartButton(primaryWindow, 2);
        SmartButton button3 = new SmartButton(primaryWindow, 3);
        SmartButton button4 = new SmartButton(primaryWindow, 4);
        
        // Создание и заполнение контейнера элементами
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
        
        Scene scene = new Scene(root, 1300, 810, Color.BLACK); // Создание сцены и добавление в нее контейнера
        primaryWindow.setScene(scene); // Установка сцены в окно программы
        primaryWindow.show(); // Отображение окна программы
    }
    
    public static String getConfig() {
        return config;
    }
}
