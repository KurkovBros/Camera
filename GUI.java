// Класс, экземпляр которого создает окно программы

package Camera;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI {
    
    private final String camera1;
    private final String camera2;
    private final String camera3;
    private final String camera4;
    private final Stage primaryWindow;

    public GUI(String camera1, String camera2, String camera3, String camera4) {
        this.camera1 = camera1;
        this.camera2 = camera2;
        this.camera3 = camera3;
        this.camera4 = camera4;
        primaryWindow = new Stage();
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

    public String getCamera1() {
        return camera1;
    }

    public String getCamera2() {
        return camera2;
    }

    public String getCamera3() {
        return camera3;
    }

    public String getCamera4() {
        return camera4;
    }

    public Stage getPrimaryWindow() {
        return primaryWindow;
    }
}
