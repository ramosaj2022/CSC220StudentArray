package csc220;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable
{
    
    //  Controls that appear in the GUI frame.
    @FXML
    TextArea outputArea;
    @FXML
    TextField searchForField;
    
    private OrderByGrade orderByGrade;
    
    private Student[] students;
    private Student[] orderedByGrade;
    
    @FXML
    private void findAs(ActionEvent event){display('A');}
    @FXML
    private void findBs(ActionEvent event){display('B');}
    @FXML
    private void findCs(ActionEvent event){display('C');}
    @FXML
    private void findDs(ActionEvent event){display('D');}
    
    @FXML
    private void searchForByName(ActionEvent event)
    {
        System.out.println("Search for " + searchForField.getText());
    }
            
    private void display(char gradeToFind)
    {
       outputArea.setText("Students achieving an " + gradeToFind + "\n");
       
       Student key = new Student("", gradeToFind);
       
       //  Sequential search
       int start = Student.indexOfFirstMatchingBy(orderedByGrade, key, orderByGrade);
       if (start < 0)  //  Grade not found
           return;
       for (int i = start; i < students.length; i += 1)
       {
           if (orderedByGrade[i].getGrade() != gradeToFind)
               return;
            outputArea.appendText(orderedByGrade[i].getName() + "\n");
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        orderByGrade = new OrderByGrade();
        //  Add some students to the array.
        students = new Student[]
        {
            new Student("Edgar Rice Burroughs", 'B'),
            new Student("Lauren Bacall", 'B'),
            new Student("Tony Blair", 'C'),
            new Student("Isaac Asimov", 'B'),
            new Student("Lena Horne", 'A'),
        };
        orderedByGrade = Arrays.copyOf(students, students.length);
        Student.sortBy(orderedByGrade, orderByGrade);
        System.out.println("Original:         " + Arrays.toString(students));
        System.out.println("Ordered by grade: " + Arrays.toString(orderedByGrade));
    }

    
}
