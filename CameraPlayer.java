// Видеоплеер

package project_003;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
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
//        Group root = new Group(); // Создаем корневой узел
        Group camera1 = new Group();
        Group camera2 = new Group();
        Group camera3 = new Group();
        Group camera4 = new Group();
        Media media1 = new Media("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Baby.mp4");
        Media media2 = new Media("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Crying.mp4");
        Media media3 = new Media("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Slim.mp4");
        Media media4 = new Media("file:///C:/Users/Александр/Documents/NetBeansProjects/Project_003/src/Movies/Alergia.mp4");
        final MediaPlayer player1 = new MediaPlayer(media1);
        final MediaPlayer player2 = new MediaPlayer(media2);
        final MediaPlayer player3 = new MediaPlayer(media3);
        final MediaPlayer player4 = new MediaPlayer(media4);
        MediaView view1 = new MediaView(player1);
        MediaView view2 = new MediaView(player2);
        MediaView view3 = new MediaView(player3);
        MediaView view4 = new MediaView(player4);
        view1.setFitWidth(640);
        view1.setFitHeight(360);
        view2.setFitWidth(640);
        view2.setFitHeight(360);
        view3.setFitWidth(640);
        view3.setFitHeight(360);
        view4.setFitWidth(640);
        view4.setFitHeight(360);
        camera1.getChildren().add(view1);
        camera2.getChildren().add(view2);
        camera3.getChildren().add(view3);
        camera4.getChildren().add(view4);
        FlowPane root = new FlowPane(camera1, camera2, camera3, camera4);
        Scene scene = new Scene(root, 1280, 720, Color.BLACK); // Создаем сцену с корневым узлом
        stage.setScene(scene); // Устанавливаем сцену в окно программы
        stage.show();
        player1.setCycleCount(MediaPlayer.INDEFINITE);
        player1.play();
        player2.setCycleCount(MediaPlayer.INDEFINITE);
        player2.play();
        player3.setCycleCount(MediaPlayer.INDEFINITE);
        player3.play();
        player4.setCycleCount(MediaPlayer.INDEFINITE);
        player4.play();
//        player1.setOnReady(new Runnable() {
//            @Override
//            public void run() {
//                int w = player.getMedia().getWidth();
//                int h = player.getMedia().getHeight();
//                stage.setMinWidth(w);
//                stage.setMinHeight(h);
//            }
//        });
    }
}
