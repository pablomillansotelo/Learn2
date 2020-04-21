/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn2;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.collections.ObservableMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaMarkerEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import learn2.values.Strings;
import learn2.values.WindowPreferences;


/**
 * FXML Controller class
 *
 * @author EQA
 */
public class VideoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button play, pause, replay, exit, practice;
    @FXML
    private Label actual_time, total_time, actual_volumen;
    @FXML
    private Slider slider_time, volumen;
    @FXML
    private MediaView view;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Media media = new Media(VideoController.class.getResource("videos/video01.mp4").toExternalForm());
        media.setOnError(() -> System.out.println("Media: " + media.getError().getMessage()));

        MediaPlayer player = new MediaPlayer(media);
        player.setOnError(() -> System.out.println("MediaPlayer: " + player.getError().getMessage()));
        
        ObservableMap<String, Duration> markers = media.getMarkers();
        markers.put("START", Duration.ZERO);
        markers.put("INTERVAL", Duration.minutes(0.8));
        markers.put("END", media.getDuration());

        player.setOnMarker((MediaMarkerEvent e) -> {
            Pair<String, Duration> marker = e.getMarker();
            String markerText = marker.getKey();
            Duration markerTime = marker.getValue();
        });

        view.setMediaPlayer(player);
        
        player.setOnReady(() -> {

            total_time.setText(String.format("%.2f", player.getTotalDuration().toMinutes()));     
            slider_time.setMax(player.getTotalDuration().toSeconds());
            
            slider_time.valueProperty().addListener((p, o, value) -> {
                if (slider_time.isPressed()) {
                    player.seek(Duration.seconds(value.doubleValue()));
                }
            });

            player.currentTimeProperty().addListener((p, o, value) -> {
                slider_time.setValue(value.toSeconds());
                actual_time.setText(String.format("%.2f", value.toMinutes()));
            });
            
            player.play();
        });
        
        
        player.volumeProperty().bind(volumen.valueProperty());
        actual_volumen.textProperty().bind(player.volumeProperty().multiply(100.0).asString("%.2f %%"));
        play.setOnAction(e -> player.play());
        pause.setOnAction(e -> player.pause());
        replay.setOnAction(e -> {
            player.stop();            
        });
        exit.setOnAction(e ->{
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText("Confirmación de salida");
            alert.setContentText("¿Está seguro que desea salir de la apliación?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                System.exit(0);
            } else {
                alert.close();
            }
        });
        practice.setOnAction(e ->{
            try {
                practice.getScene().getWindow().hide();
                player.stop();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("VentanaEjercicios.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle(Strings.TITLE);
                stage.setMinWidth(WindowPreferences.minWidth);
                stage.setMinHeight(WindowPreferences.minHeight);
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(VideoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    } 
}
