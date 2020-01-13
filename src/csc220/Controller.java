package csc220;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Controller implements Initializable
{
    
    //  Controls that appear in the GUI frame.
    @FXML
    TextArea outputArea;
    

    //  The code for readFileButtonAction only reads in the first line of actual data.
    //  Change it so that it reads in ALL the lines.
    //  You will also need to figure out how to handle lines with missing data.
    @FXML
    private void runButtonAction(ActionEvent event) 
    {
       outputArea.setText("Button pressed");      
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //  Initialization code here.
    }

    
}
