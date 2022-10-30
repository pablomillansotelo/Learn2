/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import learn2.values.Strings;
import learn2.values.WindowPreferences;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class EjerciciosControllerResta implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button replay, back, practice;
    @FXML
    private ImageView ejercicio0, ejercicio1, ejercicio2, ejercicio3, ejercicio4,
            ejercicio5, ejercicio6, ejercicio7, ejercicio8, ejercicio9;
    @FXML
    private TextField respuesta0, respuesta1, respuesta2, respuesta3, respuesta4,
            respuesta5, respuesta6, respuesta7, respuesta8, respuesta9;
    
    
    int total=0, correctas=0, incorrectas=0;
    String respuestas[];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cargarEjercicios();
        
        practice.setOnAction(e ->{
            calificar();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Puntaje Obtenido");
            alert.setHeaderText("Calificación: "+total);
            alert.setContentText("Correctas: "+ correctas +
                "\n"+ "Incorrectas: "+ incorrectas);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                System.exit(0);
            }
        });
        back.setOnAction(e ->{
            try {
                back.getScene().getWindow().hide();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("VentanaVideoResta.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle(Strings.TITLE);
                stage.setMinWidth(WindowPreferences.minWidth);
                stage.setMinHeight(WindowPreferences.minHeight);
                stage.setResizable(false);
                stage.show(); 
            } catch (IOException ex) {
                Logger.getLogger(VideoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        replay.setOnAction(e -> {
            cargarEjercicios();
            respuesta0.setText("");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta5.setText("");
            respuesta6.setText("");
            respuesta7.setText("");
            respuesta8.setText("");
            respuesta9.setText("");
        });
    }  
    
    private void cargarEjercicios(){
        try {
            String [][] ejerciciosYRespuestas = ejerciciosAleatorios();
            String [] ejercicios = ejerciciosYRespuestas[0];
            respuestas = ejerciciosYRespuestas[1];
            
            ejercicio0.setImage(new Image(new FileInputStream(ejercicios[0])));
            ejercicio1.setImage(new Image(new FileInputStream(ejercicios[1])));
            ejercicio2.setImage(new Image(new FileInputStream(ejercicios[2])));
            ejercicio3.setImage(new Image(new FileInputStream(ejercicios[3])));
            ejercicio4.setImage(new Image(new FileInputStream(ejercicios[4])));
            ejercicio5.setImage(new Image(new FileInputStream(ejercicios[5])));
            ejercicio6.setImage(new Image(new FileInputStream(ejercicios[6])));
            ejercicio7.setImage(new Image(new FileInputStream(ejercicios[7])));
            ejercicio8.setImage(new Image(new FileInputStream(ejercicios[8])));
            ejercicio9.setImage(new Image(new FileInputStream(ejercicios[9])));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjerciciosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void calificar(){
        total += respuesta0.getText().equalsIgnoreCase(respuestas[0])? 1:0;
        total += respuesta1.getText().equalsIgnoreCase(respuestas[1])? 1:0;
        total += respuesta2.getText().equalsIgnoreCase(respuestas[2])? 1:0;
        total += respuesta3.getText().equalsIgnoreCase(respuestas[3])? 1:0;
        total += respuesta4.getText().equalsIgnoreCase(respuestas[4])? 1:0;
        total += respuesta5.getText().equalsIgnoreCase(respuestas[5])? 1:0;
        total += respuesta6.getText().equalsIgnoreCase(respuestas[6])? 1:0;
        total += respuesta7.getText().equalsIgnoreCase(respuestas[7])? 1:0;
        total += respuesta8.getText().equalsIgnoreCase(respuestas[8])? 1:0;
        total += respuesta9.getText().equalsIgnoreCase(respuestas[9])? 1:0;
        correctas = total;
        incorrectas=10-total;
    }
    
    private String[][] ejerciciosAleatorios(){
        String[][] ejerciciostodos = ejercicios();
        String[][] ejercicios10 = new String[2][10]; 
        ArrayList list = new ArrayList();
        int aux = 0; 
        int i=0;
        while(list.size()<10){
            aux= (int) (Math.random()*20);
            if(!list.contains(aux)){
                ejercicios10[0][i]=ejerciciostodos[0][aux];
                ejercicios10[1][i]=ejerciciostodos[1][aux];
                list.add(aux);
                i++;
            }
        }
        return ejercicios10;
    }
    
    private String[][] ejercicios(){
        String[][] ejercicios = new String[2][20];
        ejercicios[0][0]="src\\learn2\\images\\Ejercicio21.jpeg";
        ejercicios[0][1]="src\\learn2\\images\\Ejercicio22.jpeg";
        ejercicios[0][2]="src\\learn2\\images\\Ejercicio23.jpeg";
        ejercicios[0][3]="src\\learn2\\images\\Ejercicio24.jpeg";
        ejercicios[0][4]="src\\learn2\\images\\Ejercicio25.jpeg";
        ejercicios[0][5]="src\\learn2\\images\\Ejercicio26.jpeg";
        ejercicios[0][6]="src\\learn2\\images\\Ejercicio27.jpeg";
        ejercicios[0][7]="src\\learn2\\images\\Ejercicio28.jpeg";
        ejercicios[0][8]="src\\learn2\\images\\Ejercicio29.jpeg";
        ejercicios[0][9]="src\\learn2\\images\\Ejercicio30.jpeg";
        ejercicios[0][10]="src\\learn2\\images\\Ejercicio31.jpeg";
        ejercicios[0][11]="src\\learn2\\images\\Ejercicio32.jpeg";
        ejercicios[0][12]="src\\learn2\\images\\Ejercicio33.jpeg";
        ejercicios[0][13]="src\\learn2\\images\\Ejercicio34.jpeg";
        ejercicios[0][14]="src\\learn2\\images\\Ejercicio35.jpeg";
        ejercicios[0][15]="src\\learn2\\images\\Ejercicio36.jpeg";
        ejercicios[0][16]="src\\learn2\\images\\Ejercicio37.jpeg";
        ejercicios[0][17]="src\\learn2\\images\\Ejercicio38.jpeg";
        ejercicios[0][18]="src\\learn2\\images\\Ejercicio39.jpeg";
        ejercicios[0][19]="src\\learn2\\images\\Ejercicio40.jpeg";
        ejercicios[1][0]="37";
        ejercicios[1][1]="15";
        ejercicios[1][2]="17";
        ejercicios[1][3]="33";
        ejercicios[1][4]="11";
        ejercicios[1][5]="3";
        ejercicios[1][6]="21";
        ejercicios[1][7]="19";
        ejercicios[1][8]="6";
        ejercicios[1][9]="22";
        ejercicios[1][10]="2";
        ejercicios[1][11]="24";
        ejercicios[1][12]="18";
        ejercicios[1][13]="19";
        ejercicios[1][14]="28";
        ejercicios[1][15]="1";
        ejercicios[1][16]="6";
        ejercicios[1][17]="21";
        ejercicios[1][18]="5";
        ejercicios[1][19]="14";
        return ejercicios;
    }  
    
}
