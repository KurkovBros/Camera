// Основной класс программы

package Camera;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

public class CameraPlayer extends Application {
    
    public static String config = "C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/config.json";
    private static GUI gui;
    private static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryWindow) throws IOException, ParseException {
        File f = new File(config);
        if (f.exists()) {
            map = Configuration.readConfig(config);
        } else {
            map = Configuration.createConfig(config);
        }
        gui = new GUI();
    }
    
    public static String getConfig() {
        return config;
    }

    public static GUI getGui() {
        return gui;
    }

    public static Map<Integer, String> getMap() {
        return map;
    }
}
