/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chordtestclient;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;

/**
 *
 * @author Ashish
 */
public class FXMLController implements Initializable {
    private File finputfile;
    private File fjarfile;
    
    private Label label;
    @FXML
    private TextField email;
    @FXML
    private TextField inputfile;
    @FXML
    private TextField jarfile;
    @FXML
    private Button inputbutton;
    @FXML
    private Button jarbutton;
    @FXML
    private Button executebutton;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickinputbutton(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser( "." );
        fileChooser.setControlButtonsAreShown(true );
      //  fileChooser.setMultiSelectionEnabled(true);
     // fileChooser.setFileFilter( new FolderFilter() );
     fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int returnVal = fileChooser.showOpenDialog(null);
      
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            fileChooser.getSelectedFile().getName());
       finputfile=fileChooser.getSelectedFile();
       inputfile.setText(finputfile.getAbsolutePath());
    }
    }

    @FXML
    private void onClickjarbutton(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser( "." );
        fileChooser.setControlButtonsAreShown(true );
      //  fileChooser.setMultiSelectionEnabled(true);
     // fileChooser.setFileFilter( new FolderFilter() );
     fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int returnVal = fileChooser.showOpenDialog(null);
      
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            fileChooser.getSelectedFile().getName());
       fjarfile=fileChooser.getSelectedFile();
       jarfile.setText(fjarfile.getAbsolutePath());
       
    }
    }

    @FXML
    private void onClickButton(ActionEvent event) {
        if(email.getText().length()>0){
         Thread t=new Thread(new Filesender(finputfile,fjarfile,email.getText()));
         t.start();
        }
    }
    
}
