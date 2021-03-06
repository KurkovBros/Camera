// Оконный интерфейс видеоплеера
package Camera;

import javafx.scene.image.WritableImage;

public interface Camera {

    // Minimum camera number
    int CAM_NUM_MIN = 1;

    // Maximum camera number
    int CAM_NUM_MAX = 9999;

    // Set the camera number
    void setCamNum(Integer cn);

    // Get the camera number
    Integer getCamNum();

    // Set the encoder stream URI
    void setEncoder(String enc);

    // Get the encoder stream URI
    String getEncoder();

    // Get current FPS
    int getFps();

    // Get the screenshot
    WritableImage getScreenshot();

    // Make the screenshot and save it to the specified path
    void makeScreenshot(String path);
}
