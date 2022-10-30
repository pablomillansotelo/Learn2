/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import learn2.values.Strings;
import learn2.values.WindowPreferences;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void actionSumas(){
        abrirVentana("VentanaVideo.fxml");
    }
    @FXML
    private void actionRestas(){
        abrirVentana("VentanaVideoResta.fxml");
    }
    @FXML
    private void actionMultiplicaciones(){
        abrirVentana("VentanaVideoMulti.fxml");
    }
    
    private void abrirVentana(String archivo){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(archivo));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(Strings.TITLE);
            stage.setMinWidth(WindowPreferences.minWidth);
            stage.setMinHeight(WindowPreferences.minHeight);
            stage.setResizable(false); 
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
