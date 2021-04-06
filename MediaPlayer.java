import javafx.application.Application;
import javafx.geometry.Pos;//Used to set the position of the HBox
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;//Timing for the fast forward and rewind button

public class MediaPlayer extends Application
{
    File file = new File("");

    final Label labelFile = new Label();

    public static void main(String[] args)
    {
        launch(args);//Launches application
    }

    @Override
    public void start(Stage primaryStage)
    {
        File songs[] = new File[10];//Array that holds each song
        songs[0] = new File("");
        songs[1] = new File("");
        songs[2] = new File("");
        songs[3] = new File("");
        songs[4] = new File("");
        songs[5] = new File("");
        songs[6] = new File("");
        songs[7] = new File("");
        songs[8] = new File("");
        songs[9] = new File("");

        final Label songLabel = new Label();

         Media[] music = {new Media(songs[0].toURI().toString())};//Media object that loads the songs from the array
         MediaPlayer[] player = new MediaPlayer[]{new MediaPlayer(music[0])};//Takes the loaded songs from the media object and makes them playable

        Button play = new Button("");//Play Button
        Button pause = new Button("");//Pause Button
        Button stop = new Button("");//Stop Button
        Button rewind = new Button("");//Rewind Button
        Button fastForward = new Button("");// Fast Forward Button
        Button selector = new Button("Songs");//Button to choose the song.

            play.setOnAction(event ->//play button action
            {
                player[0].play();
            });

            stop.setOnAction(event ->//Stop button action
            {
                player[0].stop();
            });

            pause.setOnAction(event ->//Pause button action
            {
                player[0].pause();
            });

            rewind.setOnAction(event ->//Rewind button action
            {
                double re = player[0].getCurrentTime().toSeconds();
                re -= 10;
                player[0].seek(new Duration(re*1000));
            });

            fastForward.setOnAction(event ->//Fast forward button action
            {
                double fa = player[0].getCurrentTime().toSeconds();//
                fa += 10;
                player[0].seek(new Duration(fa*1000));
            });

        selector.setOnAction(event ->//Song selector button
        {
            FileChooser chooser = new FileChooser();
            File existDirectory = file.getParentFile();
            chooser.setInitialDirectory(new File("..//FinalProject//Music/"));//sets location to select files
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.mp3", "*.mp3"));//looks for these extensions

            File file = chooser.showOpenDialog(null);
            String path = file.getAbsolutePath();//the path variable is set to the absolute path
            path = path.replace("\\", "/");

            music[0] = new Media(new File(path).toURI().toString());//puts the media from the array into a format that java can understand.
            player[0] = new MediaPlayer(music[0]);
            player[0].stop();

            songLabel.setText("Now Playing: " + file.getName());//adds the title of the song to the title section of the stage.
            primaryStage.setTitle(songLabel.getText());


        });
        // Lines 107-144 sets the sizes of the buttons and adds images to each button
        Image Stop = new Image("");
        ImageView stopView = new ImageView(Stop);
        stopView.setFitHeight(40);
        stopView.setPreserveRatio(true);
        stop.setPrefSize(50,20);
        stop.setGraphic(stopView);

        Image Play = new Image("");
        ImageView playView = new ImageView(Play);
        playView.setFitHeight(40);
        playView.setPreserveRatio(true);
        play.setPrefSize(50,20);
        play.setGraphic(playView);


        Image Pause = new Image("");
        ImageView pauseView = new ImageView(Pause);
        pauseView.setFitHeight(40);
        pauseView.setPreserveRatio(true);
        pause.setPrefSize(50,20);
        pause.setGraphic(pauseView);

        Image Rewind = new Image("");
        ImageView rewindView = new ImageView(Rewind);
        rewindView.setFitHeight(40);
        rewindView.setPreserveRatio(true);
        rewind.setPrefSize(50,20);
        rewind.setGraphic(rewindView);

        Image FF = new Image("");
        ImageView FFView = new ImageView(FF);
        FFView.setFitHeight(40);
        FFView.setPreserveRatio(true);
        fastForward.setPrefSize(50,20);
        fastForward.setGraphic(FFView);

        selector.setPrefSize(100,50);

        // VBox songBox = new VBox(10,song1);
        HBox box = new HBox(10,selector,play,pause,stop,rewind,fastForward);//Virtual box instance
        box.setAlignment(Pos.BOTTOM_CENTER);//Puts buttons at the bottom of the box.
        Scene scene =  new Scene(box);//Scene instances for the VBox instance variable.
        primaryStage.setScene(scene);//Sets the scene in
        primaryStage.show();//Shows the stage.
    }
}






