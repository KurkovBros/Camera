// Класс, реализующий интерфейс Camera

package Camera;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

public class CameraImpl implements Camera {
    
    private Integer camNumber;
    private String encoder;
    private final Group group = new Group();

    @Override
    public void setCamNum(Integer cn) {
        camNumber = cn;
    }

    @Override
    public Integer getCamNum() {
        return camNumber;
    }

    @Override
    public void setEncoder(String enc) {
        encoder = enc;
    }

    @Override
    public String getEncoder() {
        return encoder;
    }

    @Override
    public int getFps() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WritableImage getScreenshot() {
        SnapshotParameters ssp = new SnapshotParameters();
        WritableImage image = group.snapshot(ssp, null);
        File folder = new File("C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Screenshots");
        if (folder.isDirectory()) {
            Date date = new Date();
            File file = new File("C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Camera/Screenshots/Screenshot" + date.toString() + ".png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
            }
        }
        return image;
    }

    @Override
    public void makeScreenshot(String path) {
        SnapshotParameters ssp = new SnapshotParameters();
        WritableImage image = group.snapshot(ssp, null);
        File folder = new File(path);
        if (folder.isDirectory()) {
            Date date = new Date();
            File file = new File(path + "/Screenshot" + date.toString() + ".png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
            }
        }
    }
}
