/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import learn2.values.Strings;
import learn2.values.WindowPreferences;

/**
 *
 * @author EQA
 */
public class Learn2 extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VentanaVideo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(Strings.TITLE);
        stage.setMinWidth(WindowPreferences.minWidth);
        stage.setMinHeight(WindowPreferences.minHeight);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
