package csc220;

import java.net.URL;
import java.util.Arrays;
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
    
    private Student[] students;
    

    //  The code for readFileButtonAction only reads in the first line of actual data.
    //  Change it so that it reads in ALL the lines.
    //  You will also need to figure out how to handle lines with missing data.
    @FXML
    private void findAs(ActionEvent event){display('A');}
    @FXML
    private void findBs(ActionEvent event){display('B');}
    @FXML
    private void findCs(ActionEvent event){display('C');}
    @FXML
    private void findDs(ActionEvent event){display('D');}
            
    private void display(char gradeToFind)
    {
       outputArea.setText("Students achieving an " + gradeToFind + "\n");
       //  Sequential search
       int start = Student.indexOfFirstMatchingGrade(students, gradeToFind);
       if (start < 0)  //  Grade not found
           return;
       for (int i = start; i < students.length; i += 1)
       {
           if (students[i].getGrade() != gradeToFind)
               return;
            outputArea.appendText(students[i].getName() + "\n");
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //  Add some students to the array.
        students = new Student[]
        {
            new Student("Edgar Rice Burroughs", 'B'),
            new Student("Lauren Bacall", 'B'),
            new Student("Tony Blair", 'C'),
            new Student("Isaac Asimov", 'B'),
            new Student("Lena Horne", 'A'),
        };
        System.out.println(Arrays.toString(students));
        Student.sortByGrade(students);
        System.out.println(Arrays.toString(students));
    }

    
}
