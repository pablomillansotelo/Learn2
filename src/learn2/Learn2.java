/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        //testSuma(stage);
        testResta(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void testSuma(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("VentanaVideo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(Strings.TITLE);
        stage.setMinWidth(WindowPreferences.minWidth);
        stage.setMinHeight(WindowPreferences.minHeight);
        stage.setResizable(false);
        stage.show();
    }
    private void testResta(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("VentanaEjerciciosResta.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(Strings.TITLE);
        stage.setMinWidth(WindowPreferences.minWidth);
        stage.setMinHeight(WindowPreferences.minHeight);
        stage.setResizable(false);
        stage.show();
    }
}
