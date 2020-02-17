package csc220;

public class OrderBy
{
    public boolean comesAfter(Student s1, Student s2)  //  by grade
    {
        return s1.getGrade() > s2.getGrade();
    }
    
    public boolean matches(Student s1, Student s2)  //  by grade
    {
        return s1.getGrade() == s2.getGrade();
    }
        
}
