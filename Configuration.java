// Класс, описывающий методы работы с JSON файлом настроек

package Camera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Configuration {
    
    // Создание JSON файла настроек
    public static Map<String, String> createConfig(String config) {
        String camera1 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Baby.mp4";
        String camera2 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Crying.mp4";
        String camera3 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Slim.mp4";
        String camera4 = "file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Movies/Alergia.mp4";
        Map<String, String> map = new HashMap<>();
        JSONArray jArray = new JSONArray();
        JSONObject jObject = new JSONObject();
        jObject.put("Camera #1", camera1);
        map.put("Camera #1", camera1);
        jArray.add(jObject);
        jObject = new JSONObject();
        jObject.put("Camera #2", camera2);
        map.put("Camera #2", camera2);
        jArray.add(jObject);
        jObject = new JSONObject();
        jObject.put("Camera #3", camera3);
        map.put("Camera #3", camera3);
        jArray.add(jObject);
        jObject = new JSONObject();
        jObject.put("Camera #4", camera4);
        map.put("Camera #4", camera4);
        jArray.add(jObject);

        // Создание JSON файла
        try {
            try (FileWriter file = new FileWriter(config)) {
                file.write(jArray.toJSONString().replace("\\/", "/"));
                file.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    // Чтение JSON файла настроек
    public static Map<String, String> readConfig(String config) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(config));
        JSONObject jCamera1 = (JSONObject) array.get(0);
        JSONObject jCamera2 = (JSONObject) array.get(1);
        JSONObject jCamera3 = (JSONObject) array.get(2);
        JSONObject jCamera4 = (JSONObject) array.get(3);
        Map<String, String> map = new HashMap<>();
        map.put("Camera #1", (String) jCamera1.get("Camera #1"));
        map.put("Camera #2", (String) jCamera2.get("Camera #2"));
        map.put("Camera #3", (String) jCamera3.get("Camera #3"));
        map.put("Camera #4", (String) jCamera4.get("Camera #4"));
        return map;
    }
    
    public static void modifyConfig(String inputText, int number) {
        File file = new File(inputText);
        if (file.exists()) {
            try {
                String config = CameraPlayer.getConfig();
                JSONParser parser = new JSONParser();
                JSONArray jArray = (JSONArray) parser.parse(new FileReader(config));
                JSONObject jObject = new JSONObject();
                jObject.put("Camera #" + number, "file:///" + inputText);
                jArray.set(number - 1, jObject);
                File oldFile = new File(config);
                oldFile.delete();
                try (FileWriter newFile = new FileWriter(config)) {
                    newFile.write(jArray.toJSONString().replace("\\/", "/"));
                    newFile.flush();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(SmartButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
