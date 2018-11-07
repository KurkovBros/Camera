// Класс для отображения видеопотока

package Camera;

import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Viewer {
    
    private final String directory;
    private final Group group;
    
    Viewer(String directory) {
        this.directory = directory;
        group = new Group();
        Media media = new Media(directory);
        final MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        view.setFitWidth(640);
        view.setFitHeight(360);
        group.getChildren().add(view);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.setVolume(0);
        player.play();
    }
    
    public Group getGroup() {
        return group;
    }
}
