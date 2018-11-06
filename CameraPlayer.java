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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryWindow) throws IOException, ParseException {
        Map<String, String> map = new HashMap<>();
        File f = new File(config);
        if (f.exists()) {
            map = Configuration.readConfig(config);
        } else {
            Configuration.createConfig(config);
        }
        
        GUI gui = new GUI(map.get("Camera #1"), map.get("Camera #2"), map.get("Camera #3"), map.get("Camera #4"));
        
        if (SmartButton.isIsConfigModified()) {
            gui.getPrimaryWindow().close();
            gui = new GUI(map.get("Camera #1"), map.get("Camera #2"), map.get("Camera #3"), map.get("Camera #4"));
        }
    }
    
    public static String getConfig() {
        return config;
    }
}
