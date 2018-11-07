// Оконный интерфейс видеоплеера
package Camera;

import java.awt.Image;

public interface Camera {

    // Minimum camera number
    int CAM_NUM_MIN = 1;

    // Maximum camera number
    int CAM_NUM_MAX = 9999;

    // Set the camera number in viewport
    void setCamNum(Integer cn, Integer vp);

    // Get the camera number
    Integer getCamNum();

    // Set the encoder stream URI
    void setEncoder(String enc);

    // Get the encoder stream URI
    String getEncoder();

    // Get current FPS
    int getFps();

    // Get the screenshot
    Image getScreenshot();

    // Make the screenshot and save it to the specified path
    void makeScreenshot(String path);
}
