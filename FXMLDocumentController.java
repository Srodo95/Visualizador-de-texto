/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizadordetexto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author Rodolfo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField tf_archivoPrincipal;
    @FXML
    private TextArea tf_textoArchivo;
    @FXML
    private TextField tf_archivoDestino;
    
    @FXML
    private Button boton_Buscar;
    private String filename;
    
    @FXML
    private void salir(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML
    private void buscarArchivo(ActionEvent event){
        FileChooser buscar = new FileChooser();
        File archivo = buscar.showOpenDialog(boton_Buscar.getScene().getWindow());

        if (archivo != null) {
            tf_archivoPrincipal.setText(archivo.getAbsolutePath());
            this.filename = archivo.getName();
        }
    }
    
    @FXML
    private void mostrarTexto(ActionEvent event) throws FileNotFoundException, IOException {
        try (FileReader archivo = new FileReader(boton_Buscar.getText())) {
            int caracter;
            while((caracter = archivo.read()) != -1){
                tf_textoArchivo.setText(String.valueOf(caracter));
            }
        }
    }
    
    @FXML
    private void copiarTexto(ActionEvent event){
        
    }
    
    @FXML
    private void importarArchivo(ActionEvent event){
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
