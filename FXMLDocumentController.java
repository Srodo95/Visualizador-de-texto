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
        File file = new File(tf_archivoPrincipal.getText());
        try (BufferedReader lector = new BufferedReader(new FileReader(file))) {
            boolean eof = false;
            String lineaLeida;
            while (!eof) {
                lineaLeida = lector.readLine();
                if (lineaLeida != null) {
                    System.out.println(lineaLeida);
                    tf_textoArchivo.setText(lineaLeida);
                }else {
                    eof = true;
                }
            }
        }
    }
    
    @FXML
    private void limpiarTexto(ActionEvent event){
        tf_textoArchivo.clear();
    }
    
    @FXML
    private void copiarTexto(ActionEvent event) throws IOException{
        File archivoDestino = new File(tf_archivoDestino.getText());
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoDestino));
        File archivoPrincipal = new File(tf_archivoPrincipal.getText());
        BufferedReader lector = new BufferedReader(new FileReader(archivoPrincipal));
        String linea;
        boolean eof = false;
        while(!eof){
            linea = lector.readLine();
            if(linea != null){
                escritor.write(linea);
            }else{
                eof = true;
            }
        }
        lector.close();
        escritor.close();
    }
    
    @FXML
    private void importarArchivo(ActionEvent event){
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
