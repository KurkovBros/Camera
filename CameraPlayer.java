// Видеоплеер

package project_003;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class CameraPlayer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Camera Player");
        Group root = new Group();
        
        Media media = new Media("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Android.mp4");
        final MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        
        root.getChildren().add(view);
        
        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        stage.setScene(scene);
        stage.show();
        
        player.play();
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                
                stage.setMinWidth(w);
                stage.setMinHeight(h);
            }
        });
    }
}
