package csc220;

public class Student
{
    private String name;
    private int id;
    private char grade;
    
    private static int nextId = 1;
    
    public Student(String name, char grade)
    {
        id = nextId;
        nextId += 1;
        this.name = name; 
        this.grade = grade;
    }
    
    public int getId(){return id;}
    public String getName(){return name;}
    public char getGrade(){return grade;}
    
}
