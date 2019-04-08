/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movercirculo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author jsoler
 */
public class FXMLcirculogridController implements Initializable {
    
  
    @FXML
    private GridPane miGrid;
    @FXML
    private Circle miCircle;
    
    private int size;
    
    // variables para gestionar la posición del raton respecto a las celdas del grid
//    private static int sizeCol, sizeRow;
//    private IntegerProperty  height_Grid;
//    private IntegerProperty width_Grid;
//    
//    private double celdaX, celdaY;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // incializamos en size el numero de columnas o filas del grid
        size= miGrid.getColumnConstraints().size();
        
//        // variables para conocer el tamaño del grid
//        height_Grid.bind(miGrid.heightProperty());
//        width_Grid.bind(miGrid.widthProperty());
//        sizeCol=size;
//        sizeRow=miGrid.getRowConstraints().size();
    }    

    @FXML
    private void moverCircle(KeyEvent event) {
        KeyCode tecla=event.getCode();
        switch(tecla){
            case UP:
                miGrid.setRowIndex(miCircle,(miGrid.getRowIndex(miCircle)-1+size)%size);
                break;
            case DOWN:
                miGrid.setRowIndex(miCircle,(miGrid.getRowIndex(miCircle)+1+size)%size);
                break;
            case LEFT:
                miGrid.setColumnIndex(miCircle,(miGrid.getColumnIndex(miCircle)-1+size)%size);
                break;
            case RIGHT:
                miGrid.setColumnIndex(miCircle,(miGrid.getColumnIndex(miCircle)+1+size)%size);
                
        }
    }
    
    
    
}
